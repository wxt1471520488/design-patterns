package com.wangxt.design.patterns.pay.strategy;

import com.wangxt.design.patterns.pay.pojo.PayBody;

public interface PayStrategy {

    Boolean pay(PayBody payBody);
}
