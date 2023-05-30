package com.facudev.ecommerceSpringBootBase.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class IndexController {

    private Logger logg = LoggerFactory.getLogger(IndexController.class);

    @GetMapping("")
    public String home() {
        return "index";
    }

    @GetMapping("producto")
    public String itemdetail() {
        return "pages/itemdetail";
    }

    @GetMapping("/carrito")
    public String getCart() {
        return "pages/cart";
    }

    @GetMapping("/orden")
    public String orderdetail() {
        return "pages/orderdetail";
    }

    @GetMapping("/guardarorden")
    public String saveOrder() {
        return "redirect:/";
    }
}