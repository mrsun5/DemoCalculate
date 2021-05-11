package com.example.demo01.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.math.BigDecimal;

@Data
@TableName("seeds")
public class SeedsEntity {

    private Integer seeds_id;
    private String plant_name;
    private BigDecimal per_plant_price;
    private BigDecimal call_back_price;
    private BigDecimal yield;
    private Integer grow_date;
    private Integer fruit_date;
    private Integer estimate_pullout_date;
    private BigDecimal estimate_all_callback_income;


}
