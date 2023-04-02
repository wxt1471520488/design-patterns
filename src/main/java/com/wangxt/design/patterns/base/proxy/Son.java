package com.wangxt.design.patterns.base.proxy;

public class Son implements Father{

    @Override
    public void eat() {
        System.out.println("吃饭");
    }
}
