package com.ohgiraffers.section01.autowired.subsection02.consturtor;

import com.ohgiraffers.section01.autowired.subsection01.field.BookService;
import com.ohgiraffers.section01.common.BookDTO;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;

public class Application {

    public static void main(String[] args) {

        /* index 1. 의존성 주입 - 필드주입 - */
        /* comment.
        *   @Autowired 어노테이션
        *   객체와 객체간의 의존성을 생성할 때 대표적인
        *   어노테이션이다. */
        // 클래스를 전달해도 되지만, 문자열로 주소를 전달하게 되면
        // 문자열이 곧 Bean 을 스캔 할 컴포넌트 스캔의 범위가 된다.
        ApplicationContext context = new AnnotationConfigApplicationContext("com.ohgiraffers.section01");
        // 서비스에서 만든 bean 과 클래스 가져오기
        BookService service = context.getBean("fieldService", BookService.class);

        // 상향 된 for 문으로 book 전체 출력
        List<BookDTO> bookList = service.selectAllBooks();
        for(BookDTO book : bookList) {
            System.out.println("book = " + book);
        }


    }
}
