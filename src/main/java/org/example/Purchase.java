package org.example;


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
}
