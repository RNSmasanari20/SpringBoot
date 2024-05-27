package com.example.lesson;

import com.example.lesson.entity.ProductRecord;
import com.example.lesson.service.PgProductService;
import com.example.lesson.service.ProductService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class LessonApplication {

    public static void main(String[] args) {
        var context = SpringApplication.run(LessonApplication.class, args);

        ProductService pgProductService = context.getBean(ProductService.class);

//        var list = pgProductService.findAll();
//        list.forEach(System.out::println);

//        var product = pgProductService.findById(3);
//        System.out.println(product);


//        var newProductRecord = new ProductRecord(-1,"顕微鏡", 5000);
//        System.out.println(pgProductService.insert(newProductRecord) + "件更新しました");


//        var updateProductRecord = new ProductRecord(5, "ものすごい高い顕微鏡", 1000000);
//        System.out.println(pgProductService.update(updateProductRecord) + "件更新しました");


//        System.out.println(pgProductService.delete(5) + "件更新しました");
    }
}
