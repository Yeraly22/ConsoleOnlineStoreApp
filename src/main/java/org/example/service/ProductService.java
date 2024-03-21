package org.example.service;

import org.example.DatabaseManager;
import org.example.dao.ProductDAO;
import org.example.entity.Product;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class ProductService extends DatabaseManager implements ProductDAO {

    Connection connection = getConnection();


    @Override
    public void addProduct(Product product) {

    }

    @Override
    public Product getProductById(int productId) throws SQLException {
        PreparedStatement preparedStatement = null;
        Product product = null;
        String query = "SELECT * FROM products WHERE product_id = ?";
        try {
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, productId);
            ResultSet resultSet = preparedStatement.executeQuery();
                if (resultSet.next()) {
                    product = new Product();
                    product.setProductId(resultSet.getInt("product_id"));
                    product.setName(resultSet.getString("name"));
                    product.setPrice(resultSet.getDouble("price"));
                    product.setCategory(resultSet.getInt("category_id"));
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
        return product;
    }
    @Override
    public List<Product> getAllProducts() {
        return null;
    }
}
