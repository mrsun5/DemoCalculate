package com.example.demo01.service.impl;

import com.example.demo01.dao.DataDao;
import com.example.demo01.entity.DataEntity;
import com.example.demo01.entity.UserEntity;
import com.example.demo01.service.DataService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class DataServiceImpl implements DataService {

    @Resource
    private DataDao dataDao;
    private String databaseType;



    @Override
    public List<DataEntity> getAll(){
        return dataDao.getAll();
    }
    @Override
    public List<DataEntity> getByPage(int limit, int offset) {
        return dataDao.getByPage(limit, offset, databaseType);
    }

    @Override
    public void addRow(DataEntity dataEntity){
        dataDao.addRow(dataEntity);
    }

    @Override
    public void updateByUserName(DataEntity dataEntity){
        dataDao.updateByUserName(dataEntity);
    }

    @Override
    public void deleteRowByUserName(String Username){
        dataDao.deleteRowByUserName(Username);
    }
}
