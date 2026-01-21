package com.yerali.clothingstore;

import com.yerali.clothingstore.model.Brand;
import com.yerali.clothingstore.model.ClothingItem;
import com.yerali.clothingstore.model.Order;

import java.util.ArrayList;

public class StoreManager {

    private final ArrayList<Brand> brands;
    private final ArrayList<ClothingItem> items;
    private final ArrayList<Order> orders;

    public StoreManager() {
        brands = new ArrayList<>();
        items = new ArrayList<>();
        orders = new ArrayList<>();
    }

    public void addBrand(Brand brand) {
        if (brand == null) {
            throw new IllegalArgumentException("Brand cannot be null");
        }
        brands.add(brand);
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
        throw new IllegalArgumentException("Brand with ID " + id + " not found");
    }

    public void addItem(ClothingItem item) {
        if (item == null) {
            throw new IllegalArgumentException("Clothing item cannot be null");
        }
        items.add(item);
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
        throw new IllegalArgumentException("Item with ID " + id + " not found");
    }


    public void addOrder(Order order) {
        if (order == null) {
            throw new IllegalArgumentException("Order cannot be null");
        }
        orders.add(order);
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
        throw new IllegalArgumentException("Order with ID " + id + " not found");
    }
}
