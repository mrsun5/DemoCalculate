package com.example.demo01.controller;

import com.example.demo01.entity.DataEntity;
import com.example.demo01.entity.UserEntity;
import com.example.demo01.service.LoginService;
import com.example.demo01.utils.ResultUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.DigestUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/user")
public class LoginController {
    @Autowired
    private LoginService loginServiceImpl;

    //登錄，判斷密碼是否為空
    @RequestMapping("/login")
    public ResultUtils<String> Login(String username, String password){

        UserEntity userEntity= loginServiceImpl.getAllByUserName(username);
        String md5Password = DigestUtils.md5DigestAsHex(password.getBytes());
        if(userEntity== null){
            return ResultUtils.error("400","用户名错误");
        }
        else
            if(userEntity.getPassword().equals(md5Password)){

//                RedisUtils.put(userEntity.getUsername(), JSON.toJSONString(userEntity));
            return ResultUtils.pass("登录成功",userEntity);
        }
        else{return ResultUtils.error("500","密码错");}
    }

    @RequestMapping("/register")
    public ResultUtils register(String username, String password){
        UserEntity userEntity=loginServiceImpl.getAllByUserName(username);
        if(userEntity!=null){
            return ResultUtils.error("500","用户名已存在");
        }
        else {
            String md5Password = DigestUtils.md5DigestAsHex(password.getBytes());
            loginServiceImpl.addUser(username,md5Password);
            return ResultUtils.pass("添加成功",userEntity.getUsername());
        }
    }

    @RequestMapping("/deleteUser")
    public ResultUtils deleteUser(String username,String password){
        String md5Password = DigestUtils.md5DigestAsHex(password.getBytes());
        UserEntity userEntity=loginServiceImpl.getAllByUserName(username);
        if(md5Password.matches(userEntity.getPassword())){
            loginServiceImpl.deleteRow(username);
            return ResultUtils.pass("删除成功","null");
        }
        else return ResultUtils.error("500","密码错");
    }

    //根据用户名进行customer表与user表的连接查询,如果输入整数a不为空则内连接输出department信息，否则左连接输出age与password信息
    @RequestMapping("/findByJoin")
    public List<Map<String,Object>> findByJoin(Integer a){
        //返回department信息
        if(a ==null){
        return loginServiceImpl.findDepartment();}
        //返回age与department信息
        else{return loginServiceImpl.findAgePassword();}
    }








    //检验是否合规
//       ResultObject<String> errmsg=ResultObject.test( loginServiceImpl.verifyMassage(username,password));
//    if(errmsg !=null){
//        return errmsg;
//    }else{

//
//                password.equals(userEntity.getPassword()){}
//
//        userName_mysql  =
//
//        //验证密码
//        if("test".equals(username)){
////            RedisUtils.put(userEntity.getUsername(), JSON.toJSONString(userEntity));
//            return ResultUtils.pass("登錄成功",userEntity);
//        }
//        return ResultUtils.error("400","登錄錯誤");
////    }
    //状态获取

    UserEntity userEntity = null;
    @RequestMapping("/status")
    public ResultUtils<UserEntity> status(String username){
//        String user = RedisUtils.get(username);
//        userEntity = JSON.parseObject(user,UserEntity.class);
        return ResultUtils.pass("狀態獲取成功",userEntity);}
    //退出登录
    @RequestMapping("/logout")
    public ResultUtils<String> logout(){return ResultUtils.pass("退出登錄",null);}

}
