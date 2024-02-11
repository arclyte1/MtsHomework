package org.example.model;


import java.math.BigDecimal;

/**
 * Purchase model.
 * Including {@link Purchase#productCount}, {@link Purchase#productCost} and {@link Purchase#discount}
 */
public class Purchase {

    // Total number of products
    private int productCount;

    // Cost of single product
    private BigDecimal productCost;

    // Percent of discount that has to be applied while calculating final cost
    private BigDecimal discount;

    public Purchase() {
        this.productCount = 0;
        this.productCost = new BigDecimal(0);
        this.discount = new BigDecimal(0);
    }

    public Purchase(int productCount, BigDecimal productCost, BigDecimal discount) {
        setProductCount(productCount);
        setProductCost(productCost);
        setDiscount(discount);
    }

    public int getProductCount() {
        return productCount;
    }

    public BigDecimal getProductCost() {
        return productCost;
    }

    public BigDecimal getDiscount() {
        return discount;
    }

    public void setProductCount(int productCount) {
        if (productCount < 0)
            throw new IllegalArgumentException("productCount must be >= 0");
        this.productCount = productCount;
    }

    public void setProductCost(BigDecimal productCost) {
        if (productCost.compareTo(BigDecimal.valueOf(0)) < 0)
            throw new IllegalArgumentException("productCost must be >= 0");
        this.productCost = productCost;
    }

    public void setDiscount(BigDecimal discount) {
        if (discount.compareTo(BigDecimal.valueOf(0)) < 0 || discount.compareTo(BigDecimal.valueOf(100)) > 0)
            throw new IllegalArgumentException("discount must be in range [0;100]");
        this.discount = discount;
    }
}
