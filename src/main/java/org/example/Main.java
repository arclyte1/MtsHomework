package org.example;

import java.text.NumberFormat;

public class Main {

    public static void main(String[] args) {
        Purchase purchase1 = new Purchase(100, 150, 0.75);
        Purchase purchase2 = new Purchase(100, 150, 42.575);
        Purchase purchase3 = new Purchase(100, 150, 59.1);

        printFinalCost(purchase1);
        printFinalCost(purchase2);
        printFinalCost(purchase3);
    }

    public static void printFinalCost(Purchase purchase) {
        double finalCostWithoutDiscount = purchase.productCost * purchase.productCount;
        double finalCostWithDiscount = finalCostWithoutDiscount * (1 - purchase.discount / 100);

        NumberFormat numberFormat = NumberFormat.getNumberInstance();
        numberFormat.setMaximumFractionDigits(2);
        numberFormat.setGroupingUsed(false);
        System.out.println("Final cost without discount = " + numberFormat.format(finalCostWithoutDiscount));
        System.out.println("Final cost with discount = " + numberFormat.format(finalCostWithDiscount));
    }
}