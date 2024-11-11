package com.ohgiraffers.section01.COMMON;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Desert extends Product{

    private int Capacity; // 기본생성자 생성
    public Desert() {
        super();
    }

    public Desert(String name, int price, String category, int capacity) { // 매개변수를 담은 생성자
        super(name, price, category);
        Capacity = capacity;
    }

    @Override
    public String toString() { // toString
    return super.toString() + " " + this.Capacity;
    }


}
