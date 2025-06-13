package org.example.teststub.dbWorker;

import org.example.teststub.dto.User;
import org.example.teststub.exception.UserNotFoundException;
import org.springframework.stereotype.Component;

import java.sql.*;

@Component
public class DataBaseWorker {
    private static final String URL = "jdbc:postgresql://192.168.0.102:5432/mydb";
    private static final String USER = "user";
    private static final String PASSWORD = "password";

    public User getUserByLogin(String login) throws UserNotFoundException, SQLException {
        String query = "SELECT u.login, e.email, u.password, u.date "
                + "FROM users u JOIN emails e ON u.login = e.login "
                + "WHERE u.login = ?";

        try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement statement = connection.prepareStatement(query)) {

            statement.setString(1, login);

            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    return new User(
                            resultSet.getString("login"),
                            resultSet.getString("password"),
                            resultSet.getString("email"),
                            resultSet.getTimestamp("date").toLocalDateTime());
                } else {
                    throw new UserNotFoundException("User '" + login + "' not found");
                }
            }
        }
    }

    public int insertUser(User user) throws SQLException {
        String query = "INSERT INTO users (login, password, date) VALUES (?, ?, ?); "
                + "INSERT INTO emails (login, email) VALUES (?, ?)";

        try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {

            preparedStatement.setString(1, user.getLogin());
            preparedStatement.setString(2, user.getPassword());
            preparedStatement.setObject(3, Timestamp.valueOf(user.getDate()));
            preparedStatement.setString(4, user.getLogin());
            preparedStatement.setString(5, user.getEmail());

            return preparedStatement.executeUpdate();
        }
    }
}
