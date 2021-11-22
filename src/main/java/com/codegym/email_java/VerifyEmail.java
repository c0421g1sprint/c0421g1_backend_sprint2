package com.codegym.email_java;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class VerifyEmail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable =  false)
    private String token;
    @Column(nullable =  false)
    private String email;
    @Column(nullable =  false)
    private LocalDateTime createAt;
    @Column(nullable =  false)
    private LocalDateTime expireAt;
    private LocalDateTime confirmAt;

    public VerifyEmail(String token, String email, LocalDateTime createAt, LocalDateTime expireAt) {
        this.token = token;
        this.email = email;
        this.createAt = createAt;
        this.expireAt = expireAt;
    }
}
