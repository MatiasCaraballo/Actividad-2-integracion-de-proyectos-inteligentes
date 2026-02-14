package com.example.ecommerce.jdbc;

import com.example.ecommerce.dao.ProductoDAO;
import com.example.ecommerce.model.Producto;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProductoJdbcDAO implements ProductoDAO {

    public ProductoJdbcDAO() {
        try (Connection c = ConnectionFactory.getConnection();
             Statement st = c.createStatement()) {

            st.execute("""
                CREATE TABLE IF NOT EXISTS producto (
                    id BIGINT AUTO_INCREMENT PRIMARY KEY,
                    nombre VARCHAR(100),
                    precio DOUBLE
                )
            """);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void create(Producto p) {
        try (Connection c = ConnectionFactory.getConnection();
             PreparedStatement ps =
                 c.prepareStatement("INSERT INTO producto(nombre, precio) VALUES (?, ?)")) {

            ps.setString(1, p.getNombre());
            ps.setDouble(2, p.getPrecio());
            ps.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public Producto findById(Long id) {
        try (Connection c = ConnectionFactory.getConnection();
             PreparedStatement ps =
                 c.prepareStatement("SELECT * FROM producto WHERE id = ?")) {

            ps.setLong(1, id);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                return new Producto(
                    rs.getLong("id"),
                    rs.getString("nombre"),
                    rs.getDouble("precio")
                );
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public List<Producto> findAll() {
        List<Producto> lista = new ArrayList<>();

        try (Connection c = ConnectionFactory.getConnection();
             Statement st = c.createStatement();
             ResultSet rs = st.executeQuery("SELECT * FROM producto")) {

            while (rs.next()) {
                lista.add(new Producto(
                    rs.getLong("id"),
                    rs.getString("nombre"),
                    rs.getDouble("precio")
                ));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return lista;
    }

    public void update(Producto p) {
        try (Connection c = ConnectionFactory.getConnection();
             PreparedStatement ps =
                 c.prepareStatement("UPDATE producto SET nombre=?, precio=? WHERE id=?")) {

            ps.setString(1, p.getNombre());
            ps.setDouble(2, p.getPrecio());
            ps.setLong(3, p.getId());
            ps.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void delete(Long id) {
        try (Connection c = ConnectionFactory.getConnection();
             PreparedStatement ps =
                 c.prepareStatement("DELETE FROM producto WHERE id=?")) {

            ps.setLong(1, id);
            ps.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
