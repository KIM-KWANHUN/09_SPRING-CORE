package com.ohgiraffers.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;
import org.springframework.util.StopWatch;

import java.util.Map;

/* @Aspect 어노테이션 : AOP 기능을 사용하기 위한 어노테이션
*   - PointCut 과 Advice 를 하나의 클래스 단위로 정의하기 위한 어노테이션 */
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
     *   JoinPoint : 포인트 컷으로 설정한 실행 지점을 의미한다.
     *   실행 지점을 설정을 하게 되면 우리가 메소드 내에 작성한 코드(Advice)를
     *   어노테이션의 종류에 따라 전, 후, 전후 등등에 동작하게 할 수 있다.
     *   메소드의 매개변수로 전달한 JoinPoint 객체는 현재 조인포인트의
     *   메소드명, 인수, 정보 등등을 가지고 있게 된다. */

    @Before("LoggingAspect.logPointCut()")
    // 위에 작성한 정보를 @Before 에 전달 우리가 위에 지정한 위치 전에 동작을 하는 어노테이션
    public void logBefore(JoinPoint joinPoint) {
        System.out.println("Before 타겟 정보 : " + joinPoint.getTarget());

        System.out.println("Before 타겟의 시그니처 : " + joinPoint.getSignature());

        if (joinPoint.getArgs().length > 0) {
            System.out.println("Before 타겟의 인자 : " + joinPoint.getArgs()[0]);
            // getArgs() 로 전달 인자가 있으면 출력하는 구문
        }
    }

    /* 같은 클래스 내에 PointCut 을 설정했다면 클래스명은 생략 가능
       다른 클래스 에 PointCut 을 설정 했으면 클래스명 필수 입력!!
       풀클래스명(패키지 포함)으로 작성해야 한다. */
    @After("logPointCut()")
    public void logAfter(JoinPoint joinPoint) {
        System.out.println("After 타겟 정보 : " + joinPoint.getTarget());

        System.out.println("After 타겟의 시그니처 : " + joinPoint.getSignature());

        if (joinPoint.getArgs().length > 0) {
            System.out.println("After 타겟의 인자 : " + joinPoint.getArgs()[0]);
        }
    }

    /* comment.
    *   @AfterReturning 어노테이션
    *   리턴 할 결과 값을 변경할 수 있다.
    *   returning 속성
    *   - 메소드가 동작을 완료하고 자신을 호출한 쪽으로 가져가는 값
    *   - 즉 리턴값을 담아둘 변수명을 기술한다. */
    // returning 의 변수명과 object 타입의 변수명이 항상 일치해야한다.
    @AfterReturning(pointcut = "logPointCut()", returning = "result")
    public void logAfterReturning(JoinPoint joinPoint, Object result) {
        System.out.println("result 변수에 Service 에서 return 되는 값 : " + result);
        /* comment.
        *   result 변수에 우리가 Service 클래스에서 return 되는 값이
        *   담긴 것이 확인 됬다. 그렇다는 것은 우리가 result 변수에
        *   접근해서 값을 조작할 수 있다는 의미로 해석할 수 있다. */
        // 리턴 조작
        if(result != null && result instanceof Map) {
            // result 가 값이 존재하거나 타입이 Map 라고하면?
            ((Map<Long, MemberDTO>) result).put(100L, new MemberDTO(100L,"반환되는 값 가공 성공!!!"));
        }
    }
    /* comment.
    *   @AfterThrowing
    *   // 가볍게 넘기기 */
    @AfterThrowing(pointcut = "logPointCut()", throwing = "exception")
    public void logAfterThrowing(Throwable exception) {
        System.out.println("AfterThrowing exception = " + exception);
    }

    /* comment.
    *   @Around
    *   - Around 는 우리가 지정한 실행 위치(JoinPoint) 앞 뒤를 모두 장악한다.
    *   - 그리고 타겟 메소드의 시행 시점, 실행 여부, 계속 진행 여부 등을 결정한다.
    *   - Around Advice 는 JoinPoint 를 확장한 ProceedingJoinPoint 를
    *   - 매개변수로 받게 된다.
    *   - 가장 강력한 어드바이스고 함부로 쓰면 안된다.
    *   - 조인포인트 진행하는 호출을 잊는 경우가 자주 발생하기 때문에 주의해야 하며
    *   - 최소한의 요건을 충족하면서도 가장 기능이 약한 어드바이스를 쓰는게 바람직하다. */

    @Around("logPointCut()")
    public Object logAround(ProceedingJoinPoint joinPoint) throws Throwable {
        // 앞 뒤로 동작을 하게 되므로 여기서는 메소드 실행 시
        // 소요되는 시간을 체크하는 로직 작성
        StopWatch stopWatch = new StopWatch();
        // 시간 체크
        stopWatch.start(); // 시간을 재는 스탑워치 실행
        System.out.println("Around Before" + joinPoint.getSignature().getName());
        // target 메소드 시작시키는 구문
        Object result = joinPoint.proceed(); // proceed 구문 반드시 작성 해야한다.

        System.out.println("Around After" + joinPoint.getSignature().getName());

        stopWatch.stop();

        System.out.println("메소드 실행에 소요 된 시간 : " + stopWatch.getTotalTimeMillis() + "(ms)");

        /* comment.
        *   조인 포인트를 호출한 쪽(지금은 Application)
        *   or 다른 어드바이스가 실행할 수 있도록 Object 반환 */
        return result;
    }
}