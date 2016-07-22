package com.webstore.validator;

import com.webstore.domain.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintViolation;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by yubraj on 7/22/16.
 */
public class ProductValidator implements Validator {

    @Autowired
    private javax.validation.Validator validator;
    private Set<Validator> springValidator;

    public ProductValidator(){
        springValidator = new HashSet<Validator>();
    }

    public void setSpringValidator(Set<Validator> springValidator){
        this.springValidator = springValidator;
    }

    public boolean supports(Class<?> clazz) {
        return Product.class.isAssignableFrom(clazz);
    }

    public void validate(Object target, Errors errors) {
        Set<ConstraintViolation<Object>> constraintViolations = validator.validate(target);

        for(ConstraintViolation<Object> objectConstraintViolation : constraintViolations){
            String propertyPath = objectConstraintViolation.getPropertyPath().toString();
            String message = objectConstraintViolation.getMessage();
            System.out.println("PropertyPath : " + propertyPath);
            System.out.println("Message : " + message);
            errors.rejectValue(propertyPath, "", message);
        }

        for(Validator validator : springValidator){
            validator.validate(target, errors);
        }

    }
}
