package com.ohgiraffers.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
/* @Aspect 어노테이션 : AOP 기능을 사용하기 위한 어노테이션 */
@Aspect
@Component
public class LoggingAspect {

    /* comment.
    *   @PointCut - 여러 조인 포인트를 매칭하기 위한 표현식
    *   사용식
    *   @PointCut("execution([수식어] 리턴타입 [클래스 이름].이름(파라미터))")
    *   수식어란, public-private-protected-default 등의 접근제어자를 의미하며
    *   생략이 가능하다.
    *   * -> 와일드 카드(전부 가능하다는 의미) */
    // *Service : Service 로 끝나는 클래스를 의미한다.
    // *Service.*(..) : 매개변수가 0개 이상인 모든 메소드
    // *Service.*(*) : 매개변수가 1개인 모든 메소드
    // *Service.*(*,...) : 매개변수가 1개 이상인 모든 메소드

    @Pointcut("execution(* com.ohgiraffers.aop.*Service.*(..))")
    //         execution(수식     리턴타입    클래스이름.이름()
    public void logPointCut() {

    }
    /* comment.
    *   JoinPoint : 포인트 컷으로 설정한 실행 지점을 의미한다. */

    @Before("LoggingAspect.logPointCut()")
    // 위에 작성한 정보를 @Before 에 전달 우리가 위에 지정한 위치 전에 동작을 하는 어노테이션
    public void logBefore(JoinPoint joinPoint) {
        System.out.println("Before 타겟 정보 : " + joinPoint.getTarget());

        System.out.println("Before 타겟의 시그니처 : " + joinPoint.getSignature());

        if(joinPoint.getArgs().length > 0) {
            System.out.println("Before 타겟의 인자 : " + joinPoint.getArgs()[0]);
        // getArgs() 로 전달 인자가 있으면 출력하는 구문
        }
    }

}
