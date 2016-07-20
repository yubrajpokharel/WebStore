package com.webstore.domain.repository.impl;

import com.webstore.domain.Product;
import com.webstore.domain.repository.ProductRepository;
import com.webstore.exception.ProductNotFoundException;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.*;

/**
 * Created by yubraj on 7/19/16.
 */

@Repository
public class InMemoryProductRepository implements ProductRepository {

    List<Product> listOfProducts = new ArrayList<Product>();

    public List<Product> getAllProducts() {
        return listOfProducts;
    }

    public Product getProductById(String productID) {
        Product productById = null;

        for(Product product: listOfProducts){
            if(product != null && product.getProductId() != null && product.getProductId().equals(productID)){
                productById = product;
                break;
            }
        }

        if(productById == null)
            throw new ProductNotFoundException(productID);

        return productById;
    }

    public List<Product> getAllProductByCategory(String category) {
        List<Product> productList = new ArrayList<Product>();

        for(Product product: listOfProducts){
            if(product.getCategory().equalsIgnoreCase(category)){
                productList.add(product);
            }
        }

        return productList;
    }

    public List<Product> getProductsByManufactures(String manufacture) {
        List<Product> productList = new ArrayList<Product>();

        for(Product product: listOfProducts){
            if(product.getManufacturer().equalsIgnoreCase(manufacture)){
                productList.add(product);
            }
        }

        return productList;
    }

    public List<Product> getProductsByPriceFilter(BigDecimal low, BigDecimal high) {
        List<Product> productsByPriceFilter = new ArrayList<Product>();

        for (Product product : listOfProducts) {
            if (low.compareTo(product.getUnitPrice()) <= 0 && high.compareTo(product.getUnitPrice()) >= 0)
                productsByPriceFilter.add(product);
        }
        return productsByPriceFilter;
    }

    public Set<Product> filterProducts(BigDecimal lowPrice, BigDecimal highPrice, String manufacturer, String category) {
        Set<Product> byPrice = new HashSet<Product>(getProductsByPriceFilter(lowPrice, highPrice));
        Set<Product> byManufacturer = new HashSet<Product>(getProductsByManufactures(manufacturer));
        Set<Product> byCategory = new HashSet<Product>(getAllProductByCategory(category));

        byPrice.retainAll(byManufacturer);
        byPrice.retainAll(byCategory);

        return byPrice;
    }

    public void addProduct(Product product) {
        listOfProducts.add(product);
    }

    public Set<Product> getProductsByFilter(Map<String, List<String>> filterParams) {
        Set<Product> productsByBrand = new HashSet<Product>();
        Set<Product> productsByCategory = new HashSet<Product>();
        Set<String> criterias = filterParams.keySet();

        if(criterias.contains("brand")) {
            for(String brandName: filterParams.get("brand")) {
                for(Product product: listOfProducts) {
                    if(brandName.equalsIgnoreCase(product.getManufacturer())){
                        productsByBrand.add(product);
                    }
                }
            }
        }
        if(criterias.contains("category")) {
            for(String category: filterParams.get("category")) {
                productsByCategory.addAll(this.getAllProductByCategory(category));
            }
        } productsByCategory.retainAll(productsByBrand);
        return productsByCategory;
    }

    public InMemoryProductRepository() {
        Product iphone = new Product("P1234","iPhone 5s", new BigDecimal(500));
        iphone.setDescription("Apple iPhone 5s smartphone with 4.00-inch 640x1136 display and 8-megapixel rear camera");
        iphone.setCategory("Smart Phone");
        iphone.setManufacturer("Apple");
        iphone.setUnitsInStock(1000);

        Product laptop_dell = new Product("P1235","Dell Inspiron", new BigDecimal(700));
        laptop_dell.setDescription("Dell Inspiron 14-inch Laptop (Black) with 3rd Generation Intel Core processors");
        laptop_dell.setCategory("Laptop");
        laptop_dell.setManufacturer("Dell");
        laptop_dell.setUnitsInStock(1000);

        Product tablet_Nexus = new Product("P1236","Nexus 7", new BigDecimal(300));
        tablet_Nexus.setDescription("Google Nexus 7 is the lightest 7 inch tablet With a quad-core Qualcomm Snapdragon™ S4 Pro processor");
        tablet_Nexus.setCategory("Tablet");
        tablet_Nexus.setManufacturer("Google");
        tablet_Nexus.setUnitsInStock(1000);

        listOfProducts.add(iphone);
        listOfProducts.add(laptop_dell);
        listOfProducts.add(tablet_Nexus);
    }
}
