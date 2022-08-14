package com.ddup.mybatis.springbootmybatis.proxy.dy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class StuInvocationHandler<T> implements InvocationHandler {
    T target;

    public StuInvocationHandler(T target){
        this.target = target;
    }
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("代理执行"+method.getName()+"方法");

//        MonitorUtil.start(); //这是一个本地静态工具类，用于记下方法开始时间
        Object result = method.invoke(target, args);
        System.out.println(method.getName());//这是一个本地静态工具类，用于记下方法执行完成的时间
        return result;
    }
}