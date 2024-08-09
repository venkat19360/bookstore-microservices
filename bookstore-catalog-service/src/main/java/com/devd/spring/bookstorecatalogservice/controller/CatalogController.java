package com.devd.spring.bookstorecatalogservice.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: Devaraj Reddy,
 * Date : 2019-06-03
 */
@RestController
public class CatalogController {

    @GetMapping("/test/catalog")
    public ResponseEntity<String> testUserRoleController() {
        return ResponseEntity.ok("Hey, I am CatalogController");
    }

}
