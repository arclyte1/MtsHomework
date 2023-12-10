package org.example;

import java.text.NumberFormat;

/**
 * Purchase model.
 * Including {@link Purchase#productCount}, {@link Purchase#productCost} and {@link Purchase#discount}
 */
public class Purchase {

    // Total number of products
    int productCount;

    // Cost of single product
    double productCost;

    // Percent of discount that has to be applied while calculating final cost
    double discount;

    public Purchase() {
        this.productCount = 0;
        this.productCost = 0;
        this.discount = 0;
    }

    public Purchase(int productCount, double productCost, double discount) {
        this.productCount = productCount;
        this.productCost = productCost;
        this.discount = discount;
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
