package com.example.demo01.service;

import com.example.demo01.entity.LgEntity;

public interface LgService {
    LgEntity checkUserNamePwd(String username, String password);
}
