package com.ohgiraffers.section01.javaconfig;

import com.ohgiraffers.common.MemberDTO;
import com.ohgiraffers.common.PersonalAccount;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Application {

    public static void main(String[] args) {

        ApplicationContext context = new AnnotationConfigApplicationContext(ContextConfiguration.class);

        MemberDTO member = context.getBean(MemberDTO.class);
        // bean 으로 등록 한 파일 꺼내오기.

        System.out.println(member.getPersonalAccount());
        System.out.println(member.getPersonalAccount().deposit(100000));
        System.out.println(member.getPersonalAccount().getBalance());
        System.out.println(member.getPersonalAccount().withDraw(1000));

    }
}
