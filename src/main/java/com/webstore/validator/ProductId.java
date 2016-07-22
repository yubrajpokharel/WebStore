package com.webstore.validator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

/**
 * Created by yubraj on 7/22/16.
 */

@Target({ElementType.METHOD, ElementType.FIELD, ElementType.ANNOTATION_TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = ProductIdValidator.class)
@Documented
public @interface ProductId {
    String message() default"{com.webstore.validator.ProductId.message}";
    Class<?>[] groups() default {};
    public abstract Class<? extends Payload>[] payload() default{};
}
