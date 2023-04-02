package com.wangxt.design.patterns.pay.strategy;

import com.wangxt.design.patterns.pay.pojo.PayBody;

public class WcPayStrategy implements PayStrategy{

    @Override
    public Boolean pay(PayBody payBody) {
        return true;
    }
}
