package org.example.dao;

import org.example.entity.Product;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public interface ProductDAO {
    // Метод для добавления нового продукта в базу данных
    public void addProduct(Product product);

    // Метод для получения информации о продукте по его идентификатору
    public Product getProductById(int productId) throws SQLException;

    // Метод для получения списка всех продуктов
    public List<Product> getAllProducts();
}
