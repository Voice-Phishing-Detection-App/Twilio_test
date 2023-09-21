package com.example.user;

import lombok.Getter;
import org.springframework.data.annotation.Id;

import javax.persistence.*;


@Entity
@Table(name = "`user`")
@Getter
public class UserEntity {

    @javax.persistence.Id
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Long userId;

//    @Column(name = "name", nullable = false, length = 50)
//    private String name;
//
//    @Column(name = "id", nullable = false, length = 50)
//    private String id;
//
//    @Column(name = "password", nullable = false, length = 100)
//    private String password;

    @Column(name = "phone_number", nullable = false, length = 20)
    private String phoneNumber;

    @Column(name = "fcm_token", nullable = false)
    private String fcmToken;
}

