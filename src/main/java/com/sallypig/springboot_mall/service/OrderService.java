package com.sallypig.springboot_mall.service;

import com.sallypig.springboot_mall.dto.CreateOrderRequest;
import com.sallypig.springboot_mall.model.Order;

public interface OrderService {

    Integer createOrder(Integer userId, CreateOrderRequest createOrderRequest);

    Order getOrderById(Integer orderId);
}
