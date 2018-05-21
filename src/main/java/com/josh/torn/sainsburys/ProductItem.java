package com.josh.torn.sainsburys;

/**
 * ProductItem
 *
 */
class ProductItem {

    private String title;
    private double unitPrice;
    private int kcalPer100g;
    private String description;

    ProductItem(String title, double unitPrice,
                int kcalPer100g, String description) {
        this.title = title;
        this.unitPrice = unitPrice;
        this.kcalPer100g = kcalPer100g;
        this.description = description;
    }

    String getTitle() {
        return title;
    }

    double getUnitPrice() {
        return unitPrice;
    }

    double getKcalPer100g() {
        return kcalPer100g;
    }

    String getDescription() {
        return description;
    }
}