package com.example.demo01.service.impl;

import com.example.demo01.dao.LgDao;
import com.example.demo01.entity.LgEntity;
import com.example.demo01.service.LgService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class LgServiceImpl implements LgService {
    @Resource
    LgDao lgDao;

    @Override
    public LgEntity checkUserNamePwd(String username,String password){
        return lgDao.checkUserNamePwd(username,password);
    }
}
