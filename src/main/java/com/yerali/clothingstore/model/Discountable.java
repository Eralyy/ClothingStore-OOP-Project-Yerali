package com.yerali.clothingstore.model;

public interface Discountable {

    void applyDiscount(double percent);

    boolean isDiscountApplicable();
}
