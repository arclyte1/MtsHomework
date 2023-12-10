package org.example;

public class Main {

    public static void main(String[] args) {
        Purchase purchase1 = new Purchase(100, 150, 0.75);
        Purchase purchase2 = new Purchase(100, 150, 42.575);
        Purchase purchase3 = new Purchase(100, 150, 59.1);

        Purchase.printFinalCost(purchase1);
        Purchase.printFinalCost(purchase2);
        Purchase.printFinalCost(purchase3);
    }
}