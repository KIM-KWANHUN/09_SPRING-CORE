package com.ohgiraffers.section01.xmlconfig;

import com.ohgiraffers.common.MemberDTO;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class Application {

    public static void main(String[] args) {

        /* index 1. xml 방식으로 컨테이너 구성 */

        ApplicationContext context = new GenericXmlApplicationContext("section01/xmlconfig/spring-context.xml");
        // 1-1. 주소 등록 컨테이너에 대한 정보를 변수 context에 담음

        MemberDTO member = (MemberDTO) context.getBean("member");
        // 만들어 놨던 bean ID 에 있는걸 겟으로 꺼내옴
        // bean 의 id 를 이용해서 객체 가져오는 방법
        // object 타입이기 때문에 형변환

        System.out.println("member = " + member);

        // 2-1 bean 의 class 정보를 전달하여 가져오는 방법
        MemberDTO member2 = context.getBean(MemberDTO.class);

        // 2-2. bean 의 id 와 클래스 정보를 전달하여 가져오는 방법.
        MemberDTO member3 = context.getBean("member", MemberDTO.class);

        // xml 방식은 거의쓰지않음
        

    }
}
