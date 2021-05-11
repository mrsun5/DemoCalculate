package com.example.demo01.service;


import com.example.demo01.entity.PlantingsEntity;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public interface CalculateService {

    void inputPurchase(String recharge, Date rechargedate);

    void inputPlanting(PlantingsEntity plant);

    void Maintenance(String maintenanceDay);
}
