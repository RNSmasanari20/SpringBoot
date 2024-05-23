package com.example.lesson.repository;

import com.example.lesson.entity.ProductRecord;

import java.sql.SQLException;
import java.util.List;

public interface ProductDao {

    List<ProductRecord> findAll() throws SQLException;

    ProductRecord findById(int id) throws SQLException;

    int insert(ProductRecord productRecord) throws SQLException;

    int update(ProductRecord productRecord) throws SQLException;

    int delete(int id) throws SQLException;
}
