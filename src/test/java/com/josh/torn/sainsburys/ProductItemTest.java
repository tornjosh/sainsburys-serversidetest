package com.josh.torn.sainsburys;

import org.junit.Test;

import static org.junit.Assert.*;

public class ProductItemTest {

    private ProductItem grapes = new ProductItem("grapes", 2.99, 44, "A punnet of grapes.");

    @Test
    public void getTitle() throws Exception {
        if (grapes.getTitle().equals("Grapes")) {
            assertTrue(true);
        }
    }

    @Test
    public void getUnitPrice() throws Exception {
        if (grapes.getUnitPrice() == 2.99) {
            assertTrue(true);
        }
    }

    @Test
    public void getKcalPer100g() throws Exception {
        if (grapes.getKcalPer100g() == 44) {
            assertTrue(true);
        }
    }

    @Test
    public void getDescription() throws Exception {
        if (grapes.getDescription().equals("A punnet of grapes.")) {
            assertTrue(true);
        }
    }

}