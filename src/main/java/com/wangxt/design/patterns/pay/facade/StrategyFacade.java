package com.wangxt.design.patterns.pay.facade;

import com.wangxt.design.patterns.pay.context.PayContext;
import com.wangxt.design.patterns.pay.enumx.StrategyEnum;
import com.wangxt.design.patterns.pay.factory.StrategyFactory;
import com.wangxt.design.patterns.pay.pojo.PayBody;
import com.wangxt.design.patterns.pay.strategy.PayStrategy;

import java.util.Objects;

public class StrategyFacade {

    public static Boolean pay(PayBody payBody){
        StrategyEnum strategyEnum = StrategyEnum.get(payBody.getType());
        if(Objects.isNull(strategyEnum)){
            return false;
        }

        PayStrategy payStrategy = StrategyFactory.getPayStrategy(strategyEnum);

        PayContext context = new PayContext(payStrategy);

        return context.execute(payBody);
    }
}
