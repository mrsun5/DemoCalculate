package com.example.demo01.dao;

import com.example.demo01.entity.DataEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface DataDao {
    List<DataEntity> getAll();


    List<DataEntity> getByPage(@Param("limit") int limit, @Param("offset") int offset, @Param("datatype") String databaseType);

    void addRow(DataEntity dataEntity);

    void deleteRowByUserName(String username);

    void updateByUserName(DataEntity dataEntity);
}
