package com.ohgiraffers.section01.common;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.*;
@Repository("bookDAO") // @Component 의 역활에 따라 특수한 @Repository 어노테이션
//@Component
public class BookDAOImpl implements BookDAO{

    private final Map<Integer, BookDTO> bookList;

    public BookDAOImpl() {
        // DB 연동은 넘어가고 생성자를 통해 임시 데이터 생성
        bookList = new HashMap<>();
        bookList.put(1, new BookDTO(1,1234,"자바가 세상에서 제일 쉬웠어요","김관훈","하이출판",new Date()));
        bookList.put(2, new BookDTO(2,1234,"자바가 세상에서 제일 어려워요","정은미","하이파이출판",new Date()));
    }

    @Override
    public List<BookDTO> selectBookList() {

        return new ArrayList<>(bookList.values());
    }

    @Override
    public BookDTO selectBookByNo(int no) {

        return bookList.get(no);
    }
}
