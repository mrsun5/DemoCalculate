package com.example.demo01.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.util.Date;

@Data
@TableName("recharge")
public class RechargeEntity {

    private Integer id;
    private String recharge;
    private Date recharge_date;

}
