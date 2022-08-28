package com.revature.emirRandyP1.models;

public class Order {
    private String id;
    private String total;
    private String userId;
    private String flowerShopId = "AVAILABLE_ALL_STORES";

    public Order() {
    }

    public Order(String id, String total, String userId, String flowerShopId) {
        this.id = id;
        this.total = total;
        this.userId = userId;
        this.flowerShopId = flowerShopId;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTotal() {
        return total;
    }

    public void setTotal(String total) {
        this.total = total;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getFlowerShopId() {
        return flowerShopId;
    }

    public void setFlowerShopId(String flowerShopId) {
        this.flowerShopId = flowerShopId;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id='" + id + '\'' +
                ", price='" + total + '\'' +
                ", userId='" + userId + '\'' +
                ", flowerShopId='" + flowerShopId + '\'' +
                '}';
    }
}
