package com.example.demo01.service.impl;

import com.example.demo01.dao.UserDao;
import com.example.demo01.entity.UserEntity;
import com.example.demo01.service.LoginService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@Service
public class LoginServiceImpl implements LoginService {
    @Resource
    UserDao userDao;
//    Pattern passwordPattern = Pattern.compile("[0~9a~z]");

    @Override
    public UserEntity getAllByUserName(String username){
        return userDao.getAllByUserName(username);
    }

    @Override
    public Void addUser(String username, String password){
        userDao.addUser(username, password);
        return null;
    }

    @Override
    public Void deleteRow(String username){
        userDao.deleteRow(username);
        return null;
    }

    @Override
    public List<Map<String, Object>> findDepartment(){
        return userDao.findDepartment();
    }

    @Override
    public List<Map<String,Object>> findAgePassword(){
        return userDao.findAgePassword();
    }





//
//    @Override
//    public String verifyMassage(String username, String password) {
//
//        String msg = null;
//        if(StringUtils.hasText(username)){
//            msg = "请输入用户名";
//        }
//        else if (StringUtils.hasText(password)){
//            msg="请输入密码";
//        }
////        else if(passwordPattern.matcher(password).matches()){
////            msg = "密码不符合要求";
////        }
//        return msg;
//    }


}
