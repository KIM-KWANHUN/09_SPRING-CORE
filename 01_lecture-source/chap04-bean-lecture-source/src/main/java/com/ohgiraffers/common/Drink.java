package com.ohgiraffers.common;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
public class Drink extends Product {

    private int capacity; // 음료수 용량(ml)

    public Drink() {
        super(); // 부모 기본생성자 호출하겠다는 뜻
    }

    public Drink(String name, int price, int capacity) {
        super(name,price); // 부모꺼 가져오기
        this.capacity = capacity; // 자기자신
        // 생성자는 만들어놨으니 getter,setter,to string 사용
    }

    @Override
    public String toString() {
        // 부모의 toString 메소드 가져오면서 내 필드를 출력 할 수 있는 구문 추가
        return super.toString() + " " + this.capacity;
    }
}
