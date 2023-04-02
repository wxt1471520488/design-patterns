package com.wangxt.design.patterns.base.proxy;

import sun.misc.ProxyGenerator;

import java.io.IOException;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.nio.file.Files;
import java.nio.file.Paths;

public class ProxyTest {

    public static void main(String[] args) {
        ProxyTest test = new ProxyTest();
        test.write();
    }

    private void jdkProxy(){
        Father son = new Son();

        //Class.forName();

        /*
        这里需要注意几点
        1.Proxy.newProxyInstance返回的是一个继承了Proxy抽象类并且实现了代理对象实现的接口的代理类对象，所以这里强转成代理类会报错
        2.因为生成的代理对象继承了Proxy类，所以jdk动态代理无法代理实现类，java中是单继承的
        3.newProxyInstance方法传入的是被代理对象的类加载器和接口列表,这里不一定是对象的类加载器，Son类的类加载器也是可以的，只不过new Son()进行了修改，这里也需要进行修改
         */
        Father proxySon = (Father) Proxy.newProxyInstance(ProxyTest.class.getClassLoader(), Son.class.getInterfaces(), new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                System.out.println("做饭");

                Object invoke = method.invoke(son, args);

                System.out.println("洗碗");

                return invoke;
            }
        });

        proxySon.eat();
    }

    private void write(){
        Father father = new Son();

        byte[] proxyArr = ProxyGenerator.generateProxyClass("$Proxy0", father.getClass().getInterfaces());

        try {
            Files.write(Paths.get("C:\\Users\\wxt\\Desktop\\test.class"), proxyArr);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
