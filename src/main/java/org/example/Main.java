package org.example;

import java.math.BigDecimal;
import java.text.NumberFormat;

public class Main {

    public static void main(String[] args) {
        Purchase purchase1 = new Purchase(100, new BigDecimal(150), new BigDecimal("0.75"));
        Purchase purchase2 = new Purchase(100, new BigDecimal(150), new BigDecimal("42.575"));
        Purchase purchase3 = new Purchase(100, new BigDecimal(150), new BigDecimal("59.1"));

        printFinalCost(purchase1);
        printFinalCost(purchase2);
        printFinalCost(purchase3);
    }

    public static void printFinalCost(Purchase purchase) {
        BigDecimal finalCostWithoutDiscount = purchase.getProductCost().multiply(BigDecimal.valueOf(purchase.getProductCount()));

        BigDecimal discountMultiplier = BigDecimal.valueOf(1).subtract(purchase.getDiscount().movePointLeft(2));
        BigDecimal finalCostWithDiscount = finalCostWithoutDiscount.multiply(discountMultiplier);

        NumberFormat numberFormat = NumberFormat.getNumberInstance();
        numberFormat.setMaximumFractionDigits(2);
        numberFormat.setGroupingUsed(false);
        System.out.println("Final cost without discount = " + numberFormat.format(finalCostWithoutDiscount));
        System.out.println("Final cost with discount = " + numberFormat.format(finalCostWithDiscount));
    }
}