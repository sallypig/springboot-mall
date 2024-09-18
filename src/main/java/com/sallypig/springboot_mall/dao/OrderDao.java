package com.sallypig.springboot_mall.dao;

import java.util.List;

import com.sallypig.springboot_mall.dto.OrderQuaryParams;
import com.sallypig.springboot_mall.model.Order;
import com.sallypig.springboot_mall.model.OrderItem;

public interface OrderDao {

    Integer countOrder(OrderQuaryParams orderQuaryParams);

    List<Order> getOrders(OrderQuaryParams orderQuaryParams);

    Integer createOrder(Integer userId, Integer totalAmount);

    void createOrderItems(Integer orderId, List<OrderItem> orderItemList);

    Order getOrderById(Integer orderId);

    List<OrderItem> getOrderItemsByOrderId(Integer orderId);
}
