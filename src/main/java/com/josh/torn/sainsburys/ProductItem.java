package com.josh.torn.sainsburys;

/**
 *  ProductItem
 *
 *
 */
class ProductItem {

    private String title;
    private String unitPrice;
    private String kcalPer100g;
    private String description;

    ProductItem(String title, String unitPrice,
                String kcalPer100g, String description) {
        this.title = title;
        this.unitPrice = unitPrice;
        this.kcalPer100g = kcalPer100g;
        this.description = description;
    }

    String getTitle() {
        return title;
    }

    String getUnitPrice() {
        return unitPrice;
    }

    String getKcalPer100g() {
        return kcalPer100g;
    }

    String getDescription() {
        return description;
    }
}
