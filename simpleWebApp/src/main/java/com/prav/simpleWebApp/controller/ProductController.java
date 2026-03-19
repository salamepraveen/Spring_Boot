package com.prav.simpleWebApp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.prav.simpleWebApp.model.Product;
import com.prav.simpleWebApp.service.ProductService;


@RestController
public class ProductController {
	
	@Autowired
	ProductService productService;
	
	
	@GetMapping("/products")
	public List<Product> getProducts() {
		return productService.getProducts();
		
	}
	
	@GetMapping("/products/{prodId}")
	public Product getProductById(@PathVariable int prodId){
		return productService.getProductById(prodId);
		
	}
	
	@PostMapping("/products")
	public void addProduct(@RequestBody Product prod) {
		productService.addProduct(prod);
	}
	
	@PutMapping("/products")
	public void updateProduct(@RequestBody Product prod) {
		productService.updateProduct(prod);
	}
	
	@DeleteMapping("/products/{prod}")
	public void deleteProduct(@PathVariable int prod) {
		productService.deleteProduct(prod);
	}
}
