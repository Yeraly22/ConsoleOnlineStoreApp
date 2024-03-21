package org.example.dao;

import org.example.entity.OrderItem;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public interface OrderItemDAO {

    // Метод для добавления нового элемента заказа в базу данных
    public void addOrderItem(OrderItem orderItem);

    // Метод для получения списка элементов заказа по номеру заказа
    public List<OrderItem> getOrderItemsByOrderId(int orderId) throws SQLException;
}
