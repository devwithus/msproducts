package com.restapi.msproducts.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.restapi.msproducts.model.Product;
import com.restapi.msproducts.repository.ProductRepository;

@Service
public class ProductService implements Iproduct {
	
	@Autowired
	private ProductRepository productRepository;

	@Override
	public List<Product> getAllProducts() {
		// TODO Auto-generated method stub
		return productRepository.findAll();
	}

	@Override
	public Optional<Product> findById(int id) {
		// TODO Auto-generated method stub
		return productRepository.findById(id);
	}

	@Override
	public Product save(Product prd) {
		// TODO Auto-generated method stub
		return productRepository.save(prd);
	}

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		productRepository.deleteById(id);
	}

}
