package com.devd.spring.bookstorepaymentservice.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author Devaraj Reddy, Date : 25-Jul-2020
 */
public class PaymentsController {

    @GetMapping("/test/payments")
    public ResponseEntity<String> testUserRoleController() {
        return ResponseEntity.ok("Hey, I am PaymentsController");
    }
}
