package com.revature.flowerShop.services;

import com.revature.flowerShop.daos.FlowerDAO;
import com.revature.flowerShop.models.Flower;
import com.revature.flowerShop.utils.custom_exceptions.InvalidUserException;

import java.util.List;

public class FlowerServices {

    private final FlowerDAO flowerDAO;

    public FlowerServices(FlowerDAO flowerDAO) {
        this.flowerDAO = flowerDAO;
    }

    public List<Flower> getAllFlowerInformation() {
        return flowerDAO.getAll();
    }

    public void register(Flower flower) {
        flowerDAO.save(flower);
    }

    public void validateFlowerName(String flowerName) {
        if (!flowerName.matches("^[a-zA-Z]+$"))
            throw new InvalidUserException("\nINVALID INPUT! ONE OR MORE LETTERS ARE ALLOWED IN THE PRODUCT NAME! NO DIGITS, NO SPACES!, NO SYMBOLS!.");
    }

    public void validateFlowerPrice(String flowerPrice) {
        if (!flowerPrice.matches("[0-9]+")) throw  new InvalidUserException("\nINVALID INPUT! ONE OR MORE DIGITS ARE ALLOWED IN THE PRICE NAME! NO LETTERS, NO SYMBOLS, NO SPACES.");
    }

    public void updateFlower(String id, String price, String name){
        flowerDAO.update(id, price, name);
    }

    public void deleteFlower(String id){
        flowerDAO.delete(id);
    }
}


