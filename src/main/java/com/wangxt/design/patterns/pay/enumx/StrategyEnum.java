package com.wangxt.design.patterns.pay.enumx;

import java.util.Arrays;

public enum StrategyEnum {
    ZFB("com.wangxt.design.patterns.pay.strategy.ZfbPayStrategy", 0),
    WC("com.wangxt.design.patterns.pay.strategy.WcPayStrategy", 1);

    String value;
    int type;

    StrategyEnum(String value, int type){
        this.value = value;
        this.type = type;
    }

    public String getValue(){
        return this.value;
    }

    public int getType(){
        return this.type;
    }

    public static StrategyEnum get(int type){
        return Arrays.stream(StrategyEnum.values()).filter(e -> e.getType() == type).findFirst().orElse(null);
    }
}
