package com.ohgiraffers.section02.common;

import org.springframework.context.annotation.Primary;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component // 빈생성
@Order(3)
// @Primary // 프라이머리 어노테이션은 단 1개만 사용 가능하다. 2개이상 설정하면 오류 발생!!
    /* comment.
    *   @Primary 어노테이션을 설정하면 @Autowired 로
    *   동일한 타입(Animal) 의 여러 bean 을 찾게 되는경우
    *   자동으로 연결을 우선 시 할 타입으로 설정하게 된다.
    *   동일한 타입의 클래스 중 한 개만 @Primary 어노테이션을
    *   사용할 수 있다. */
public class Koala implements Animal{
    @Override
    public void eat() {
        System.out.println("코알라가 나뭇잎을 먹어요!!");
    }
}
