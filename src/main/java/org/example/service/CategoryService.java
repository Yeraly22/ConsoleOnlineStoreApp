package org.example.service;

import org.example.DatabaseManager;
import org.example.dao.CategoryDAO;
import org.example.entity.Category;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class CategoryService extends DatabaseManager implements CategoryDAO {
    Connection connection = getConnection();
    public void addCategory(Category category) {

    }

    @Override
    public Category getCategoryById(int categoryId) throws SQLException {
        PreparedStatement preparedStatement = null;
        Category category = null;
        String query = "SELECT * FROM categories WHERE category_id = ?";
        try {
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, categoryId);
            ResultSet resultSet = preparedStatement.executeQuery();
                if (resultSet.next()) {
                    category = new Category();
                    category.setCategoryId(resultSet.getInt("category_id"));
                    category.setName(resultSet.getString("name"));


                }
                preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            if(preparedStatement != null){
                preparedStatement.close();
            }
            if(connection != null){
                connection.close();
            }
        }
        return category;
    }

    @Override
    public List<Category> getAllCategories() {
        return null;
    }
}
