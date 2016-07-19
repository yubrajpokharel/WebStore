package com.webstore.service;

import com.webstore.domain.Product;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Created by yubraj on 7/19/16.
 */
public interface ProductService {
    List<Product> getAllProducts();
    Product getProductById(String productId);
    List<Product> getAllProductByCategory(String category);
    Set<Product> getProductsByFilter(Map<String, List<String>> filterParams);
    List<Product> getProductsByManufacturer(String manufacturer);
    Set<Product> filterProducts(BigDecimal lowPrice, BigDecimal highPrice,String manufacturer, String category);
    void addProduct(Product product);
}
