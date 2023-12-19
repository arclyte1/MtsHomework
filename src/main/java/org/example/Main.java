package org.example;

import java.math.BigDecimal;
import java.text.NumberFormat;

public class Main {

    public static void main(String[] args) {
        CreateAnimalService service = new CreateAnimalService() { };
        service.createAnimals();

        CreateAnimalServiceImpl serviceImpl = new CreateAnimalServiceImpl();
        serviceImpl.createAnimals();
        serviceImpl.createAnimals(15);
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