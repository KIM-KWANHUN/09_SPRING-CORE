package com.ohgiraffers.section03.annotationconfig.subsection01.java;

import com.ohgiraffers.common.MemberDAO;
import com.ohgiraffers.common.MemberDTO;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.stereotype.Component;

@Configuration("configuration03") // bean 을 등록할 수 있는 설정파일

//@ComponentScan(basePackages = "com.ohgiraffers") // Component 어노테이션을 가진 파일을 전부 등록해줌
                                                 //
@ComponentScan(basePackages = "com.ohgiraffers",
        excludeFilters = {
            @ComponentScan.Filter(
                    /* 1. 타입으로 설정 */
//                    type = FilterType.ASSIGNABLE_TYPE,
//                    classes = {MemberDAO.class} // MemberDAO 는 bean 으로 등록하지 않겠다.
                    /* 2. 어노테이션 종류 */
//                    type = FilterType.ANNOTATION,
//                    classes = {org.springframework.stereotype.Component.class}
                    /* 3. 표현식으로 설정 */
//                       type = FilterType.REGEX,
//                       pattern = {"com.ohgiraffers.section03.annotationconfig.java.*"}
            )
        }// 스캔시 필터로 걸러준다.
)
/* comment.
 *   @ComponentScan
 *   basePackage 로 설정 된 하위 경로에 특정 어노테이션을
 *   가지고 있는 클래스를 Bean 으로 등록해주는 기능
 *   특정 어노테이션은 @Component 이며
 *   특수한 목적에 따라서 @Controller, @Service, @Repository, @Configuration 등을 사용한다. */

public class ContextConfiguration {

}
