package com.yerali.clothingstore;

public class TShirt extends ClothingItem {

    private String sleeveType;

    public TShirt(int id, String name, String size, double price,
                  Brand brand, String sleeveType) {
        super(id, name, size, price, brand);
        this.sleeveType = sleeveType;
    }

    public String getSleeveType() {
        return sleeveType;
    }

    public void setSleeveType(String sleeveType) {
        this.sleeveType = sleeveType;
    }

    @Override
    public String getItemType() {
        return "T-Shirt";
    }
}

