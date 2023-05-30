package com.facudev.ecommerceSpringBootBase.service;

import com.facudev.ecommerceSpringBootBase.model.Producto;
import com.facudev.ecommerceSpringBootBase.repository.ProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductoImplement implements ProductoService {

    @Autowired
    private ProductoRepository productoRepository;

    @Override
    public Producto create(Producto producto) {
        return productoRepository.save(producto);
    }

    @Override
    public Optional<Producto> get(Integer id) {
        return Optional.empty();
    }

    @Override
    public void update(Producto producto) {

    }

    @Override
    public void delete(Integer id) {

    }

    @Override
    public List<Producto> findAll() {
        return null;
    }
}
