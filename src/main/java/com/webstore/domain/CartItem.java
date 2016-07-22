package com.webstore.domain;

import java.math.BigDecimal;

/**
 * Created by yubraj on 7/22/16.
 */
public class CartItem {
    private Product product;
    private int quantity;
    private BigDecimal totalPrice;

    public CartItem(){}

    public CartItem(Product product){
        super();
        this.product = product;
        this.quantity = 1;
        this.totalPrice = product.getUnitPrice();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null) return false;
        if (getClass() != obj.getClass()) return false;

        CartItem other = (CartItem) obj;

        if (product == null) {
            if (other.product != null)
                return false;
        } else if (!product.equals(other.product))
            return false;
        return true;
    }

    @Override
    public int hashCode() {
        int result = product.hashCode();
        result = 31 * result + quantity;
        result = 31 * result + totalPrice.hashCode();
        return result;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
        this.updateTotalPrice();
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
        this.updateTotalPrice();
    }

    public BigDecimal getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(BigDecimal totalPrice) {
        this.totalPrice = totalPrice;
    }

    public void updateTotalPrice() {
        totalPrice = this.product.getUnitPrice().multiply(new BigDecimal(this.quantity));
    }
}
