package com.ohgiraffers.section01.Food;

import com.ohgiraffers.section01.COMMON.Food;
import com.ohgiraffers.section01.COMMON.Product;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Date;

@Configuration
public class Config {

    @Bean
    public Product kimchi() {
        return new Food("김치",8000,"한식",new Date());
    }
}
