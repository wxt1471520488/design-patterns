package com.wangxt.design.patterns.controller;

import com.wangxt.design.patterns.pay.pojo.PayBody;
import com.wangxt.design.patterns.service.PayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController()
public class PayController {

    @Autowired
    private PayService payService;

    @RequestMapping("/pay")
    public String pay(@RequestBody PayBody payBody){
        Boolean pay = payService.pay(payBody);
        return String.format("支付用户：%s , 支付类型：%s , 支付结果：%s", payBody.getUid(), payBody.getType(), pay);
    }
}
