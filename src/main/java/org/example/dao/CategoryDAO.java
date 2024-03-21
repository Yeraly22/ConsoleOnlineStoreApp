package org.example.dao;

import org.example.entity.Category;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public interface CategoryDAO {

    // Метод для добавления новой категории в базу данных
    public void addCategory(Category category);

    // Метод для получения информации о категории по ее идентификатору
    public Category getCategoryById(int categoryId) throws SQLException;

    // Метод для получения списка всех категорий
    public List<Category> getAllCategories();
}
