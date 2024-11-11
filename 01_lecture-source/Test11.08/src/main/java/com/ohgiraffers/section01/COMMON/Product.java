package com.ohgiraffers.section01.COMMON;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@ToString
public class Product {

    private String name; // 이름
    private int price; // 메뉴 가격
    private String category; // 메뉴 카테고리
}
