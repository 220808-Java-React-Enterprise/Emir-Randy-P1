package com.revature.emirRandyP1.services;

import com.revature.emirRandyP1.daos.OrderDAO;
import com.revature.emirRandyP1.models.Order;

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
