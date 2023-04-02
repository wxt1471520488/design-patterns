package com.wangxt.design.patterns.service;

import com.wangxt.design.patterns.pay.context.PayContext;
import com.wangxt.design.patterns.component.PayHandler;
import com.wangxt.design.patterns.pay.enumx.StrategyEnum;
import com.wangxt.design.patterns.pay.facade.StrategyFacade;
import com.wangxt.design.patterns.pay.factory.StrategyFactory;
import com.wangxt.design.patterns.pay.pojo.PayBody;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PayServiceImpl implements PayService{

    @Autowired
    private PayHandler payHandler;

    @Override
    public Boolean pay(PayBody payBody) {
        Boolean flag = false;

        /*if(payBody.getType() == 0){
            //flag = payHandler.zfbPay(payBody);
            //flag = new PayContext(new ZfbPayStrategy()).execute(payBody);
            flag = new PayContext(StrategyFactory.getPayStrategy(StrategyEnum.ZFB)).execute(payBody);
        }else if(payBody.getType() == 1){
            //flag = payHandler.wcPay(payBody);
            //flag = new PayContext(new WcPayStrategy()).execute(payBody);
            flag = new PayContext(StrategyFactory.getPayStrategy(StrategyEnum.WC)).execute(payBody);
        }else {
            throw new UnsupportedOperationException();
        }*/

        flag = StrategyFacade.pay(payBody);

        if(flag){
            saveToDb(payBody);
        }

        return flag;
    }

    private void saveToDb(PayBody payBody) {

    }
}
