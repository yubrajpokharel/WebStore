package com.webstore.domain;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * Created by yubraj on 7/22/16.
 */
public class Cart {
    private String cartId;
    private Map<String, CartItem> cartItems;
    private BigDecimal grandTotal;

    public Cart(){
        cartItems = new HashMap<String, CartItem>();
        grandTotal = new BigDecimal(0);
    }

    public Cart(String cartId){
        this();
        this.cartId = cartId;
    }

    public void addCartItem(CartItem cartItem){
        String productId = cartItem.getProduct().getProductId();
        if(cartItems.containsKey(productId)){
            CartItem preCartItem = cartItems.get(productId);
            preCartItem.setQuantity(preCartItem.getQuantity() + cartItem.getQuantity());
            cartItems.put(productId, preCartItem);
        }else
            cartItems.put(productId, cartItem);

        updateGrandTotal();
    }

    public void removeCartItem(CartItem item){
        String productId = item.getProduct().getProductId();
        System.out.println(productId);
        cartItems.remove(productId);
        updateGrandTotal();
    }

    public void updateGrandTotal() {
        grandTotal= new BigDecimal(0);
        for(CartItem item : cartItems.values()){
            grandTotal = grandTotal.add(item.getTotalPrice());
        }
    }


    public String getCartId() {
        return cartId;
    }

    public void setCartId(String cartId) {
        this.cartId = cartId;
    }

    public Map<String, CartItem> getcartItems() {
        return cartItems;
    }

    public void setcartItems(Map<String, CartItem> stringCartItemSet) {
        this.cartItems = stringCartItemSet;
    }

    public BigDecimal getGrandTotal() {
        return grandTotal;
    }

    public void setGrandTotal(BigDecimal grandTotal) {
        this.grandTotal = grandTotal;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Cart)) return false;

        Cart cart = (Cart) o;

        if (cartId != null ? !cartId.equals(cart.cartId) : cart.cartId != null) return false;
        if (cartItems != null ? !cartItems.equals(cart.cartItems) : cart.cartItems != null)
            return false;
        return grandTotal != null ? grandTotal.equals(cart.grandTotal) : cart.grandTotal == null;

    }

    @Override
    public int hashCode() {
        int result = cartId != null ? cartId.hashCode() : 0;
        result = 31 * result + (cartItems != null ? cartItems.hashCode() : 0);
        result = 31 * result + (grandTotal != null ? grandTotal.hashCode() : 0);
        return result;
    }
}
