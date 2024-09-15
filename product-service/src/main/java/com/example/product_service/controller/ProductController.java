package com.example.product_service.controller;

import org.springframework.web.bind.annotation.RestController;

import com.example.product_service.entity.Product;
import com.example.product_service.repository.ProductRepository;

import java.util.List;
import java.util.Optional;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping; 

import org.springframework.web.bind.annotation.PathVariable;

import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/products")
public class ProductController {
	
	@Autowired
	private ProductRepository productRepository;
	
	@GetMapping
	public List<Product> getProducts() {
		return productRepository.findAll();
	}
	
	@GetMapping("/{id}")
	public Optional<Product> getProductById(@PathVariable Long id) {
		return productRepository.findById(id);
	}
	
	@PostMapping("/save")
	public Product saveProduct(@RequestBody Product product) {
		System.out.println("Product ====> " + product);
		return productRepository.save(product);
	}

}
