package com.ohgiraffers.section02.javaconfig;

import com.ohgiraffers.common.MemberDTO;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Application {

    public static void main(String[] args) {

        /* index 2. java 방식의 설정 */

        ApplicationContext context = new AnnotationConfigApplicationContext(ContextConfiguration.class);
        // bean 을 등록했던 클래스명 ()에 입력
        // java 방식은 클래스를 만들어서 활용한다.

        MemberDTO member = context.getBean("member", MemberDTO.class);
        // 변수에 담아주기
        System.out.println("member = " + member);
    }
}
