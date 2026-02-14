package com.example.ecommerce.dao;

import com.example.ecommerce.config.JPAUtil;
import com.example.ecommerce.model.Product;

import jakarta.persistence.EntityManager;

import java.util.List;

public class ProductDAOImpl implements ProductDAO {
       @Override
    public void save(Product product) {
        EntityManager em = JPAUtil.getEntityManager();
        em.getTransaction().begin();
        em.persist(product);
        em.getTransaction().commit();
        em.close();
    }

    @Override
    public Product findById(Long id) {
        EntityManager em = JPAUtil.getEntityManager();
        Product product = em.find(Product.class, id);
        em.close();
        return product;
    }

    @Override
    public List<Product> findAll() {
        EntityManager em = JPAUtil.getEntityManager();
        List<Product> products =
                em.createQuery("FROM Product", Product.class)
                  .getResultList();
        em.close();
        return products;
    }
}
