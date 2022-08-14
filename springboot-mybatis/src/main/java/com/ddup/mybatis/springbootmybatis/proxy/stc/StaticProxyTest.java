package com.ddup.mybatis.springbootmybatis.proxy.stc;

import com.ddup.mybatis.springbootmybatis.proxy.Person;
import com.ddup.mybatis.springbootmybatis.proxy.Student;

public class StaticProxyTest {

    public static void main(String[] args) {
        Person zhangsan = new Student("张三");

        Person monitor = new StudentProxy(zhangsan); // 为了帮张三交班费而生产一个班长角色
        monitor.giveMoney();
    }
}