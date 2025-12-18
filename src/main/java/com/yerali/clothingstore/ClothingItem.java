package com.yerali.clothingstore;

public class ClothingItem {

    private int id;
    private String name;
    private String size;   // S, M, L, XL
    private double price;  // in KZT
    private Brand brand;   // OOP: composition

    public ClothingItem(int id, String name, String size, double price, Brand brand) {
        this.id = id;
        this.name = name;
        this.size = size;
        setPrice(price);
        this.brand = brand;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getSize() {
        return size;
    }

    public double getPrice() {
        return price;
    }

    public Brand getBrand() {
        return brand;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public void setPrice(double price) {
        if (price < 0) {
            this.price = 0;
        } else {
            this.price = price;
        }
    }

    public void setBrand(Brand brand) {
        this.brand = brand;
    }

    public void applyDiscount(double percent) {
        if (percent < 0) percent = 0;
        if (percent > 100) percent = 100;
        price = price * (1 - percent / 100.0);
    }

    public boolean isExpensive() {
        return price > 50000;
    }

    @Override
    public String toString() {
        return "ClothingItem{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", size='" + size + '\'' +
                ", price=" + price +
                ", expensive=" + isExpensive() +
                ", brand=" + (brand != null ? brand.getName() : "NoBrand") +
                '}';
    }
}
