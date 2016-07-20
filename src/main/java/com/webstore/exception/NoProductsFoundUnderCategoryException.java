package com.webstore.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Created by yubraj on 7/20/16.
 */

@ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "No Products Found under this category!")
public class NoProductsFoundUnderCategoryException extends RuntimeException {
    private static final long serialVersionUID =3935230281455340039L;
}
