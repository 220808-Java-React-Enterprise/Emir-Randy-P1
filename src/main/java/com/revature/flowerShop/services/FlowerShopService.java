package com.revature.flowerShop.services;

import com.revature.flowerShop.daos.FlowerShopDAO;
import com.revature.flowerShop.models.FlowerShop;
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
