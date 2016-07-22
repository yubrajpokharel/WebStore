package com.webstore.service.impl;

import com.webstore.domain.Cart;
import com.webstore.domain.repository.CartRepository;
import com.webstore.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by yubraj on 7/22/16.
 */

@Service
public class CartServiceImpl implements CartService {

    @Autowired
    private CartRepository cartRepository;

    public Cart create(Cart cart) {
        return cartRepository.create(cart);
    }

    public Cart read(String cartId) {
        return cartRepository.read(cartId);
    }

    public void update(String cartId, Cart cart) {
        cartRepository.update(cartId, cart);
    }

    public void delete(String cartId) {
        cartRepository.delete(cartId);
    }
}
