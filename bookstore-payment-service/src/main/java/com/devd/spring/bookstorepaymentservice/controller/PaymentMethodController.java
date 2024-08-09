package com.devd.spring.bookstorepaymentservice.controller;

import com.devd.spring.bookstorepaymentservice.service.PaymentMethodService;
import com.devd.spring.bookstorepaymentservice.web.CreatePaymentMethodRequest;
import com.devd.spring.bookstorepaymentservice.web.PaymentMethodType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

/**
 * @author Devaraj Reddy, Date : 25-Jul-2020
 */
@RestController
public class PaymentMethodController {

    @Autowired
    private PaymentMethodService paymentMethodService;

    @GetMapping("/test/payment-method")
    public ResponseEntity<String> testUserRoleController() {
        return ResponseEntity.ok("Hey, I am PaymentMethodController");
    }

    @PostMapping("/paymentMethod")
    public ResponseEntity<?> createPaymentMethod(@RequestBody @Valid CreatePaymentMethodRequest createPaymentMethodRequest){

        paymentMethodService.createPaymentMethod(createPaymentMethodRequest);

        return null;
    }



}
