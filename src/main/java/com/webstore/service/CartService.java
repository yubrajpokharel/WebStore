package com.webstore.service;

import com.webstore.domain.Cart;

/**
 * Created by yubraj on 7/22/16.
 */
public interface CartService {
    Cart create(Cart cart);
    Cart read(String cartId);
    void update(String cartId, Cart cart);
    void delete(String cartId);
}
