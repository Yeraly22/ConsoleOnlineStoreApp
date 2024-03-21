package org.example;

import org.example.entity.Order;
import org.example.entity.OrderItem;
import org.example.service.OrderItemService;
import org.example.service.OrderService;

import java.sql.SQLException;
import java.util.*;

public class Main {
    public static void main(String[] args) throws SQLException {

        Scanner scanner = new Scanner(System.in);

        // Ввод номеров заказов с консоли
        System.out.println("Введите номера заказов через запятую:");
        String input = scanner.nextLine();
        String[] orderIdsStr = input.split(",");
        int[] orderIds = new int[orderIdsStr.length];
        for (int i = 0; i < orderIdsStr.length; i++) {
            orderIds[i] = Integer.parseInt(orderIdsStr[i].trim());
        }

        // Создание экземпляра сервиса для работы с заказами
        OrderItemService orderItemService = new OrderItemService();
        List<OrderItem> ordersItem = null;

        for (int i =0; i < orderIds.length; i++) {
            ordersItem = orderItemService.getOrderItemsByOrderId(orderIds[i]);
        }
        // Получение списка заказов по указанным номерам
        // Вывод информации о заказах
        System.out.println("=+=+=+=");

        for (int orderId : orderIds) {
            System.out.println("Страница сборки заказа " + orderId);
            List<OrderItem> orderItems = orderItemService.getOrderItemsByOrderId(orderId);
            printOrderItems(orderItems);
        }
    }

    // Вспомогательный метод для вывода информации о продуктах заказа

    private static void printOrderItems(List<OrderItem> orderItems) {
        // Создаем мапу для хранения товаров по стеллажам с сохранением порядка
        Map<String, List<OrderItem>> itemsByShelf = new LinkedHashMap<>();

        // Группируем товары по стеллажам
        for (OrderItem orderItem : orderItems) {
            String shelf = determineShelf(orderItem.getRack());

            itemsByShelf.putIfAbsent(shelf, new ArrayList<>());
            itemsByShelf.get(shelf).add(orderItem);
        }

        // Выводим информацию о товарах по стеллажам
        for (Map.Entry<String, List<OrderItem>> entry : itemsByShelf.entrySet()) {
            String shelf = entry.getKey();
            List<OrderItem> items = entry.getValue();

            System.out.println("===Стеллаж " + shelf);

            for (OrderItem item : items) {
                System.out.println(" (id=" + item.getProductId() + ")");
                System.out.println("заказ " + item.getOrderId() + ", " + item.getQuantity() + " шт");
            }

            System.out.println(); // Пустая строка для разделения товаров на стеллаже
        }
    }




    private static String determineShelf(int productRack) {
        return switch (productRack) {
            case 1 -> "A";
            case 2 -> "B";
            case 3 -> "C";
            case 4 -> "D";
            default -> "Неизвестный стеллаж";
        };
    }

}
