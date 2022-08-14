package com.ddup.mybatis.springbootmybatis.proxy.stc;

import com.ddup.mybatis.springbootmybatis.proxy.Person;
import com.ddup.mybatis.springbootmybatis.proxy.Student;

/**
 * 如果使用动态代理这个类会被自动创建， 代理类的工作就是把实体类接过来，然后调用它的方法，也就是说本来实体类可以自己执行的方法现在由代理类来触发执行，这样做的好处是，在调用实体类方法的前后我们可以插入监控方法。比如这里只插入了一句话“这位同学最近学习有进步”
 */
public class StudentProxy implements Person {
    @Override
    public void giveMoney() {
        System.out.println("这位同学最近学习有进步！");
        stu.giveMoney();
    }

    Student stu;

    public StudentProxy (Person stu){
        if(stu.getClass() == Student.class){ //person 可以是学生，老师等， 但是这里只为学生交钱
            this.stu = (Student)stu;
        }
    }

}