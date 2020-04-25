package com.restapi.msproducts.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.restapi.msproducts.model.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {

}
