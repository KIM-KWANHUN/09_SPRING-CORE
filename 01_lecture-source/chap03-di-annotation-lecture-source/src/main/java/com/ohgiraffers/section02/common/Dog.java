package com.ohgiraffers.section02.common;

import org.springframework.context.annotation.Primary;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component // 빈생성
@Primary
@Order(1)
public class Dog implements Animal{
    @Override
    public void eat() {
        System.out.println("개가 이탈리안 BLT 를 먹어요 ㅠ");
    }
}
