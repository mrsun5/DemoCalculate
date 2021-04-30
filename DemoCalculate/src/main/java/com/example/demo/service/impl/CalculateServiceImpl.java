package com.example.demo.service.impl;

import com.example.demo.service.CalculateService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class CalculateServiceImpl implements CalculateService {
    @Resource
    private CalculateDao calculateDao;


}
