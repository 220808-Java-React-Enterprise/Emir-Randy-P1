package com.revature.emirRandyP1.daos;

import com.revature.emirRandyP1.models.User;

import java.util.List;

public interface CrudDAO<T>{
    void save(User object);

    void update(User object);

    void save(T object);

    void update(T object);

    void delete(String id);

    T getById(String id);

    List<T> getAll();


}
