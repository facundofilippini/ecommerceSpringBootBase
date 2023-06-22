package com.facudev.ecommerceSpringBootBase.controller;

import com.facudev.ecommerceSpringBootBase.model.Producto;
import com.facudev.ecommerceSpringBootBase.model.Usuario;
import com.facudev.ecommerceSpringBootBase.service.ProductoService;
import com.facudev.ecommerceSpringBootBase.service.UploadFileService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Optional;

@Controller
@RequestMapping("/productos")
public class ProductoController {

    private final Logger LOGGER = LoggerFactory.getLogger(ProductoController.class);

    @Autowired
    private ProductoService productoService;

    @Autowired
    private UploadFileService uploadFileService;

    @GetMapping("")
    public String read(Model model) {
        model.addAttribute("productos", productoService.findAll());
        return "pages/itemread";
    }

    @GetMapping("/create")
    public String create() {

        return "pages/itemcreate";
    }

    @PostMapping("/update")
    public String update(Producto producto, @RequestParam("img") MultipartFile file) throws IOException {
        Producto productoConImage = new Producto();
        productoConImage = productoService.get(producto.getId()).get();
        if (file.isEmpty()) {
            producto.setImagen(productoConImage.getImagen());
        } else {
            if (!productoConImage.getImagen().equals("default.png")) {
                uploadFileService.deleteImage(productoConImage.getImagen());
            }
            String imagename = uploadFileService.saveImage(file);
            producto.setImagen(imagename);
        }
        LOGGER.info("Producto: {}", producto);
        productoService.update(producto);
        return "redirect:/productos";
    }

    @GetMapping("/update/{id}")
    public String update(@PathVariable Integer id, Model model) {
        Producto producto = new Producto();
        Optional<Producto> optionalProducto = productoService.get(id);
        producto = optionalProducto.get();
        LOGGER.info("Producto: {}", producto);
        model.addAttribute("producto", producto);
        return "pages/itemupdate";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Integer id) {
        Producto producto = new Producto();
        producto = productoService.get(id).get();
        if (!producto.getImagen().equals("default.png")) {
            uploadFileService.deleteImage(producto.getImagen());
        }
        productoService.delete(id);
        return "redirect:/productos";
    }

    @PostMapping("/save")
    public String save(Producto producto, @RequestParam("img") MultipartFile file) {
        Usuario usuario = new Usuario(001, "Facundo", "facundofilippini", "filippinifacundo@gmail.com", "Mendoza", "2614601523", "ADMIN", "123456");
        producto.setUsuario(usuario);
        if (producto.getId() == null) {
            String imageName = uploadFileService.saveImage(file);
            producto.setImagen(imageName);
        }
        productoService.create(producto);
        return "redirect:/productos";
    }


}
