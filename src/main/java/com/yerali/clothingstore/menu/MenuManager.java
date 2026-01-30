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
        System.out.println("1. Show all clothing items");
        System.out.println("2. Add clothing item");
        System.out.println("3. Update clothing item");
        System.out.println("4. Delete clothing item");
        System.out.println("5. Search by name");
        System.out.println("6. Search by price range");
        System.out.println("7. Search by minimum price");
        System.out.println("0. Exit");
        System.out.print("Choose option: ");
    }

    @Override
    public void run() {

        System.out.println("=== Clothing Store OOP System (Week 8 – CRUD + SEARCH) ===");

        while (running) {
            displayMenu();

            try {
                int choice = Integer.parseInt(scanner.nextLine());

                switch (choice) {
                    case 1 -> showItems();
                    case 2 -> addItem();
                    case 3 -> updateItem();
                    case 4 -> deleteItem();
                    case 5 -> searchByName();
                    case 6 -> searchByPriceRange();
                    case 7 -> searchByMinPrice();
                    case 0 -> exit();
                    default -> System.out.println("Invalid option!");
                }

            } catch (NumberFormatException e) {
                System.out.println("Please enter a valid number.");
            }
        }

        scanner.close();
    }

    /* ===================== MENU ACTIONS ===================== */

    // SELECT
    private void showItems() {
        System.out.println("\n--- ITEMS FROM DATABASE ---");
        itemDAO.getAllItems().forEach(System.out::println);
    }

    // INSERT
    private void addItem() {
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

            Brand brand = new Brand(
                    Math.abs(id) + 1,   // гарантированно > 0
                    brandName,
                    "Unknown",
                    4.0
            );



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

    // UPDATE
    private void updateItem() {
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

    // DELETE
    private void deleteItem() {
        try {
            System.out.print("Item ID: ");
            int id = Integer.parseInt(scanner.nextLine());

            itemDAO.deleteItem(id);

        } catch (Exception e) {
            System.out.println("Error deleting item.");
        }
    }

    // SEARCH BY NAME
    private void searchByName() {
        System.out.print("Enter name to search: ");
        String name = scanner.nextLine();

        itemDAO.searchByName(name).forEach(System.out::println);
    }

    // SEARCH BY PRICE RANGE
    private void searchByPriceRange() {
        try {
            System.out.print("Min price: ");
            double min = Double.parseDouble(scanner.nextLine());

            System.out.print("Max price: ");
            double max = Double.parseDouble(scanner.nextLine());

            itemDAO.searchByPriceRange(min, max).forEach(System.out::println);

        } catch (Exception e) {
            System.out.println("Invalid price range.");
        }
    }

    // SEARCH BY MIN PRICE
    private void searchByMinPrice() {
        try {
            System.out.print("Minimum price: ");
            double min = Double.parseDouble(scanner.nextLine());

            itemDAO.searchByMinPrice(min).forEach(System.out::println);

        } catch (Exception e) {
            System.out.println("Invalid price.");
        }
    }

    private void exit() {
        running = false;
        System.out.println("Exiting program...");
    }
}
