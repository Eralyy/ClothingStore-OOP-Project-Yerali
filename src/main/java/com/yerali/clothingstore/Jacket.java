package com.yerali.clothingstore;

public class Jacket extends ClothingItem {

    private boolean waterproof;

    public Jacket(int id, String name, String size, double price,
                  Brand brand, boolean waterproof) {
        super(id, name, size, price, brand);
        this.waterproof = waterproof;
    }

    public boolean isWaterproof() {
        return waterproof;
    }

    public void setWaterproof(boolean waterproof) {
        this.waterproof = waterproof;
    }

    @Override
    public String getItemType() {
        return "Jacket";
    }
}

