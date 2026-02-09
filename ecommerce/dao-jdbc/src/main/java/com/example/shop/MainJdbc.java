package com.example.shop;

import com.example.shop.jdbc.ProductoJdbcDAO;
import com.example.shop.model.Producto;

public class MainJdbc {

    public static void main(String[] args) {
        ProductoJdbcDAO dao = new ProductoJdbcDAO();

        dao.create(new Producto(null, "Notebook", 1200));
        dao.create(new Producto(null, "Mouse", 20));

        dao.findAll().forEach(p ->
            System.out.println(p.getNombre() + " - $" + p.getPrecio())
        );
    }
}
