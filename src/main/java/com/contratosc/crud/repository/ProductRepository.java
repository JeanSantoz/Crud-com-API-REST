package com.contratosc.crud.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.contratosc.crud.model.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {
    
}