package org.example.teststub;

//Data Transfer Object - это простые классы для передачи данных между клиентом и сервером.
public class PostRequest {
    private String login;
    private String password;

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
