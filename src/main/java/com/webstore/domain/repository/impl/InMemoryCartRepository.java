package com.webstore.domain.repository.impl;

import com.webstore.domain.Cart;
import com.webstore.domain.repository.CartRepository;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by yubraj on 7/22/16.
 */

@Repository
public class InMemoryCartRepository implements CartRepository {

    private Map<String, Cart> listOfCart;

    public InMemoryCartRepository(){
        listOfCart = new HashMap<String, Cart>();
    }

    public Cart create(Cart cart) {
        if(listOfCart.keySet().contains(cart.getCartId())){
            throw new IllegalArgumentException("Unable to create the Cart. Cart Already exists with the Given ID : " + cart.getCartId());
        }
        listOfCart.put(cart.getCartId(), cart);
        return cart;
    }

    public Cart read(String cartId) {
        return listOfCart.get(cartId);
    }

    public void update(String cartId, Cart cart) {
        if(!listOfCart.keySet().contains(cartId)) {
            throw new IllegalArgumentException(String.format("Can not update Cart. The cart with the give id (%) does not does not exist",cartId));
        }
        listOfCart.put(cartId, cart);
    }

    public void delete(String cartId) {
        if(!listOfCart.keySet().contains(cartId)) {
            throw new IllegalArgumentException(String.format("Can not delete cart. The cart with the give id (%) does not does not exist",cartId));
        }
        listOfCart.remove(cartId);
    }

}
