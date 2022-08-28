package com.revature.emirRandyP1.daos;

import com.revature.emirRandyP1.models.FlowerShop;


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

public class FlowerShopDAO implements CrudDAO<FlowerShop>{


    @Override
    public void save(User object) {

    }

    @Override
    public void update(User object) {

    }

    @Override
    public void save(FlowerShop object) {

    }

    @Override
    public void save(Order object) {

    }

    @Override
    public void update(FlowerShop object) {

    }

    @Override
    public void delete(String id) {

    }

    @Override
    public FlowerShop getById(String id) {
        return null;
    }

    @Override
    public List<FlowerShop> getAll() {
        List<FlowerShop> flowerShops = new ArrayList<>();

        try (Connection con = ConnectionFactory.getInstance().getConnection()) {
            PreparedStatement ps = con.prepareStatement("SELECT * FROM flowers_shop");
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                FlowerShop flowerShop = new FlowerShop(rs.getString("id"), rs.getString("name"), rs.getString("size"), rs.getString("location"));
                flowerShops.add(flowerShop);
            }
        } catch (SQLException e) {
            throw new InvalidSQLException("An error ocurred when trying to save to the database");
        }
        return flowerShops;
    }
}
