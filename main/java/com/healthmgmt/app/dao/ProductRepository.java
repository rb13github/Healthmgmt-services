package com.healthmgmt.app.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.healthmgmt.app.entity.Product;
//ref:https://www.codejava.net/frameworks/spring-boot/spring-boot-crud-example-with-spring-mvc-spring-data-jpa-thymeleaf-hibernate-mysql
public interface ProductRepository extends JpaRepository<Product, Long> {
 
}