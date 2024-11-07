package com.ohgiraffers.section01.common;

import java.util.List;

public interface BookDAO {
    //인터페이스는 public, private 넣지 않아도됨...
    /* 도서 목록 전체 조회 */
    List<BookDTO> selectBookList();

    /* 도서 번호로 도서 조회 */
   BookDTO selectBookByNo(int no);

}

