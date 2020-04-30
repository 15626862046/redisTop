package com.jun.redistop.controller;

import com.jun.redistop.mapper.HeroMapper;
import com.jun.redistop.pojo.Hero;
import com.jun.redistop.service.HeroService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.ZSetOperations;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

@Controller
public class showController {

    @Autowired
    private HeroService heroService;

    /**
     * top方法，查询redis数据库top数据分值最多的十位
     * @return
     */
    @RequestMapping("/test")
    @ResponseBody
    public Object[] top() {
        Set<ZSetOperations.TypedTuple<Hero>> typedTupleSet = heroService.redisTop();
        /**
        Iterator iterator = typedTupleSet.iterator();
        while (iterator.hasNext()) {
            ZSetOperations.TypedTuple<Object> typedTuple = (ZSetOperations.TypedTuple<Object>) iterator.next();
            Object value = typedTuple.getValue();
            double score = typedTuple.getScore();
            System.out.println("英雄出场最多次数TOP10:" + value + "----->" + score);
        }
         */
        return typedTupleSet.toArray();
    }

}
