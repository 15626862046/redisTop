package com.jun.redistop.mapper;

import com.jun.redistop.pojo.Hero;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface HeroMapper {

   List<Hero> findAll();
}
