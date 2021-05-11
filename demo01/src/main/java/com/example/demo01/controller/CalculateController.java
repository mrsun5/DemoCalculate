package com.example.demo01.controller;


import com.example.demo01.entity.PlantingsEntity;
import com.example.demo01.service.CalculateService;
import com.example.demo01.utils.RestResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.text.SimpleDateFormat;
import java.util.Date;

@RestController
@RequestMapping("/calculate")
public class CalculateController {

    @Autowired
    private CalculateService calculateServiceImpl;

    /**
     * 充值接口
     * @param recharge
     * @param rechargedate
     * @return
     */
    @RequestMapping("/Purchase")
    public RestResponse Purchase(@RequestParam("recharge") String recharge,
                                 @RequestParam("rechargedate") Date rechargedate){

    calculateServiceImpl.inputPurchase(recharge,rechargedate);
    return RestResponse.success(200,"充值录入成功");
    }

    /**
     * 种植新植物接口
     * @param plant
     * @return
     */
    @RequestMapping("/Planting")
    public RestResponse Planting (@RequestBody PlantingsEntity plant){

        calculateServiceImpl.inputPlanting(plant);
        return RestResponse.success(200,"种植信息录入成功");
    }

    /**
     * 添加维护日
     * @param Maintenance
     * @return
     */
    @RequestMapping("/MaintenanceToday")
    public RestResponse MaintenanceToday (@RequestParam("Maintenance") Date Maintenance){
        String MaintenanceDay = new String();
        if(Maintenance == null){
            Date today = new Date();
            SimpleDateFormat Day = new SimpleDateFormat("yyyy-MM-dd");
            MaintenanceDay = Day.format(today); }
        else{
            SimpleDateFormat Day = new SimpleDateFormat("yyyy-MM-dd");
            MaintenanceDay = Day.format(Maintenance);
        }
        calculateServiceImpl.Maintenance(MaintenanceDay);
        return RestResponse.success(200,"维护添加成功");
    }


}
