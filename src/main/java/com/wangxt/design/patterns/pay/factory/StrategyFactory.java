package com.wangxt.design.patterns.pay.factory;

import com.wangxt.design.patterns.pay.enumx.StrategyEnum;
import com.wangxt.design.patterns.pay.strategy.PayStrategy;

public class StrategyFactory {

    public static PayStrategy getPayStrategy(StrategyEnum strategyEnum){
        PayStrategy payStrategy = null;

        try{
            payStrategy = (PayStrategy) Class.forName(strategyEnum.getValue()).newInstance();
        }catch (Exception e){
            e.printStackTrace();
        }
        return payStrategy;
    }
}
