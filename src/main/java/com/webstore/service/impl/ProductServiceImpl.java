package com.webstore.service.impl;

import com.webstore.domain.Product;
import com.webstore.domain.repository.ProductRepository;
import com.webstore.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Created by yubraj on 7/19/16.
 */

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository productRepository;

    public List<Product> getAllProducts() {
        return productRepository.getAllProducts();
    }

    public Product getProductById(String productId) {
        return productRepository.getProductById(productId);
    }

    public List<Product> getAllProductByCategory(String category) {
        return productRepository.getAllProductByCategory(category);
    }

    public Set<Product> getProductsByFilter(Map<String, List<String>> filterParams) {
        return productRepository.getProductsByFilter(filterParams);
    }

    public List<Product> getProductsByManufacturer(String manufacturer) {
        return productRepository.getProductsByManufactures(manufacturer);
    }

    public Set<Product> filterProducts(BigDecimal lowPrice, BigDecimal highPrice, String manufacturer, String category) {
        return productRepository.filterProducts(lowPrice, highPrice, manufacturer, category);
    }

    public void addProduct(Product product) {
        productRepository.addProduct(product);
    }
}
