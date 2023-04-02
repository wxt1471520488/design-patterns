package com.wangxt.design.patterns.pay.strategy;

import com.wangxt.design.patterns.pay.pojo.PayBody;

public class ZfbPayStrategy implements PayStrategy{

    @Override
    public Boolean pay(PayBody payBody) {
        return true;
    }
}
