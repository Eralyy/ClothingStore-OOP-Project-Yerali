package com.yerali.clothingstore.model;

public abstract class ClothingItem {

    private int id;
    private String name;
    private String size;
    private double price;
    private Brand brand;

    public ClothingItem(int id, String name, String size, double price, Brand brand) {
        setId(id);
        setName(name);
        setSize(size);
        setPrice(price);
        setBrand(brand);
    }

    // ===== GETTERS =====
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

    // ===== SETTERS (WITH EXCEPTIONS – WEEK 6 RULE) =====
    public void setId(int id) {
        if (id <= 0) {
            throw new IllegalArgumentException("Item ID must be positive");
        }
        this.id = id;
    }

    public void setName(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("Item name cannot be empty");
        }
        this.name = name;
    }

    public void setSize(String size) {
        if (size == null || size.trim().isEmpty()) {
            throw new IllegalArgumentException("Size cannot be empty");
        }
        this.size = size;
    }

    public void setPrice(double price) {
        if (price < 0) {
            throw new IllegalArgumentException("Price cannot be negative");
        }
        this.price = price;
    }

    public void setBrand(Brand brand) {
        if (brand == null) {
            throw new IllegalArgumentException("Brand cannot be null");
        }
        this.brand = brand;
    }

    // ===== BUSINESS LOGIC =====
    public void applyDiscount(double percent) {
        if (percent < 0 || percent > 100) {
            throw new IllegalArgumentException("Discount must be between 0 and 100");
        }
        price = price * (1 - percent / 100.0);
    }

    public boolean isExpensive() {
        return price > 50000;
    }

    // ===== ABSTRACT METHOD (REQUIRED) =====
    public abstract String getItemType();

    @Override
    public String toString() {
        return "ClothingItem{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", size='" + size + '\'' +
                ", price=" + price +
                ", type=" + getItemType() +
                ", expensive=" + isExpensive() +
                ", brand=" + brand.getName() +
                '}';
    }
}

