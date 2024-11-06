package com.ohgiraffers.common;

public interface Account {

    // 잔액 조회 메소드
        String getBalance();
    // 입금 메소드
        String deposit(int money);
    // 출금 메소드
        String withDraw(int money);

}
