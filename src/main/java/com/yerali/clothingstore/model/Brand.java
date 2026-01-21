package com.yerali.clothingstore.model;

public class Brand {

    private int id;
    private String name;
    private String country;
    private double rating;

    public Brand(int id, String name, String country, double rating) {
        setId(id);
        setName(name);
        setCountry(country);
        setRating(rating);
    }

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

    public void setId(int id) {
        if (id <= 0) {
            throw new IllegalArgumentException("Brand ID must be positive");
        }
        this.id = id;
    }

    public void setName(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("Brand name cannot be empty");
        }
        this.name = name;
    }

    public void setCountry(String country) {
        if (country == null || country.trim().isEmpty()) {
            throw new IllegalArgumentException("Country cannot be empty");
        }
        this.country = country;
    }

    public void setRating(double rating) {
        if (rating < 0 || rating > 5) {
            throw new IllegalArgumentException(
                    "Rating must be between 0 and 5"
            );
        }
        this.rating = rating;
    }

    public boolean isPremium() {
        return rating >= 4.5;
    }

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


