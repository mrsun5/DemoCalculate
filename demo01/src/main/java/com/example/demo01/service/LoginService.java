package com.example.demo01.service;

import com.example.demo01.entity.UserEntity;

import java.util.List;
import java.util.Map;

public interface LoginService {

    UserEntity getAllByUserName(String username);

    Void deleteRow(String username);

    Void addUser(String username, String password);

    List<Map<String, Object>> findDepartment();

    List<Map<String, Object>> findAgePassword();


//    String verifyMassage(String username, String password);
}
