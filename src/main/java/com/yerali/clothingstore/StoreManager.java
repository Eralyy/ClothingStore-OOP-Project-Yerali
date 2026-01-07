package com.yerali.clothingstore;

import java.util.ArrayList;

public class StoreManager {

    private ArrayList<Brand> brands;
    private ArrayList<ClothingItem> items;
    private ArrayList<Order> orders;

    public StoreManager() {
        brands = new ArrayList<>();
        items = new ArrayList<>();
        orders = new ArrayList<>();
    }



    public void addBrand(Brand brand) {
        if (brand != null) {
            brands.add(brand);
        }
    }

    public ArrayList<Brand> getBrands() {
        return brands;
    }

    public void showBrands() {
        System.out.println("\n--- BRANDS LIST ---");
        if (brands.isEmpty()) {
            System.out.println("No brands available.");
            return;
        }
        for (Brand b : brands) {
            System.out.println(b);
        }
    }

    public Brand findBrandById(int id) {
        for (Brand b : brands) {
            if (b.getId() == id) {
                return b;
            }
        }
        return null;
    }


    public void addItem(ClothingItem item) {
        if (item != null) {
            items.add(item);
        }
    }

    public ArrayList<ClothingItem> getItems() {
        return items;
    }

    public void showItems() {
        System.out.println("\n--- CLOTHING ITEMS LIST ---");
        if (items.isEmpty()) {
            System.out.println("No clothing items available.");
            return;
        }
        for (ClothingItem i : items) {
            System.out.println(i);
        }
    }

    public ClothingItem findItemById(int id) {
        for (ClothingItem i : items) {
            if (i.getId() == id) {
                return i;
            }
        }
        return null;
    }



    public void addOrder(Order order) {
        if (order != null) {
            orders.add(order);
        }
    }

    public ArrayList<Order> getOrders() {
        return orders;
    }

    public void showOrders() {
        System.out.println("\n--- ORDERS LIST ---");
        if (orders.isEmpty()) {
            System.out.println("No orders available.");
            return;
        }
        for (Order o : orders) {
            System.out.println(o);
        }
    }

    public Order findOrderById(int id) {
        for (Order o : orders) {
            if (o.getId() == id) {
                return o;
            }
        }
        return null;
    }
}

