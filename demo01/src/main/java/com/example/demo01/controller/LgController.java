package com.example.demo01.controller;

import com.example.demo01.entity.LgEntity;
import com.example.demo01.service.LgService;
import com.example.demo01.utils.ResultUtils;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class LgController {
    @Autowired
    private LgService lgService;

    @PostMapping("/Lg")
    public ResultUtils<String> Lg(@Param("username") String username,@Param("password") String password){
        LgEntity lgEntity =lgService.checkUserNamePwd(username, password);
        if(lgEntity ==null){
            return ResultUtils.error("001","登录信息错误");
        }
        else{
            return ResultUtils.pass("登陆成功",lgEntity);
        }
    }
}
