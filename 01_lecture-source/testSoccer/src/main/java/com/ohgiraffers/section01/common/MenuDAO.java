package com.ohgiraffers.section01.common;


import java.util.List;

public interface MenuDAO {
    // 메뉴 1개 조회
    List<MenuDTO> selectAll();
    // 메뉴 번호로 조회
    MenuDTO selectNO(int no);

}
