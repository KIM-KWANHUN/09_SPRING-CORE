package com.ohgiraffers.section01.COMMON;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class Food extends Product{

    private Date date; // 음식 나오는 시간

    public Food() {
        super(); // 기본생성자
    }

    public Food(String name, int price, String category, Date date) {
        super(name, price, category);
        this.date = date;
    }

    @Override
    public String toString() {
        return super.toString() + " " + this.date;
    }
}
