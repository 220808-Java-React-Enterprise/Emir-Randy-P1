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

public class UserDAO implements CrudDAO<User>{

    @Override
    public void save(User object) {
        try (Connection con = ConnectionFactory.getInstance().getConnection()) {
            PreparedStatement ps = con.prepareStatement("INSERT INTO users(id, username, password, email, phoneNumber, userRole) VALUES (?, ?, ?, ?, ?, ?)");
            ps.setString(1, object.getId());
            ps.setString(2, object.getUsername());
            ps.setString(3, object.getPassword());
            ps.setString(4, object.getEmail());
            ps.setString(5, object.getPhoneNumber());
            ps.setString(6, object.getUserRole());
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new InvalidSQLException("An error occurred when trying to save to the database.");
        }
    }

    @Override
    public void save(Order object) {

    }


    @Override
    public void update(User object) {

    }

    @Override
    public void delete(String id) {

    }

    @Override
    public User getById(String id) {
        return null;
    }

    @Override
    public List<User> getAll() {
        return null;
    }

    //Check if exist username into database
    public String getUserName(String username) {
        try (Connection con = ConnectionFactory.getInstance().getConnection()) {
            PreparedStatement ps = con.prepareStatement("SELECT (username) FROM users WHERE username = ?");
            ps.setString(1, username);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) return rs.getString("username");

        } catch (SQLException e) {
            throw new InvalidSQLException("An error occurred when trying to save to the database");
        }
        return null;
    }

    public List<User> getUserByRole(String userRole) {
        List<User> users = new ArrayList<User>();
        try (Connection con = ConnectionFactory.getInstance().getConnection()) {
            PreparedStatement ps = con.prepareStatement("SELECT * FROM users WHERE userRole = ?");
            ps.setString(1, userRole);
            ResultSet rs = ps.executeQuery();

            while (rs.next()){
                User user = new User(rs.getString("id"), rs.getString("username"), rs.getString("password"), rs.getString("email"), rs.getString("phoneNumber"), rs.getString("userRole"));
                users.add(user);
            }

        } catch (SQLException e) {
            throw new InvalidSQLException("An error occurred when trying to save to the database");
        }
        return users;
    }

    public List<String> getAllUsernames() {
        return null;
    }

    public User getUserLogging(String username, String password) {
        try (Connection con = ConnectionFactory.getInstance().getConnection()) {
            PreparedStatement ps = con.prepareStatement("SELECT * FROM users WHERE username = ? AND password = ?");
            ps.setString(1, username);
            ps.setString(2, password);
            ResultSet rs = ps.executeQuery();

            if (rs.next())
                return new User(rs.getString("id"), rs.getString("username"), rs.getString("password"), rs.getString("email"), rs.getString("phoneNumber"), rs.getString("userRole"));
        } catch (SQLException e) {
            throw new InvalidSQLException("An error occurred when trying to save to the database");
        }
        return null;
    }
}
