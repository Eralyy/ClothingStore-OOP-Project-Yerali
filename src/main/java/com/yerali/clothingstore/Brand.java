package com.yerali.clothingstore;

public class Brand {

    private int id;
    private String name;
    private String country;
    private double rating; // 0.0 to 5.0

    public Brand(int id, String name, String country, double rating) {
        this.id = id;
        this.name = name;
        this.country = country;
        setRating(rating); // uses validation
    }

    // Getters
    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getCountry() {
        return country;
    }

    public double getRating() {
        return rating;
    }

    // Setters
    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public void setRating(double rating) {
        // keep rating between 0 and 5
        if (rating < 0) {
            this.rating = 0;
        } else if (rating > 5) {
            this.rating = 5;
        } else {
            this.rating = rating;
        }
    }

    // Logic method #1
    public boolean isPremium() {
        return rating >= 4.5;
    }

    // Logic method #2
    public void increaseRating(double value) {
        setRating(this.rating + value);
    }

    @Override
    public String toString() {
        return "Brand{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", country='" + country + '\'' +
                ", rating=" + rating +
                ", premium=" + isPremium() +
                '}';
    }
}

