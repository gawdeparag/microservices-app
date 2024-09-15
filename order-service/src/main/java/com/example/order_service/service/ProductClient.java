package com.example.order_service.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.example.order_service.dto.ProductDto;

@FeignClient(name = "product-service")
public interface ProductClient {
	@GetMapping("/products/{id}")
	ProductDto getProductById(@PathVariable("id") Long id);
}
