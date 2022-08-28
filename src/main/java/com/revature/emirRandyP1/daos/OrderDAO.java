package com.revature.emirRandyP1.daos;


import com.revature.emirRandyP1.models.Order;
import com.revature.emirRandyP1.models.User;

import com.revature.emirRandyP1.utils.custom_exceptions.InvalidSQLException;

import com.revature.emirRandyP1.utils.database.ConnectionFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class OrderDAO implements CrudDAO<Order> {

    @Override
    public void save(Order object) {
        try (Connection con = ConnectionFactory.getInstance().getConnection()) {
            PreparedStatement ps = con.prepareStatement("INSERT INTO orders(id, total, user_id, flower_shop_id) VALUES (?, ?, ?, ?)");
            ps.setString(1, object.getId());
            ps.setString(2, object.getTotal());
            ps.setString(3, object.getUserId());
            ps.setString(4, object.getFlowerShopId());
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new InvalidSQLException("An error occurred when trying to save to the database.");
        }
    }

    @Override
    public void save(User object) {

    }

    @Override
    public void update(User object) {

    }

    @Override
    public void update(Order object) {

    }

    @Override
    public void delete(String id) {
    }

    @Override
    public Order getById(String id) {
        return null;
    }

    @Override
    public List<Order> getAll() {
        return null;
    }


    public List<Order> getAllById(String id) {
        List<Order> orders = new ArrayList<>();

        try (Connection con = ConnectionFactory.getInstance().getConnection()) {
            PreparedStatement ps = con.prepareStatement("SELECT * FROM orders WHERE user_id = ?");
            ps.setString(1, id);
            ResultSet rs = ps.executeQuery();

            while (rs.next()){
                Order order = new Order(rs.getString("id"), rs.getString("total"), rs.getString("user_id"), rs.getString("flower_shop_id"));
                orders.add(order);
            }
        } catch (SQLException e) {
            throw  new InvalidSQLException("An error occurred when trying to save the database");
        }
        return orders;
    }
}