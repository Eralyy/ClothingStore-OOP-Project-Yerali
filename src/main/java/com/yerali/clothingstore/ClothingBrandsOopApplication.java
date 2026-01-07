package com.yerali.clothingstore;

import java.util.Scanner;

public class ClothingBrandsOopApplication {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        StoreManager manager = new StoreManager();

        System.out.println("=== Clothing Store OOP System (Week 4) ===");
        System.out.println("Project: Clothing Brands Management");
        System.out.println("Student: Yerali");
        System.out.println("-----------------------------------------");


        manager.addBrand(new Brand(1, "ZARA", "Spain", 4.6));
        manager.addBrand(new Brand(2, "Uniqlo", "Japan", 4.3));


        ClothingItem item1 = new TShirt(
                101,
                "Basic T-Shirt",
                "M",
                12990,
                manager.findBrandById(2),
                "Short"
        );

        ClothingItem item2 = new Jacket(
                102,
                "Jacket",
                "L",
                79990,
                manager.findBrandById(1),
                true
        );

        manager.addItem(item1);
        manager.addItem(item2);

        boolean running = true;

        while (running) {

            System.out.println("\n=== CLOTHING STORE MENU ===");
            System.out.println("1. Show brands");
            System.out.println("2. Show clothing items");
            System.out.println("3. Show orders");
            System.out.println("4. Add order");
            System.out.println("0. Exit");
            System.out.print("Choose option: ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {

                case 1:
                    manager.showBrands();
                    break;

                case 2:
                    manager.showItems();
                    break;

                case 3:
                    manager.showOrders();
                    break;

                case 4:
                    System.out.print("Enter order id: ");
                    int orderId = scanner.nextInt();
                    scanner.nextLine();

                    System.out.print("Enter customer name: ");
                    String customerName = scanner.nextLine();

                    Order order = new Order(orderId, customerName, 0, "Pending");
                    manager.addOrder(order);

                    System.out.println("Order successfully added.");
                    break;

                case 0:
                    running = false;
                    System.out.println("Exiting program...");
                    break;

                default:
                    System.out.println("Invalid option!");
            }
        }

        scanner.close();
        System.out.println("=== Program Complete ===");
    }
}


