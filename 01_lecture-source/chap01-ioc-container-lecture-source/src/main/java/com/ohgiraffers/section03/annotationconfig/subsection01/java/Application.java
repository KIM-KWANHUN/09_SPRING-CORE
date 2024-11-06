package com.ohgiraffers.section03.annotationconfig.subsection01.java;

import com.ohgiraffers.common.MemberDAO;
import com.ohgiraffers.common.MemberDTO;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Application {

    public static void main(String[] args) {

        /* index 3. Java-Annotation 방식 */

        ApplicationContext context = new AnnotationConfigApplicationContext(ContextConfiguration.class);

        // getBeanDefinitionNames : 컨테이너에 생성 된 bean 이름 반환
        String[] beanNames = context.getBeanDefinitionNames();
        // 반환형은 string[]배열 타입

        for(String bean : beanNames) {
            System.out.println("bean = " + bean);
        }
        // 클래스 레벨에 bean 을 등록할 때 이름을 지정하지 않으면 앞글자가 소문자로 바뀐 것이 이름으로 지정

        MemberDAO memberDAO = context.getBean("memberDAO", MemberDAO.class);
        // MemberDAO클래스 호출

        System.out.println(memberDAO.selectMember(1));

        System.out.println(memberDAO.insertMember(new MemberDTO(3,"user03","pass03","하츄핑")));
        // insert 메소드로 멤버 생성
        System.out.println(memberDAO.selectMember(3));
    }
}
