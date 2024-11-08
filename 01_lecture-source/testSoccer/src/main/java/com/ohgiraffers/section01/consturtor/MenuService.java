package com.ohgiraffers.section01.consturtor;

import com.ohgiraffers.section01.common.MenuDAO;
import com.ohgiraffers.section01.common.MenuDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("MenuService")
public class MenuService {
@Autowired //
    private final MenuDAO menuDAO;

    public MenuService(MenuDAO menuDAO) {
        this.menuDAO = menuDAO;
    }

    public List<MenuDTO> selectAll() {
        return menuDAO.selectAll();
    }

    public MenuDTO selectNo(int no) {
        return menuDAO.selectNO(no);
    }
}
