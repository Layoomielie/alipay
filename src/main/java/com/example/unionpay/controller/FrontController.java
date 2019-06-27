package com.example.unionpay.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author：张鸿建
 * @time：2019/6/26 17:36
 * @desc：
 **/
@RestController
public class FrontController {

    @RequestMapping("/font")
    public String frontTest(){
        System.out.println(" 前台返回地址  。。。。。。。。");
        return "前台返回地址";
    }
}
