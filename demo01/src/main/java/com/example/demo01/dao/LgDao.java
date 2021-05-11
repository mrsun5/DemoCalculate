package com.example.demo01.dao;

import com.example.demo01.entity.LgEntity;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface LgDao {
    LgEntity checkUserNamePwd(String username, String password);
}
