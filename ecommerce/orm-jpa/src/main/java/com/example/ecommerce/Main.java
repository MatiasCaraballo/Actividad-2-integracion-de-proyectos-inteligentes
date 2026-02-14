package com.example.ecommerce;

import com.example.ecommerce.config.JPAUtil;
import com.example.ecommerce.dao.ProductDAO;
import com.example.ecommerce.dao.ProductDAOImpl;
import com.example.ecommerce.model.Product;

public class Main {

    public static void main(String[] args) {

        ProductDAO dao = new ProductDAOImpl();

        dao.save(new Product("Notebook", 1500.0));
        dao.save(new Product("Mouse", 50.0));

        System.out.println("Listado de productos:");

        dao.findAll().forEach(p ->
                System.out.println(
                        p.getId() + " - " +
                        p.getName() + " - " +
                        p.getPrice()
                )
        );

        // Cerrar correctamente el EntityManagerFactory
        JPAUtil.close();
    }
}

