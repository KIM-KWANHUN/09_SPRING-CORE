package com.ohgiraffers.section01.common;

import lombok.*;

import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@ToString
public class BookDTO {
    private int no; // 도서번호
    private int isbn; // 도서 일련번호
    private String title; // 도서 제목
    private String author; // 도서 저자
    private String publisher; // 도서 출판사
    private Date createDate; // 도서 출판일자
}
