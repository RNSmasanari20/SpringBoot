package com.example.lesson.controller;

import com.example.lesson.entity.ProductRecord;
import com.example.lesson.exception.NoSuchException;
import com.example.lesson.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/api/product/{id}")
    public ResponseEntity<ProductRecord> recGet(@PathVariable("id") int id){
        ProductRecord pr = productService.findById(id);
        return new ResponseEntity<>(pr,HttpStatus.OK);
    }

    @PostMapping(value = "/api/product")
    public ResponseEntity<ProductRecord> madeRec(@RequestBody ProductRecord productRecord){
        ProductRecord addRecord = new ProductRecord(-1, productRecord.name(), productRecord.price());
        productService.insert(addRecord);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping("/api/product/{id}")
    public ResponseEntity<ProductRecord> upRec(@RequestBody ProductRecord productRecord){
        productService.update(productRecord);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/api/product/{id}")
    public ResponseEntity<ProductRecord> delRec(@PathVariable("id") int id,@RequestBody ProductRecord productRecord){
        productService.delete(productRecord.id());
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
