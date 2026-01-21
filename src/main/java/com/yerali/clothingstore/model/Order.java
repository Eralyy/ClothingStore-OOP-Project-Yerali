package com.yerali.clothingstore.model;

public class Order {

    private int id;
    private String customerName;
    private double totalAmount;
    private String status;

    public Order(int id, String customerName, double totalAmount, String status) {
        setId(id);
        setCustomerName(customerName);
        setTotalAmount(totalAmount);
        setStatus(status);
    }

    public int getId() {
        return id;
    }

    public String getCustomerName() {
        return customerName;
    }

    public double getTotalAmount() {
        return totalAmount;
    }

    public String getStatus() {
        return status;
    }


    public void setId(int id) {
        if (id <= 0) {
            throw new IllegalArgumentException("Order ID must be positive");
        }
        this.id = id;
    }

    public void setCustomerName(String customerName) {
        if (customerName == null || customerName.trim().isEmpty()) {
            throw new IllegalArgumentException("Customer name cannot be empty");
        }
        this.customerName = customerName;
    }

    public void setTotalAmount(double totalAmount) {
        if (totalAmount < 0) {
            throw new IllegalArgumentException("Total amount cannot be negative");
        }
        this.totalAmount = totalAmount;
    }

    public void setStatus(String status) {
        if (status == null || status.trim().isEmpty()) {
            throw new IllegalArgumentException("Order status cannot be empty");
        }

        String s = status.trim().toLowerCase();
        if (!s.equals("pending") && !s.equals("completed") && !s.equals("cancelled")) {
            throw new IllegalArgumentException("Invalid order status: " + status);
        }

        this.status = capitalize(s);
    }

    public void addToTotal(double amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException("Amount must be positive");
        }
        totalAmount += amount;
    }

    public void complete() {
        status = "Completed";
    }

    public boolean isPending() {
        return "Pending".equals(status);
    }


    private String capitalize(String s) {
        return s.substring(0, 1).toUpperCase() + s.substring(1);
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", customerName='" + customerName + '\'' +
                ", totalAmount=" + totalAmount +
                ", status='" + status + '\'' +
                '}';
    }
}
