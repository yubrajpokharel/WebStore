package com.webstore.controller;

import com.webstore.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by yubraj on 7/19/16.
 */

@Controller
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @RequestMapping("/customers")
    public String getAllCustomers(Model model){
        model.addAttribute("customers", customerService.getAllCustomers());
        return "customers";
    }

}
