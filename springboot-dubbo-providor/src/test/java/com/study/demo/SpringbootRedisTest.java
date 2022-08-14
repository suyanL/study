package com.study.demo;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.redis.DataRedisTest;
import org.springframework.data.redis.connection.RedisConnection;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@DataRedisTest
public class SpringbootRedisTest {

    @Autowired
    RedisTemplate redisTemplate;

    @Test
    public void testValue(){
        redisTemplate.opsForValue().set("name","学习Redis鸭！");
        System.out.println(redisTemplate.opsForValue().get("name"));
    }

    @Test
    public void testConnection(){
        //获取连接；很少用
        RedisConnection connection = redisTemplate.getConnectionFactory().getConnection();
        connection.flushDb();
        connection.flushAll();
    }
}