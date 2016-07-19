package com.webstore.service.impl;

import com.webstore.domain.Product;
import com.webstore.domain.repository.ProductRepository;
import com.webstore.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by yubraj on 7/19/16.
 */

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    ProductRepository productRepository;

    public void processOrder(String productId, int count) {
        Product product = productRepository.getProductById(productId);

        if(product.getUnitsInStock() < count){
            throw new IllegalArgumentException("Out of stock! Available units in stock : "+ product.getUnitsInStock());
        }

        product.setUnitsInStock(product.getUnitsInStock() - count);
    }

}
