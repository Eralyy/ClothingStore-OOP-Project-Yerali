package com.yerali.clothingstore;

public class ClothingBrandsOopApplication {

    public static void main(String[] args) {

        System.out.println("=== Clothing Store OOP System (Week 2) ===");
        System.out.println("Project: Clothing Brands Management");
        System.out.println("Student: Yerali");
        System.out.println("-----------------------------------------");

        // 1) Create objects (5+ total)
        Brand brand1 = new Brand(1, "ZARA", "Spain", 4.6);
        Brand brand2 = new Brand(2, "Uniqlo", "Japan", 4.3);

        ClothingItem item1 = new ClothingItem(101, "Basic T-Shirt", "M", 12990, brand2);
        ClothingItem item2 = new ClothingItem(102, "Jacket", "L", 79990, brand1);

        Order order1 = new Order(5001, "Ayan", 0, "Pending");

        // 2) Print objects (toString)
        System.out.println("\n--- OBJECTS (toString) ---");
        System.out.println(brand1);
        System.out.println(brand2);
        System.out.println(item1);
        System.out.println(item2);
        System.out.println(order1);

        // 3) Test getters
        System.out.println("\n--- TESTING GETTERS ---");
        System.out.println("brand1 name: " + brand1.getName());
        System.out.println("item2 price: " + item2.getPrice());
        System.out.println("order1 status: " + order1.getStatus());

        // 4) Test setters
        System.out.println("\n--- TESTING SETTERS ---");
        brand2.setCountry("Japan (Tokyo)");
        item1.setSize("S");
        order1.setCustomerName("Aruzhan");
        System.out.println("Updated brand2 country: " + brand2.getCountry());
        System.out.println("Updated item1 size: " + item1.getSize());
        System.out.println("Updated order1 customer: " + order1.getCustomerName());

        // 5) Test logic methods
        System.out.println("\n--- TESTING METHODS (LOGIC) ---");

        System.out.println("Is brand1 premium? " + brand1.isPremium());
        brand2.increaseRating(0.4);
        System.out.println("brand2 rating after increase: " + brand2.getRating());

        System.out.println("item2 expensive before discount? " + item2.isExpensive());
        item2.applyDiscount(15);
        System.out.println("item2 price after 15% discount: " + item2.getPrice());
        System.out.println("item2 expensive after discount? " + item2.isExpensive());

        order1.addToTotal(item1.getPrice());
        order1.addToTotal(item2.getPrice());
        System.out.println("order1 total after adding items: " + order1.getTotalAmount());

        System.out.println("order1 is pending? " + order1.isPending());
        order1.complete();
        System.out.println("order1 status after complete(): " + order1.getStatus());

        // 6) Final state print
        System.out.println("\n--- FINAL STATE ---");
        System.out.println(brand2);
        System.out.println(item1);
        System.out.println(item2);
        System.out.println(order1);

        System.out.println("\n=== Program Complete ===");
    }
}

