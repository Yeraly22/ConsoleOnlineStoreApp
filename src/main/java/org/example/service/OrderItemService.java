package org.example.service;

import org.example.DatabaseManager;
import org.example.dao.OrderItemDAO;
import org.example.entity.OrderItem;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class OrderItemService extends DatabaseManager implements OrderItemDAO {

    Connection connection = getConnection();

    @Override
    public void addOrderItem(OrderItem orderItem) {

    }

    @Override
    public List<OrderItem> getOrderItemsByOrderId(int orderId) throws SQLException {
        PreparedStatement statement = null;
        List<OrderItem> orderItems = new ArrayList<>();
        String query = "SELECT * FROM order_items WHERE order_id = ?";
        try{
            statement = connection.prepareStatement(query);
            statement.setInt(1, orderId);

                ResultSet resultSet = statement.executeQuery();

                while (resultSet.next()) {
                    OrderItem orderItem = new OrderItem();
                    orderItem.setOrderItemId(resultSet.getInt("order_item_id"));
                    orderItem.setOrderId(resultSet.getInt("order_id"));
                    orderItem.setProductId(resultSet.getInt("product_id"));
                    orderItem.setQuantity(resultSet.getInt("quantity"));
                    orderItem.setUnitPrice(resultSet.getDouble("unit_price"));
                    orderItem.setRack(resultSet.getInt("rack"));
                    orderItems.add(orderItem);
                }

        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            if(statement != null){
                statement.close();
            }
        }
            return orderItems;

    }
}
