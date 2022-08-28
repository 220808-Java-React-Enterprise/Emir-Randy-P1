package com.revature.flowerShop.daos;


import com.revature.flowerShop.models.Order;
import com.revature.flowerShop.models.User;

import java.util.List;

public interface CrudDAO<T>{
    void save(User object);

    void update(User object);

    void save(T object);

    void save(Order object);

    void update(T object);
    void delete(String id);
    T getById(String id);
    List<T> getAll();


}
