package com.roamer.contacts.configuration;

import com.roamer.contacts.entity.User;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.concurrent.TimeUnit;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RedisTest {

    @Autowired
    private RedisTemplate redisTemplate;

    @Autowired
    private StringRedisTemplate stringRedisTemplate;


    @Test
    public void findValueByKey(){
        stringRedisTemplate.opsForValue().set("aaa","111");
        assertEquals("111",stringRedisTemplate.opsForValue().get("aaa"));
    }

    @Test
    public void findObjectByKey() throws InterruptedException {
        User user = new User();
        user.setId(1);
        user.setUsername("jbauer");
        user.setPassword("24hours");
        ValueOperations<String, User> operations=redisTemplate.opsForValue();
        operations.set("jbauer", user);
        operations.set("jbauer.1", user,1,TimeUnit.SECONDS);
        Thread.sleep(1000);
        boolean exists=redisTemplate.hasKey("jbauer.1");
        if(exists){
            System.out.println("exists is true");
        }else{
            System.out.println("exists is false");
        }
        assertEquals("jbauer",operations.get("jbauer").getUsername());
    }

}