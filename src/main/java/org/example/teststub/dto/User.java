package org.example.teststub.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;

import java.text.SimpleDateFormat;
import java.util.Date;

@Getter
public class User {
    @NotBlank(message = "Login cannot be blank")
    private String login;
    @NotBlank(message = "Password cannot be blank")
    private String password;
    private String date;

    public User(String login, String password) {
        this.login = login;
        this.password = password;
        this.date = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
    }
}
