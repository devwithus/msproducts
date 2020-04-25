package com.restapi.msproducts.controller;

import java.net.URI;
import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.Min;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.restapi.msproducts.dto.ProductDTO;
import com.restapi.msproducts.exception.ProductNotFoundException;
import com.restapi.msproducts.mapper.ProductMapper;
import com.restapi.msproducts.model.Product;
import com.restapi.msproducts.service.ProductService;

@RestController
@RequestMapping("/api")
public class ProductController {
	
	@Autowired
	private ProductService productService;
	
	@GetMapping(value="/products")
	List<Product> getAll(){
		return productService.getAllProducts();
	}
	
	@GetMapping(value="/products/{id}")
	ResponseEntity<Product> getById(@PathVariable("id") @Min(1) int id) {
		
		Product prd = productService.findById(id)
				                    .orElseThrow(()->new ProductNotFoundException("No Product with ID : "+id));
		 
		return ResponseEntity.ok().body(prd);
	}
	
	@PostMapping(value="/products")
	ResponseEntity<?> createProduct(@Valid @RequestBody ProductDTO inprod) {
		Product prd      = ProductMapper.DtoToEntity(inprod);
		Product addedprd = productService.save(prd);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest()
						                .path("/{id}")
						                .buildAndExpand(addedprd.getId())
						                .toUri();
		return ResponseEntity.created(location).build();
	}
	
	@PutMapping(value="/products/{id}")
	ResponseEntity<Product> updateEmployee(@PathVariable("id")  @Min(1) int id, @Valid @RequestBody ProductDTO inprod) {

		Product prd = productService.findById(id)
                					.orElseThrow(()->new ProductNotFoundException("No Product with ID : "+id));
		
		Product newprd      = ProductMapper.DtoToEntity(inprod);
		newprd.setId(prd.getId());
		productService.save(newprd);
		return ResponseEntity.ok().body(newprd);
		
	}
	
	@DeleteMapping(value="/products/{id}")
	ResponseEntity<String> deleteEmployee( @PathVariable("id") @Min(1) int id) {
		Product prd = productService.findById(id)
				                    .orElseThrow(()->new ProductNotFoundException("No Product with ID : "+id));

		productService.delete(prd.getId());
		return ResponseEntity.ok().body("Product with ID : "+id+" deleted with success!");
		
	}

}
