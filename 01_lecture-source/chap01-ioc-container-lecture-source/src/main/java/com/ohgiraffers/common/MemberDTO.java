package com.ohgiraffers.common;

import lombok.*;

@NoArgsConstructor // 기본생성자
@AllArgsConstructor // 매개변수가 있는 생성자
@Getter // 개터
@Setter // 쌔터
@ToString // 투스트링
// @Data 전체 -> 위에 5가지를 수행할 수 있지만
// Lombok 자체의 버그가 많아 권장하진 않음
public class MemberDTO {

    private int no;
    private String id;
    private String pwd;
    private String name;

}
