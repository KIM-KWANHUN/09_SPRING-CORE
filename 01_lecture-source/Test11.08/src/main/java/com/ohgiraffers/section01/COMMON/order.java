package com.ohgiraffers.section01.COMMON;

import java.util.ArrayList;
import java.util.List;

public class order {

    private final List<Product> order;

    public order() {
        order = new ArrayList();
    }

    public void order(Product orders) {
        order.add(orders);
    }

    public List<Product> order() {

        return order;
    }
}
