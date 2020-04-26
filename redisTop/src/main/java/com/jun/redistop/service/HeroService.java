package com.jun.redistop.service;

import com.jun.redistop.pojo.Hero;
import org.springframework.data.redis.core.ZSetOperations;

import java.util.Set;


public interface HeroService {
  Set<ZSetOperations.TypedTuple<Hero>>redisTop();
}
