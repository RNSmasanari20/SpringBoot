package com.example.lesson.service;

import com.example.lesson.entity.ProductRecord;
import com.example.lesson.exception.ProductNotFoundException;
import com.example.lesson.repository.ProductDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;

@Service
public class PgProductService implements ProductService {

    @Autowired
    private ProductDao productDao;


    @Override
    public List<ProductRecord> findAll() {
        try {
            return productDao.findAll();
        } catch (SQLException e) {
            return null;
        }
    }


    @Override
    public ProductRecord findById(int id) {
        try {
            ProductRecord productRecord = productDao.findById(id);
            if (productRecord == null) {
                throw new ProductNotFoundException();
            }
            return productDao.findById(id);
        } catch (SQLException e) {
            return null;
        }
    }


    @Override
    public int insert(ProductRecord productRecord) {
        try {
            return productDao.insert(productRecord);
        } catch (SQLException e) {
            return 0;
        }
    }


    @Override
    public int update(ProductRecord productRecord) {
        try {
            return productDao.update(productRecord);
        } catch (SQLException e) {
            return 0;
        }
    }


    @Override
    public int delete(int id) {
        try {
            return productDao.delete(id);
        } catch (SQLException e) {
            return 0;
        }
    }
}
