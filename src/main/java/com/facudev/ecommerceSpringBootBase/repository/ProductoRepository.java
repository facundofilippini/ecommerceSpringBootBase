package com.facudev.ecommerceSpringBootBase.repository;

import com.facudev.ecommerceSpringBootBase.model.Producto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductoRepository extends JpaRepository<Producto, Integer> {


}
