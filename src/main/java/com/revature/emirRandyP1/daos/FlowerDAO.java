package com.revature.emirRandyP1.daos;

import com.revature.emirRandyP1.models.Flower;
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

public class FlowerDAO implements CrudDAO {

    @Override
    public void save(User object) {

    }

    @Override
    public void update(User object) {

    }

    @Override
    public void save(Object object) {

    }

    @Override
    public void save(Order object) {

    }

    @Override
    public void update(Object object) {

    }

    @Override
    public void delete(String id) {
        try (Connection con = ConnectionFactory.getInstance().getConnection()) {
            PreparedStatement ps = con.prepareStatement("DELETE FROM flowers WHERE id=?");
            ps.setString(1, id);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            throw new InvalidSQLException("An error ocurred when trying to save to the database");
        }
    }

    @Override
    public Object getById(String id) {
        return null;
    }

    @Override
    public List<Flower> getAll() {
        List<Flower> flowers = new ArrayList<>();

        try (Connection con = ConnectionFactory.getInstance().getConnection()) {
            PreparedStatement ps = con.prepareStatement("SELECT * FROM flowers");
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Flower flower = new Flower(rs.getString("id"), rs.getString("price"), rs.getString("name"));
                flowers.add(flower);
            }
        } catch (SQLException e) {
            throw new InvalidSQLException("An error ocurred when trying to save to the database");
        }
        return flowers;
    }

    public void save(Flower object) {
        try (Connection con = ConnectionFactory.getInstance().getConnection()) {
            PreparedStatement ps = con.prepareStatement("INSERT INTO flowers(id, price, name) VALUES (?, ?, ?)");
            ps.setString(1, object.getId());
            ps.setString(2, object.getPrice());
            ps.setString(3, object.getName());
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new InvalidSQLException("An error occurred when trying to save to the database.");
        }
    }

    public void update(String id, String price, String name) {
        try (Connection con = ConnectionFactory.getInstance().getConnection()) {
            PreparedStatement ps = con.prepareStatement("UPDATE flowers SET name=?, price=? WHERE id=?");
            ps.setString(1, name);
            ps.setString(2, price);
            ps.setString(3, id);
            ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
            throw new InvalidSQLException("An error occurred when trying to save to the database.");
        }
    }

    public List<Flower> getFlowerById(String id) {
        List<Flower> flowers = new ArrayList<Flower>();
        try (Connection con = ConnectionFactory.getInstance().getConnection()) {
            PreparedStatement ps = con.prepareStatement("SELECT * FROM flowers WHERE id = ?");
            ps.setString(1, id);
            ResultSet rs = ps.executeQuery();

            while (rs.next()){
                Flower flower = new Flower(rs.getString("id"), rs.getString("price"), rs.getString("name"));
                flowers.add(flower);
            }

        } catch (SQLException e) {
            throw new InvalidSQLException("An error occurred when trying to save to the database");
        }
        return flowers;
    }
}
