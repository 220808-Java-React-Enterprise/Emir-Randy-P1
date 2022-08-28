package com.revature.flowerShop.services;

import com.revature.flowerShop.daos.OrderDAO;
import com.revature.flowerShop.models.Order;

import java.util.List;

public class OrderServices {
    private final OrderDAO orderDAO;

    public OrderServices(OrderDAO orderDAO) {
        this.orderDAO = orderDAO;
    }

    public void saveOrder(Order order) {
        orderDAO.save(order);
    }

    public List<Order> getAllOrdersById(String id){
        return orderDAO.getAllById(id);
    }
}
