package com.ddup.mybatis.springbootmybatis.proxy;

public class Student implements Person {
    @Override
    public void giveMoney() {
        System.out.println(name +" 上交班费50元！");
    }
    private String name;

    public Student(String name){
        this.name = name;
    }
}