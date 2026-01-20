package com.yerali.clothingstore.menu;

import com.yerali.clothingstore.StoreManager;
import com.yerali.clothingstore.model.Brand;
import com.yerali.clothingstore.model.ClothingItem;
import com.yerali.clothingstore.model.Jacket;
import com.yerali.clothingstore.model.Order;
import com.yerali.clothingstore.model.TShirt;

import java.util.Scanner;

public class MenuManager implements Menu {

    private final Scanner scanner;
    private final StoreManager manager;
    private boolean running = true;

    public MenuManager() {
        scanner = new Scanner(System.in);
        manager = new StoreManager();

        // Initial data
        manager.addBrand(new Brand(1, "ZARA", "Spain", 4.6));
        manager.addBrand(new Brand(2, "Uniqlo", "Japan", 4.3));

        ClothingItem t1 = new TShirt(
                101,
                "Basic T-Shirt",
                "M",
                12990,
                manager.findBrandById(2),
                "Short"
        );

        ClothingItem j1 = new Jacket(
                102,
                "Winter Jacket",
                "L",
                79990,
                manager.findBrandById(1),
                true
        );

        manager.addItem(t1);
        manager.addItem(j1);
    }

    @Override
    public void displayMenu() {
        System.out.println("\n=== CLOTHING STORE MENU ===");
        System.out.println("1. Show brands");
        System.out.println("2. Show clothing items");
        System.out.println("3. Show orders");
        System.out.println("4. Add order");
        System.out.println("0. Exit");
        System.out.print("Choose option: ");
    }

    @Override
    public void run() {

        System.out.println("=== Clothing Store OOP System (Week 6) ===");

        while (running) {
            displayMenu();

            try {
                int choice = Integer.parseInt(scanner.nextLine());

                switch (choice) {
                    case 1 -> manager.showBrands();
                    case 2 -> manager.showItems();
                    case 3 -> manager.showOrders();
                    case 4 -> addOrder();
                    case 0 -> exit();
                    default -> System.out.println("Invalid option!");
                }

            } catch (NumberFormatException e) {
                System.out.println("Please enter a number.");
            } catch (IllegalArgumentException e) {
                System.out.println("Error: " + e.getMessage());
            }
        }

        scanner.close();
    }

    private void addOrder() {
        try {
            System.out.print("Enter order ID: ");
            int id = Integer.parseInt(scanner.nextLine());

            System.out.print("Enter customer name: ");
            String name = scanner.nextLine();

            Order order = new Order(id, name, 0, "Pending");
            manager.addOrder(order);

            System.out.println("Order added successfully.");

        } catch (NumberFormatException e) {
            System.out.println("Order ID must be numeric.");
        }
    }

    private void exit() {
        running = false;
        System.out.println("Exiting program...");
    }
}
