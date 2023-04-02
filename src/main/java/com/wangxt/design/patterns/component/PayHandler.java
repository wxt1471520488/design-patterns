package com.wangxt.design.patterns.component;

import com.wangxt.design.patterns.pay.pojo.PayBody;
import org.springframework.stereotype.Component;

@Component
public class PayHandler {

    public Boolean zfbPay(PayBody payBody) {
        return true;
    }

    public Boolean wcPay(PayBody payBody) {
        return true;
    }
}
