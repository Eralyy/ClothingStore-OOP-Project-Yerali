package com.yerali.clothingstore;

public class Order {

    private int id;
    private String customerName;
    private double totalAmount;
    private String status; // Pending, Completed, Cancelled

    public Order(int id, String customerName, double totalAmount, String status) {
        this.id = id;
        this.customerName = customerName;
        setTotalAmount(totalAmount);
        setStatus(status);
    }

    // Getters
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

    // Setters
    public void setId(int id) {
        this.id = id;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public void setTotalAmount(double totalAmount) {
        if (totalAmount < 0) {
            this.totalAmount = 0;
        } else {
            this.totalAmount = totalAmount;
        }
    }

    public void setStatus(String status) {
        if (status == null) {
            this.status = "Pending";
            return;
        }
        String s = status.trim().toLowerCase();
        if (s.equals("pending") || s.equals("completed") || s.equals("cancelled")) {
            this.status = capitalize(s);
        } else {
            this.status = "Pending";
        }
    }

    private String capitalize(String s) {
        return s.substring(0, 1).toUpperCase() + s.substring(1);
    }

    // Logic method #1
    public void addToTotal(double amount) {
        if (amount > 0) {
            totalAmount += amount;
        }
    }

    // Logic method #2
    public void complete() {
        status = "Completed";
    }

    // (extra logic method - ok to have more)
    public boolean isPending() {
        return status.equals("Pending");
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
