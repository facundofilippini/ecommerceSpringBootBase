package com.facudev.ecommerceSpringBootBase.controller;

import com.facudev.ecommerceSpringBootBase.model.Producto;
import com.facudev.ecommerceSpringBootBase.model.Usuario;
import com.facudev.ecommerceSpringBootBase.service.ProductoService;
import org.slf4j.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.logging.Logger;

import static org.hibernate.sql.ast.SqlTreeCreationLogger.LOGGER;

@Controller
@RequestMapping("/productos")
public class ProductoController {


    @Autowired
    private ProductoService productoService;


    @GetMapping("")
    public String read() {
        return "pages/itemread";
    }

    @GetMapping("/create")
    public String create() {

        return "pages/itemcreate";
    }

    @GetMapping("/update")
    public String update() {
        return "pages/itemupdate";
    }

    @GetMapping("/delete")
    public String delete() {
        return "redirect:/";
    }

    @PostMapping("/save")
    public String save(Producto producto) {
        
        Usuario usuario = new Usuario(001, "Facundo", "facundofilippini", "filippinifacundo@gmail.com", "Mendoza", "2614601523", "ADMIN", "123456");
        producto.setUsuario(usuario);
        productoService.create(producto);
        return "redirect:/productos";
    }


}
