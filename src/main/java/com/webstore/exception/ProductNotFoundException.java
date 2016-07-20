package com.webstore.exception;

/**
 * Created by yubraj on 7/20/16.
 */
public class ProductNotFoundException extends RuntimeException {

    private static final long serialVersionUID = -23223232453535L;
    private String productID;

    public ProductNotFoundException(String productID) {
        this.productID = productID;
    }

    public String getProductID() {
        return productID;
    }
}
