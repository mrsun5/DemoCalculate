package com.example.demo01.entity;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;


@Data
@Getter
@Setter
@ToString
public class UserEntity {

    private String username;
    private String password;
}
