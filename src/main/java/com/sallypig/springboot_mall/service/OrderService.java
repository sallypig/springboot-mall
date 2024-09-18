package com.sallypig.springboot_mall.service;

import java.util.List;

import com.sallypig.springboot_mall.dto.CreateOrderRequest;
import com.sallypig.springboot_mall.dto.OrderQuaryParams;
import com.sallypig.springboot_mall.model.Order;

public interface OrderService {

    Integer countOrder(OrderQuaryParams orderQuaryParams);

    List<Order> getOrders(OrderQuaryParams orderQuaryParams);

    Integer createOrder(Integer userId, CreateOrderRequest createOrderRequest);

    Order getOrderById(Integer orderId);
}
