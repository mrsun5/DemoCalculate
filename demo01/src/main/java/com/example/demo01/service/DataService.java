package com.example.demo01.service;

import com.example.demo01.entity.DataEntity;

import java.util.List;

public interface DataService {
    List<DataEntity> getAll();

//    DataEntity getEntiyByUserName

    List<DataEntity> getByPage(int limit, int offset);

    void addRow(DataEntity dataEntity);

    void updateByUserName(DataEntity dataEntity);

    void deleteRowByUserName(String Username);

}

