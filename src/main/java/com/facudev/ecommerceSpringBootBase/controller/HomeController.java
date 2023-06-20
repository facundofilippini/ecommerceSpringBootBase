package com.facudev.ecommerceSpringBootBase.controller;

import com.facudev.ecommerceSpringBootBase.model.Producto;
import com.facudev.ecommerceSpringBootBase.service.ProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/")
public class HomeController {

    @Autowired
    private ProductoService productoService;


    @GetMapping("")
    public String home(Model model) {
        List<Producto> productos = productoService.findAll();
        model.addAttribute("productos", productos);
        return "home";
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