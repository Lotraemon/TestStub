package org.example.teststub;

import java.text.SimpleDateFormat;
import java.util.Date;

public class PostResponse {
    private String login;
    private String password;
    private String date;

    public PostResponse(String login, String password) {
        this.login = login;
        this.password = password;
        this.date = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
    }

    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return password;
    }

    public String getDate() {
        return date;
    }
}
