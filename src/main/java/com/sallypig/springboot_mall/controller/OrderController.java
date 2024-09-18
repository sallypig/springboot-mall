package com.sallypig.springboot_mall.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sallypig.springboot_mall.dto.CreateOrderRequest;
import com.sallypig.springboot_mall.dto.OrderQuaryParams;
import com.sallypig.springboot_mall.model.Order;
import com.sallypig.springboot_mall.service.OrderService;
import com.sallypig.springboot_mall.util.Page;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;

@RestController
public class OrderController {

    @Autowired
    private OrderService orderService;

    @GetMapping("/users/{userId}/orders")
    public ResponseEntity<Page<Order>> getProducts(
            @PathVariable Integer userId,
            // 分頁 Pagination
            @RequestParam(defaultValue = "10") @Max(1000) @Min(0) Integer limit,
            @RequestParam(defaultValue = "0") @Min(0) Integer offset
    ) {
        OrderQuaryParams orderQuaryParams = new OrderQuaryParams();
        orderQuaryParams.setUserId(userId);
        orderQuaryParams.setLimit(limit);
        orderQuaryParams.setOffset(offset);

        // 取得 order list
        List<Order> orderList = orderService.getOrders(orderQuaryParams);

        // 取得 order 總數
        Integer total = orderService.countOrder(orderQuaryParams);

        // 分頁
        Page<Order> page = new Page<>();
        page.setLimit(limit);
        page.setOffset(offset);
        page.setTotal(total);
        page.setResults(orderList);

        return ResponseEntity.status(HttpStatusCode.valueOf(200)).body(page);
    }

    @PostMapping("/users/{userId}/order")
    public ResponseEntity<?> createOrder(@PathVariable Integer userId, @RequestBody @Valid CreateOrderRequest createOrderRequest) {

        Integer orderId = orderService.createOrder(userId, createOrderRequest);

        Order order = orderService.getOrderById(orderId);

        return ResponseEntity.status(HttpStatus.CREATED).body(order);
    }

}
