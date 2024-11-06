package com.ohgiraffers.common;

import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
/* comment.
*   @Component 어노테이션은 IOC 컨테이너에게 Bean 으로
*   등록할 클래스임을 명시하는 어노테이션이다.
*   memberDAO 자체를 bean 으로 등록 */
public class MemberDAO {

    private final Map<Integer, MemberDTO> memberMap;

    public MemberDAO() {
        memberMap = new HashMap<>();

        memberMap.put(1, new MemberDTO(1, "user01", "pass01", "김관훈"));
        memberMap.put(2, new MemberDTO(2, "user02", "pass02", "정은미"));
    }

    public MemberDTO selectMember(int no) {
        // 정수값을 하나 전달 받아서 리턴
        // 1이라고 전달하면 1번 회원이 리턴됨
        return memberMap.get(no);
    }

    public boolean insertMember(MemberDTO newMember) {
        // 멤버 insert 에 성공하면 true, 실패하면 false
        int before = memberMap.size();

        memberMap.put(newMember.getNo(), newMember);

        int after = memberMap.size();

        return after > before ? true : false;
        // after가 before 보다 크면 true 아니면 false
    }
}
