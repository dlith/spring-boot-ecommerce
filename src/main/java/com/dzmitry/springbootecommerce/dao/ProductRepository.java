package com.dzmitry.springbootecommerce.dao;


import com.dzmitry.springbootecommerce.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
