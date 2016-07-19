package com.webstore.controller;

import com.webstore.domain.Product;
import com.webstore.service.ProductService;
import org.dom4j.rule.Mode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

/**
 * Created by yubraj on 7/19/16.
 */

@Controller
@RequestMapping("/products")
public class ProductController {

    @Autowired
    ProductService productService;

    @RequestMapping
    public String list(Model model){
        model.addAttribute("products", productService.getAllProducts());
        return "products";
    }

    @RequestMapping("/all")
    public String allProducts(Model model){
        model.addAttribute("products", productService.getAllProducts());
        return "products";
    }

    @RequestMapping("/{category}")
    public String getProductByCategory(Model model, @PathVariable("category") String category){
        model.addAttribute("products", productService.getAllProductByCategory(category));
        return "products";
    }

    @RequestMapping("manufacturer/{manufacturer}")
    public String getProductByManufacturer(Model model, @PathVariable("manufacturer") String manufacturer){
        model.addAttribute("products", productService.getProductsByManufacturer(manufacturer));
        return "products";
    }

    @RequestMapping("/filter/{ByCriteria}")
    public String getProductsByFilter(@MatrixVariable(pathVar=
            "ByCriteria") Map<String,List<String>> filterParams,Model model) {
        model.addAttribute("products", productService.getProductsByFilter(filterParams));
        return "products";
    }

    @RequestMapping("/product")
    public String getProductById(@RequestParam("id") String id, Model model){
        model.addAttribute(productService.getProductById(id));
        return "product";
    }

    @RequestMapping("/{category}/{price}")
    public String filterProducts(
            @MatrixVariable(pathVar = "price") Map<String, List<String>> priceRange,
            @RequestParam("manufacturer") String manufacturer,
            @PathVariable("category") String category, Model model) {

        BigDecimal lowPrice = new BigDecimal(priceRange.get("low").get(0));
        BigDecimal highPrice = new BigDecimal(priceRange.get("high").get(0));

        model.addAttribute("products", productService.filterProducts(lowPrice,
                highPrice, manufacturer, category));

        return "products";
    }

    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public String getAddNewProductForm(Model model){
        Product product = new Product();
        model.addAttribute("newProduct", product);
        return "addProduct";
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String processAddNewProductForm(@ModelAttribute("newProduct") Product product,
                                           BindingResult result){

        String[] suppressedFields = result.getSuppressedFields();
        if(suppressedFields.length >  0){
            throw new RuntimeException("Attempting to bind Disallowed fields : "+
                    StringUtils.arrayToCommaDelimitedString(suppressedFields));
        }
        productService.addProduct(product);
        return "redirect:/products";
    }

    @InitBinder
    public void initialiazeBinder(WebDataBinder binder){
        binder.setDisallowedFields("unitsInOrder","discontinued");
    }
}
