package com.revature.emirRandyP1.services;

import com.revature.emirRandyP1.daos.FlowerShopDAO;
import com.revature.emirRandyP1.models.FlowerShop;
import java.util.List;

public class FlowerShopService {

        private final FlowerShopDAO flowerShopDAO;
    public FlowerShopService(FlowerShopDAO flowerShopDAO) {
        this.flowerShopDAO = flowerShopDAO;
    }

    public List<FlowerShop> getAllFlowerShopNames(){
        return flowerShopDAO.getAll();
    }
}
