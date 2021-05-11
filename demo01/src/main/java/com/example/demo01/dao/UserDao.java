package com.example.demo01.dao;

import com.example.demo01.entity.UserEntity;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface UserDao {
    UserEntity getAllByUserName(String username);

    void addUser(String username, String password);

    void deleteRow(String username);

    List<Map<String,Object>> findDepartment();

    List<Map<String, Object>> findAgePassword();
}
