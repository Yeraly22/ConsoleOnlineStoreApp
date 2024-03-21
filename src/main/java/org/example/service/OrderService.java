package org.example.service;

import org.example.DatabaseManager;
import org.example.dao.OrderDAO;
import org.example.entity.Order;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class OrderService extends DatabaseManager implements OrderDAO {

    Connection connection = getConnection();

    @Override
    public void addOrder(Order order) {

    }

    @Override
    public Order getOrderById(int orderId) throws SQLException {
        PreparedStatement preparedStatement = null;
        Order order = null;
        String query = "SELECT * FROM orders WHERE order_id = ?";
        try {
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, orderId);
            ResultSet resultSet = preparedStatement.executeQuery();
                if (resultSet.next()) {
                    order = new Order();
                    order.setOrderId(resultSet.getInt("order_id"));
                    order.setCustomerId(resultSet.getInt("customer_id"));
                    order.setOrderDate(resultSet.getDate("order_date").toLocalDate());
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
        return order;
    }


    @Override
    public List<Order> getAllOrders() {
        return null;
    }
}
