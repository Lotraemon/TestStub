package org.example.teststub.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class User {
    @NotBlank(message = "Login cannot be blank")
    @Size(min = 3, max = 20, message = "Login must be >3 & <20")
    private String login;
    @NotBlank(message = "Password cannot be blank")
    private String password;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime date;
    @NotBlank(message = "Email cannot be blank")
    private String email;

    public User(String login, String password, String email, LocalDateTime date) {
        this.login = login;
        this.password = password;
        this.date = LocalDateTime.now();
        this.email = email;
    }
}
