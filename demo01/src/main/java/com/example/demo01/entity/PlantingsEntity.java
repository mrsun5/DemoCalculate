package com.example.demo01.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import org.springframework.beans.factory.annotation.Value;

import java.math.BigDecimal;
import java.util.Date;

@Data
@TableName("plantings")
public class PlantingsEntity {

    private Integer id;
    private String plant_name;
    @Value("${some.key:0}")
    private BigDecimal total_less_yield;
    private BigDecimal estimate_all_callback_income;
    private Integer plant_number;
    private Date plant_date;
    private Date estimate_pullout_date;
    private String maintain_date;
    private String is_pullout;
    @Value("${some.key:0}")
    private int maintenance_daycount;
}
