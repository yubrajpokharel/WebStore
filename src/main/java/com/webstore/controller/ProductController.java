package com.webstore.controller;

import com.webstore.domain.Product;
import com.webstore.exception.NoProductsFoundUnderCategoryException;
import com.webstore.exception.ProductNotFoundException;
import com.webstore.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.io.File;
import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

/**
 * Created by yubraj on 7/19/16.
 */

@Controller
@RequestMapping("/products")
public class ProductController {

    @Value("${product.image.upload.location}")
    String uploadDir;

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

        List<Product> productList = productService.getAllProductByCategory(category);

        if(productList == null || productList.isEmpty()){
            throw new NoProductsFoundUnderCategoryException();
        }

        model.addAttribute("products", productList);
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
    public String processAddNewProductForm(@ModelAttribute("newProduct") @Valid Product productToBeAdded,
                                           BindingResult result, HttpServletRequest request){

        if(result.hasErrors()){
            return "addProduct";
        }

        String[] suppressedFields = result.getSuppressedFields();
        if(suppressedFields.length >  0){
            throw new RuntimeException("Attempting to bind Disallowed fields : "+
                    StringUtils.arrayToCommaDelimitedString(suppressedFields));
        }

        MultipartFile productImage = productToBeAdded.getProductImage();
        String rootDirectory = request.getSession().getServletContext().getRealPath("/");
        System.out.println(rootDirectory);

        if (productImage!=null && !productImage.isEmpty()) {
            System.out.println("i am here");
            try {
                productImage.transferTo(new File(rootDirectory+uploadDir+productToBeAdded.getProductId() + ".jpg") );
            } catch (Exception e) {
                throw new RuntimeException("Product Image saving failed", e);
            }
        }

        productService.addProduct(productToBeAdded);
        return "redirect:/products";
    }

    @RequestMapping("/invalidPromoCode")
    public String invalidPromoCode(){
        return "invalidPromoCode";
    }

    @InitBinder
    public void initialiazeBinder(WebDataBinder binder){

        binder.setAllowedFields("productId","name","unitPrice","description",
                                "manufacturer","category","unitsInStock", "productImage", "condition");

        binder.setDisallowedFields("unitsInOrder","discontinued");
    }

    @ExceptionHandler(ProductNotFoundException.class)
    public ModelAndView handleError(HttpServletRequest
                                            req, ProductNotFoundException exception) {
        ModelAndView mav = new ModelAndView();
        mav.addObject("invalidProductId", exception.getProductID());
        mav.addObject("exception", exception);
        mav.addObject("url",req.getRequestURL()+"?"+req.getQueryString());
        mav.setViewName("productNotFound");
        return mav;
    }
}
