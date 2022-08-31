package com.revature.emirRandyP1.daos;

import com.revature.emirRandyP1.models.User;
import com.revature.emirRandyP1.utils.custom_exceptions.InvalidSQLException;
import com.revature.emirRandyP1.utils.database.ConnectionFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserDAO implements CrudDAO<User> {

    @Override
    public void save(User object) {
        try (Connection con = ConnectionFactory.getInstance().getConnection()) {
            PreparedStatement ps = con.prepareStatement("INSERT INTO ers_users(user_id, username, email, password, given_name, surname, is_active, role_id) VALUES (?,?,?,?,?,?,?,?)");
            ps.setString(1, object.getId());
            ps.setString(2, object.getUsername());
            ps.setString(3, object.getEmail());
            ps.setString(4, object.getPassword());
            ps.setString(5, object.getGivenName());
            ps.setString(6, object.getSurname());
            ps.setBoolean(7, object.isActive());
            ps.setString(8, object.getRoleId());
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new InvalidSQLException("An error occurred when trying to save to the database.");
        }
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
        List<User> userList = new ArrayList<>();

        try (Connection con = ConnectionFactory.getInstance().getConnection()) {
            PreparedStatement ps = con.prepareStatement("SELECT * FROM ers_users");
            ResultSet rs = ps.executeQuery();
            while (rs.next()){
                User user = new User(rs.getString("user_id"), rs.getString("username"), rs.getString("email"), rs.getString("password"), rs.getString("given_name"), rs.getString("surname"), rs.getBoolean("is_active"), rs.getString("role_id"));
                userList.add(user);
            }
        } catch (SQLException e) {
            throw new InvalidSQLException("An error ocurred when trying to save to the database");
        }
        return userList;
    }

    public User getUserByUsername(String username){
        try (Connection con = ConnectionFactory.getInstance().getConnection()) {
            PreparedStatement ps = con.prepareStatement("SELECT * FROM ers_users WHERE username = ?");
            ps.setString(1, username);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                return new User(rs.getString("user_id"), rs.getString("username"), rs.getString("email"), rs.getString("password"), rs.getString("given_name"), rs.getString("surname"), rs.getBoolean("is_active"), rs.getString("role_id"));
            }
        } catch (SQLException e) {
            throw new InvalidSQLException("An error occurred when trying to save to the database");
        }
        return null;
    }

    public String getUserName(String username) {
        try (Connection con = ConnectionFactory.getInstance().getConnection()) {
            PreparedStatement ps = con.prepareStatement("SELECT (username) FROM ers_users WHERE username = ?");
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
            PreparedStatement ps = con.prepareStatement("SELECT * FROM ers_users WHERE role_id = ?");
            ps.setString(1, userRole);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                User user = new User(rs.getString("user_id"), rs.getString("username"), rs.getString("email"), rs.getString("password"), rs.getString("given_name"), rs.getString("surname"), rs.getBoolean("is_active"), rs.getString("role_id"));
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
            PreparedStatement ps = con.prepareStatement("SELECT * FROM ers_users WHERE username = ? AND password = ?");
            ps.setString(1, username);
            ps.setString(2, password);
            ResultSet rs = ps.executeQuery();

            if (rs.next())
                return new User(rs.getString("user_id"), rs.getString("username"), rs.getString("email"), rs.getString("password"), rs.getString("given_name"), rs.getString("surname"), rs.getBoolean("is_active"), rs.getString("role_id"));
        } catch (SQLException e) {
            throw new InvalidSQLException("An error occurred when trying to save to the database");
        }
        return null;
    }
}
