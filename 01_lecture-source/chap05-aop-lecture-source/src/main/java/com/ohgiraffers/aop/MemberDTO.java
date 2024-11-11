package com.ohgiraffers.aop;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class MemberDTO {

    private Long no; // 회원번호
    private String name; // 회원이름
}
