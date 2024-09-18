package com.sallypig.springboot_mall.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import com.sallypig.springboot_mall.dao.OrderDao;
import com.sallypig.springboot_mall.dao.ProductDao;
import com.sallypig.springboot_mall.dao.UserDao;
import com.sallypig.springboot_mall.dto.BuyItem;
import com.sallypig.springboot_mall.dto.CreateOrderRequest;
import com.sallypig.springboot_mall.dto.OrderQuaryParams;
import com.sallypig.springboot_mall.model.Order;
import com.sallypig.springboot_mall.model.OrderItem;
import com.sallypig.springboot_mall.model.Product;
import com.sallypig.springboot_mall.model.User;
import com.sallypig.springboot_mall.service.OrderService;

@Component
public class OrderServiceImpl implements OrderService {

    private final static org.slf4j.Logger log = LoggerFactory.getLogger(UserServiceImpl.class);

    @Autowired
    private OrderDao orderDao;

    @Autowired
    private ProductDao productDao;

    @Autowired
    private UserDao userDao;

    @Transactional //若中間有Exception 一切復原 All or naver
    @Override
    public Integer createOrder(Integer userId, CreateOrderRequest createOrderRequest) {
        // 檢查 user是否存在
        User user = userDao.getUserById(userId);

        if (user == null) {
            log.warn("該 userId {} 不存在", userId);
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        }

        int totalAmount = 0;
        List<OrderItem> orderItemList = new ArrayList<>();

        for (BuyItem buyItem : createOrderRequest.getBuyItemList()) {
            Product product = productDao.getProductById(buyItem.getProductId());

            // 檢查 product 是否存在、庫存是否足夠
            if (product == null) {
                log.warn("商品 {} 不存在", buyItem.getProductId());
                throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
            } else if (product.getStock() < buyItem.getQuantity()) {
                log.warn("商品 {} 庫存數量不足，無法購買。剩餘庫存 {}，欲購買數量 {}", buyItem.getProductId(), product.getStock(), buyItem.getQuantity());
                throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
            }

            // 扣除商品庫存
            productDao.updateStock(product.getProductId(), product.getStock() - buyItem.getQuantity());

            // 計算總價錢
            Integer amount = product.getPrice() * buyItem.getQuantity();
            totalAmount = totalAmount + amount;

            OrderItem orderItem = new OrderItem();
            orderItem.setAmount(amount);
            orderItem.setProductId(buyItem.getProductId());
            orderItem.setQuantity(buyItem.getQuantity());

            orderItemList.add(orderItem);
        }

        // 創建訂單
        Integer orderId = orderDao.createOrder(userId, totalAmount);

        orderDao.createOrderItems(orderId, orderItemList);

        return orderId;
    }

    @Override
    public Order getOrderById(Integer orderId) {
        Order order = orderDao.getOrderById(orderId);

        List<OrderItem> orderItemList = orderDao.getOrderItemsByOrderId(orderId);
        order.setOrderItemList(orderItemList);

        return order;
    }

    @Override
    public Integer countOrder(OrderQuaryParams orderQuaryParams) {
        return orderDao.countOrder(orderQuaryParams);
    }

    @Override
    public List<Order> getOrders(OrderQuaryParams orderQuaryParams) {
        List<Order> orderList = orderDao.getOrders(orderQuaryParams);

        for (Order order : orderList) {
            List<OrderItem> orderItemList = orderDao.getOrderItemsByOrderId(order.getOrderId());
            order.setOrderItemList(orderItemList);
        }

        return orderList;
    }
}
