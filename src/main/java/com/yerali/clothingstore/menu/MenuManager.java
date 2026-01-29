package com.yerali.clothingstore.menu;

import com.yerali.clothingstore.database.ClothingItemDAO;
import com.yerali.clothingstore.model.*;

import java.util.Scanner;

public class MenuManager implements Menu {

    private final ClothingItemDAO itemDAO;
    private final Scanner scanner;
    private boolean running = true;

    public MenuManager() {
        itemDAO = new ClothingItemDAO();
        scanner = new Scanner(System.in);
    }

    @Override
    public void displayMenu() {
        System.out.println("\n=== CLOTHING STORE MENU ===");
        System.out.println("1. Show clothing items (from DB)");
        System.out.println("2. Add clothing item");
        System.out.println("3. Update clothing item");
        System.out.println("4. Delete clothing item");
        System.out.println("0. Exit");
        System.out.print("Choose option: ");
    }

    @Override
    public void run() {

        System.out.println("=== Clothing Store OOP System (Week 8) ===");

        while (running) {
            displayMenu();

            try {
                int choice = Integer.parseInt(scanner.nextLine());

                switch (choice) {
                    case 1 -> showItemsFromDB();
                    case 2 -> addItemToDB();
                    case 3 -> updateItemInDB();
                    case 4 -> deleteItemFromDB();
                    case 0 -> exit();
                    default -> System.out.println("Invalid option!");
                }

            } catch (NumberFormatException e) {
                System.out.println("Please enter a number.");
            }
        }

        scanner.close();
    }

    /* ===================== MENU ACTIONS ===================== */

    private void showItemsFromDB() {
        System.out.println("\n--- ITEMS FROM DATABASE ---");
        itemDAO.getAllItems().forEach(System.out::println);
    }

    private void addItemToDB() {
        try {
            System.out.print("ID: ");
            int id = Integer.parseInt(scanner.nextLine());

            System.out.print("Name: ");
            String name = scanner.nextLine();

            System.out.print("Size: ");
            String size = scanner.nextLine();

            System.out.print("Price: ");
            double price = Double.parseDouble(scanner.nextLine());

            System.out.print("Brand name: ");
            String brandName = scanner.nextLine();

            Brand brand = new Brand(1, brandName, "Unknown", 4.0);

            ClothingItem item = new TShirt(
                    id,
                    name,
                    size,
                    price,
                    brand,
                    "Short"
            );

            itemDAO.insertItem(item);

        } catch (Exception e) {
            System.out.println("Error adding item: " + e.getMessage());
        }
    }

    private void updateItemInDB() {
        try {
            System.out.print("Item ID: ");
            int id = Integer.parseInt(scanner.nextLine());

            System.out.print("New price: ");
            double price = Double.parseDouble(scanner.nextLine());

            System.out.print("New size: ");
            String size = scanner.nextLine();

            itemDAO.updateItem(id, price, size);

        } catch (Exception e) {
            System.out.println("Error updating item.");
        }
    }

    private void deleteItemFromDB() {
        try {
            System.out.print("Item ID: ");
            int id = Integer.parseInt(scanner.nextLine());

            itemDAO.deleteItem(id);

        } catch (Exception e) {
            System.out.println("Error deleting item.");
        }
    }

    private void exit() {
        running = false;
        System.out.println("Exiting program...");
    }
}
