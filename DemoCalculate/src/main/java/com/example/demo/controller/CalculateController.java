package com.example.demo.controller;

import com.example.common.utils.RestResponse;
import com.example.demo.service.CalculateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("calculate")
public class CalculateController {
    @Autowired
    private CalculateService calculateServiceImpl;

    @RequestMapping("Purchase")
    public RestResponse Purchase(){

    }

}
