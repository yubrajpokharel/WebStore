package com.webstore.validator;

import com.webstore.domain.Product;
import com.webstore.exception.ProductNotFoundException;
import com.webstore.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * Created by yubraj on 7/22/16.
 */

public class ProductIdValidator implements ConstraintValidator<ProductId, String> {

    @Autowired
    ProductService productService;

   public void initialize(ProductId constraint) {
   }

   public boolean isValid(String value, ConstraintValidatorContext context) {
       Product product;
        try {
            product = productService.getProductById(value);
        }catch (ProductNotFoundException e){
            return true;
        }

       if(product != null)
           return false;

       return true;
   }

}
