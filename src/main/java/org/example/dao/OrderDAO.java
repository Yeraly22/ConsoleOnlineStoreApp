package org.example.dao;

import org.example.entity.Order;

import java.sql.SQLException;
import java.util.List;

public interface OrderDAO {

    // Метод для добавления нового заказа в базу данных
    public void addOrder(Order order);

    // Метод для получения информации о заказе по его идентификатору
    public Order getOrderById(int orderId) throws SQLException;

    // Метод для получения списка всех заказов
    public List<Order> getAllOrders();
}
