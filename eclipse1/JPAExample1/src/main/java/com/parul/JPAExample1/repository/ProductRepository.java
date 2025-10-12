package com.parul.JPAExample1.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.parul.JPAExample1.models.Product;
public interface ProductRepository extends JpaRepository< Product, Long > {
}