package com.example.demo01.dao;

import com.example.demo01.entity.PlantingsEntity;
import com.example.demo01.entity.SeedsEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;

@Mapper
@Repository
public interface CalculateDao {
    void inputPlanting(@Param("plant") PlantingsEntity plant);

    void inputPurchase(@Param("recharge") String recharge,@Param("rechargedate") Date rechargedate);

    SeedsEntity getSeedsInfo(@Param("plantname") String plantname);

}
