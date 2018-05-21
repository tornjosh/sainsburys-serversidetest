package com.josh.torn.sainsburys;

/**
 *  ProductItem
 *
 *
 */
class ProductItem {

    public String title;
    public String unitPrice;
    public String kcalPer100g;
    public String description;

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
