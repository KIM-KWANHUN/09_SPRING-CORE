package com.ohgiraffers.section01.common;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class MenuDTO {

    private int no; // 메뉴번호
    private String name; // 메뉴이름
    private int price; // 메뉴가격
    private String category; // 메뉴 카테고리
}
