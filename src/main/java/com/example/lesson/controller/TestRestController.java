package com.example.lesson.controller;

import com.example.lesson.entity.ProductRecord;
import com.example.lesson.exception.NoSuchException;
import com.example.lesson.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class TestRestController {

    @Autowired
    ProductService productService;

    @GetMapping("/api/products")
    public ResponseEntity<List<ProductRecord>> allGet(){
        List<ProductRecord> list = productService.findAll();
        return new ResponseEntity<>(list,HttpStatus.OK);
    }

}
