package com.revature.flowerShop.models;

public class FlowerShop {
    private String id;
    private String name;
    private String size;
    private String location;

    public FlowerShop() {
    }

    public FlowerShop(String id, String name, String size, String location) {
        this.id = id;
        this.name = name;
        this.size = size;
        this.location = location;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    @Override
    public String toString() {
        return "FlowerShop{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", size='" + size + '\'' +
                ", location='" + location + '\'' +
                '}';
    }
}
