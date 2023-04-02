package com.wangxt.design.patterns.pay.context;

import com.wangxt.design.patterns.pay.strategy.PayStrategy;
import com.wangxt.design.patterns.pay.pojo.PayBody;

public class PayContext {

    private PayStrategy payStrategy;

    public PayContext(PayStrategy payStrategy){
        this.payStrategy = payStrategy;
    }

    public Boolean execute(PayBody payBody){
        return this.payStrategy.pay(payBody);
    }
}
