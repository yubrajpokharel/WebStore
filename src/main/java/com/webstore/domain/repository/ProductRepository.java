package com.webstore.domain.repository;

import com.webstore.domain.Product;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Created by yubraj on 7/19/16.
 */
public interface ProductRepository {
    List<Product> getAllProducts();
    Product getProductById(String productID);
    List<Product> getAllProductByCategory(String category);
    List<Product> getProductsByManufactures(String manufacture);
    Set<Product> getProductsByFilter(Map<String, List<String>> filterParams);
    List<Product> getProductsByPriceFilter(BigDecimal low, BigDecimal high);
    Set<Product> filterProducts(BigDecimal lowPrice, BigDecimal highPrice, String manufacturer, String category);
    void addProduct(Product product);
}
