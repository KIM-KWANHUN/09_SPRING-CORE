package com.ohgiraffers.common;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
// Account 인터페이스를 상속받을 클래스 생성
// 인터페이스 에 작성한 메소드를 강제로 오버라이딩 해야한다.
public class PersonalAccount implements Account{
    private final int bankCode; // 은행코드
    private final String accNo; // 계좌번호
    private int balance; // 잔액

    // final이 붙은 키워드는 초기화를 해야함 그래서 생성자를 이용해 초기화를 시킴
    public PersonalAccount(int bankCode, String accNo) {
        this.bankCode = bankCode;
        this.accNo = accNo;
    }

    @Override
    public String getBalance() {
        // 잔액 조회
        return this.accNo + " 계좌의 잔액은 " + this.balance + "원 입니다.";
    }

    @Override
    public String deposit(int money) {
        // 입금
        String str = "";
        if(money >= 0) {
            this.balance += money;
            str = money + "원이 입금되었습니다.";
        } else {
            str = "잘못 된 금액입니다.";
        }

        return str;
    }

    @Override
    public String withDraw(int money) {
        // 출금
        String str = "";
        if (this.balance >= money) {
            this.balance -= money;
            str = money + "원이 출금 되었습니다.";
        } else {
            str = "잔액이 부족합니다. 잔액을 확인해주세요";

        }
        return str;
    }
}
