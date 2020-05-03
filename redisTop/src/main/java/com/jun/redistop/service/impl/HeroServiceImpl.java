package com.jun.redistop.service.impl;

import com.jun.redistop.mapper.HeroMapper;
import com.jun.redistop.pojo.Hero;
import com.jun.redistop.service.HeroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ZSetOperations;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
public class HeroServiceImpl implements HeroService {
    @Autowired
    private HeroMapper heroMapper;
    @Autowired
    @Qualifier("redisTemplate")
    private RedisTemplate redisTemplate;

    @Override
    public Set<ZSetOperations.TypedTuple<Hero>> redisTop() {
        Set<ZSetOperations.TypedTuple<Hero>>heroSet=redisTemplate.opsForZSet().reverseRangeWithScores("top",0,9);
        if(heroSet.isEmpty()) {
            List<Hero> heros = heroMapper.findAll();
            for (Hero hero : heros) {
                String name = hero.getName();
                int count = hero.getCount();
                //存储数据库
                redisTemplate.opsForZSet().add("top", name, count);
            }
            heroSet=redisTemplate.opsForZSet().reverseRangeWithScores("top",0,9);
        }
        return heroSet;
    }

}
