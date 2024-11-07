package com.ohgiraffers.section02.common;

import org.springframework.stereotype.Component;

@Component // 빈생성
public class Tiger implements Animal{
    @Override
    public void eat() {
        System.out.println("호랑이가 채소를 먹어요");
    }
}
