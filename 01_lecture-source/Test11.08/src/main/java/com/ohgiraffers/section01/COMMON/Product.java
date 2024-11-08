package com.ohgiraffers.section01.COMMON;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@ToString
public class Product {

    private String name; // 요리사 이름
    private Boolean BW; // 트루면 백 펄스면 흙
    private String area; // 근무지역
    private String category; // 메뉴 카테고리
}
