package com.example.demo01.service.impl;


import com.example.demo01.dao.CalculateDao;
import com.example.demo01.entity.PlantingsEntity;
import com.example.demo01.entity.SeedsEntity;
import com.example.demo01.service.CalculateService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.UUID;

@Service
public class CalculateServiceImpl implements CalculateService {
    @Resource
    private CalculateDao calculateDao;


    @Override
    public void inputPurchase(String recharge, Date rechargedate) {

        calculateDao.inputPurchase(recharge,rechargedate);
    }

    @Override
    public void inputPlanting(PlantingsEntity plant) {

        //查询本植株数据信息
         SeedsEntity seedsEntity = calculateDao.getSeedsInfo(plant.getPlant_name());

         if(seedsEntity!= null){
        try{
        //计算预期收入ESTIMATE_ALL_CALLBACK_INCOME
            BigDecimal plantnumber = new BigDecimal(plant.getPlant_number());
            if(plantnumber!=null && seedsEntity.getCall_back_price()!=null && seedsEntity.getYield()!=null ){
        BigDecimal estimateallcallbackincome = seedsEntity.getCall_back_price().multiply(seedsEntity.getYield().multiply(plantnumber));
        plant.setEstimate_all_callback_income(estimateallcallbackincome);}

        //计算预计拔苗日期ESTIMATE_PULLOUT_DATE
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(plant.getPlant_date());
            //获取总生长日期
            if(seedsEntity.getEstimate_pullout_date()!=null){
                int day = seedsEntity.getEstimate_pullout_date();
        calendar.add(Calendar.DATE,(day-plant.getMaintenance_daycount()));
        Date estimateDt = calendar.getTime();
        plant.setEstimate_pullout_date(estimateDt);

        //设置是否拔苗IS_PULLOUT
        Date now = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String nowString = sdf.format(now);
        Date nowdtformat = sdf.parse(nowString);
        if(nowdtformat.after(estimateDt)){
            plant.setIs_pullout("ispulledout");
        }}
        else {plant.setIs_pullout("isnotpulledout");}

        } catch (ParseException e) {
            e.printStackTrace();
        }
         }
        calculateDao.inputPlanting(plant);
    }

    @Override
    public void Maintenance(String maintenanceDay) {

    }
}
