package com.jun.managementsystem.config;

import com.sun.corba.se.spi.orbutil.closure.Closure;

import org.springframework.util.StringUtils;
import org.springframework.web.servlet.LocaleResolver;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Locale;

public class MyLocalResolver implements LocaleResolver {

    //解析请求
    @Override
    public Locale resolveLocale(HttpServletRequest httpServletRequest) {
        //获取请求中的语言参数
        String language=httpServletRequest.getParameter("language");
        Locale locale = Locale.getDefault();//如果没钱就使用默认参数
        //如果请求的链接携带了国际化参数
        if(!StringUtils.isEmpty(language)){
            //zh_CN国家_地区
           String[] split= language.split("_");
            locale=new Locale(split[0],split[1]);
        }

        return locale;
    }

    @Override
    public void setLocale(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Locale locale) {

    }
}
