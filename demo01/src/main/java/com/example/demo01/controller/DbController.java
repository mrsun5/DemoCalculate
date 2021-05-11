package com.example.demo01.controller;

import com.example.demo01.entity.DataEntity;
import com.example.demo01.service.DataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/data")
public class DbController {
    @Autowired
    private DataService dataServiceImpl;
    //查全部
    @GetMapping("/getAll")
    public List<DataEntity> getAll(){
        return dataServiceImpl.getAll();
    }
    //
    @GetMapping("/getByPage")
    public List<DataEntity> getByPage(int limit, int offset){
        return dataServiceImpl.getByPage(limit, offset);
    }
    //增加一条
    @RequestMapping("/addRow")
    public void addRow(DataEntity dataEntity){dataServiceImpl.addRow(dataEntity);}
    //更新记录
    @RequestMapping("/updateByUserName")
    public void updateByUserName(DataEntity dataEntity){dataServiceImpl.updateByUserName(dataEntity);}
    //删一条
    @RequestMapping("/deleteRowByUserName")
    public void deleteRowByUserName(String Username){dataServiceImpl.deleteRowByUserName(Username);}
}
