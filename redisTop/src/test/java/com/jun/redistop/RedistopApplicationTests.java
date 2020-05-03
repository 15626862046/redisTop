package com.jun.redistop;

import com.jun.redistop.pojo.Hero;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;


@SpringBootTest
class RedistopApplicationTests {

    @Autowired
    @Qualifier("redisTemplate")
    private RedisTemplate redisTemplate;
    @Test
    void contextLoads() {
        Hero hero = new Hero();
        hero.setName("天天");
        hero.setCount(45);
        redisTemplate.opsForValue().set("heroTest",hero);
        System.out.println(redisTemplate.opsForValue().get("heroTest"));

    }

}
