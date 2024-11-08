package com.ohgiraffers.section01.common;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository("MenuDAO")
public class MenuDAOImpl implements MenuDAO {

    private final Map<Integer, MenuDTO> menuDTO;


    public MenuDAOImpl() {
        menuDTO = new HashMap<>();
        menuDTO.put(1, new MenuDTO(1,"피자",15000,"양식"));
        menuDTO.put(2, new MenuDTO(2,"파스타",12000,"양식"));
        menuDTO.put(3, new MenuDTO(3,"마라탕",12000,"중식"));
    }

    @Override
    public List<MenuDTO> selectAll() {
        return new ArrayList<>(menuDTO.values());
    }

    @Override
    public MenuDTO selectNO(int no) {
        return menuDTO.get(no);
    }
}

