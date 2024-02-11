package org.example;

import org.example.main.MainHw1;
import org.example.model.Purchase;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertInstanceOf;

public class PurchaseUnitTests {

    private static final ByteArrayOutputStream OUT_STREAM = new ByteArrayOutputStream();

    @BeforeAll
    static void setUp() {
        System.setOut(new PrintStream(OUT_STREAM));
    }

    @Test
    void calculateFinalCostWithValidParameters() {
        Purchase purchase = new Purchase(100, new BigDecimal(150), new BigDecimal("0.75"));
        MainHw1.printFinalCost(purchase);
        assertEquals(OUT_STREAM.toString(), "Final cost without discount = 15000\r\nFinal cost with discount = 14887.5\r\n");
    }

    @Test
    void createPurchaseWithInvalidProductCount() {
        Exception catchedException = null;
        try {
            Purchase purchase = new Purchase(-1, new BigDecimal(150), new BigDecimal("0.75"));
        } catch (IllegalArgumentException e) {
            catchedException = e;
        }
        assertInstanceOf(IllegalArgumentException.class, catchedException);
    }

    @Test
    void createPurchaseWithInvalidProductCost() {
        Exception catchedException = null;
        try {
            Purchase purchase = new Purchase(100, new BigDecimal(-5), new BigDecimal("0.75"));
        } catch (IllegalArgumentException e) {
            catchedException = e;
        }
        assertInstanceOf(IllegalArgumentException.class, catchedException);
    }

    @Test
    void createPurchaseWithInvalidDiscount() {
        BigDecimal[] discounts = new BigDecimal[]{
                new BigDecimal("-1"),
                new BigDecimal("110")
        };

        for (BigDecimal discount : discounts) {
            Exception catchedException = null;
            try {
                Purchase purchase = new Purchase(10, new BigDecimal(150), discount);
            } catch (IllegalArgumentException e) {
                catchedException = e;
            }
            assertInstanceOf(IllegalArgumentException.class, catchedException);
        }
    }
}
