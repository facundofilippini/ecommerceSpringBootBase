package com.facudev.ecommerceSpringBootBase.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class indexController {

    private Logger logg = LoggerFactory.getLogger(indexController.class);

    @GetMapping("")
    public String home() {
        return "index";
    }
}