package com.revature.emirRandyP1.daos;

import com.revature.emirRandyP1.models.Reimbursement;
import com.revature.emirRandyP1.models.User;
import com.revature.emirRandyP1.utils.custom_exceptions.InvalidSQLException;
import com.revature.emirRandyP1.utils.database.ConnectionFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class ReimbursementDAO implements CrudDAO<Reimbursement>{

    @Override
    public void save(Reimbursement object) {
        try (Connection con = ConnectionFactory.getInstance().getConnection()) {
            PreparedStatement ps = con.prepareStatement("INSERT INTO ers_reimbursements(reimb_id, amount, submitted, resolved, description, receipt, payment_id, author_id, resolver_id, status_id, type_id) VALUES (?,?,?,?,?,?,?,?,?,?,?)");
            ps.setString(1, object.getReimbId());
            ps.setInt(2, object.getAmount());
            ps.setString(3, object.getSubmitted());
            ps.setString(4, object.getResolved());
            ps.setString(5, object.getDescription());
            ps.setByte(6, object.getReceipt());
            ps.setString(7, object.getPaymentId());
            ps.setString(8, object.getAuthorId());
            ps.setString(9, object.getResolverId());
            ps.setString(10, object.getStatusId());
            ps.setString(11, object.getTypeId());
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
    public void update(Reimbursement object) {

    }

    @Override
    public void delete(String id) {

    }

    @Override
    public Reimbursement getById(String id) {
        return null;
    }

    @Override
    public List<Reimbursement> getAll() {
        return null;
    }
}
