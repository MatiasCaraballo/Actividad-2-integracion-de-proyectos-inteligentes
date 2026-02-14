package com.example.ecommerce.dao;

import com.example.ecommerce.model.Producto;
import java.util.List;

public interface ProductoDAO {

    void create(Producto producto);
    Producto findById(Long id);
    List<Producto> findAll();
    void update(Producto producto);
    void delete(Long id);
}
