package com.ohgiraffers.section01.consturtor;

import com.ohgiraffers.section01.common.MenuDTO;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;

public class Application {

    public static void main(String[] args) {
        ApplicationContext context =
                new AnnotationConfigApplicationContext("com.ohgiraffers.section01");

        MenuService service = context.getBean("MenuService", MenuService.class);

        List<MenuDTO> menuDTOList = service.selectAll();

        for(MenuDTO menuDTO : menuDTOList) {
            System.out.println("menuDTO = " + menuDTO);
        }

        System.out.println(service.selectNo(0));




    }
}
