package com.devd.spring.bookstoreorderservice.controller;

import com.devd.spring.bookstoreorderservice.web.CreateOrderResponse;
import com.devd.spring.bookstoreorderservice.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: Devaraj Reddy,
 * Date : 2019-07-14
 */
@RestController
public class OrderController {
    
    @Autowired
    OrderService orderService;

    @GetMapping("/test/order")
    public ResponseEntity<String> testUserRoleController() {
        return ResponseEntity.ok("Hey, I am OrderController");
    }
    
    @PostMapping("/order")
    public ResponseEntity<CreateOrderResponse> createOrder() {
    
        String orderId = orderService.createOrder();
    
        CreateOrderResponse createOrderResponse =
                CreateOrderResponse.builder()
                                   .orderId(orderId)
                                   .build();
        return ResponseEntity.ok(createOrderResponse);
    }
}
