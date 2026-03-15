package com.prav.ecom_proj.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.prav.ecom_proj.model.Product;
import com.prav.ecom_proj.repo.ProductRepo;
import com.prav.ecom_proj.service.ProductService;

import java.io.IOException;
import java.util.*;

@RestController
@CrossOrigin
@RequestMapping("/api")
public class ProductController {
	
	
	
	private ProductService service;
	
	public ProductController(ProductService service) {
		this.service=service;
	}
	
	
	@RequestMapping("/")
	public String greet() {
		return "Hello my freind";
	}
	
	@GetMapping("/products")
	public ResponseEntity<List<Product>>  getAllProducts(){
		return  new ResponseEntity<>(service.getAllProducts(),HttpStatus.OK);
	}
	
	@CrossOrigin
	@GetMapping("/products/{prodId}")
	public ResponseEntity<Product> getProduct(@PathVariable int prodId) {
		Product product =service.getProductById(prodId);
		if(product!=null) {
			return new ResponseEntity<>(service.getProductById(prodId),HttpStatus.OK);
		}
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}
	
	
	@PostMapping("/products")
	public ResponseEntity<?> addProduct(@RequestPart Product product,
										@RequestPart MultipartFile imageFile){
		try {
			Product product1=service.addProduct(product,imageFile);
			return new ResponseEntity<>(product1,HttpStatus.OK);
		}catch(Exception e) {
			return new ResponseEntity<>(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
		}
	
	}
	
	@GetMapping("/products/{prodId}/image")
	public ResponseEntity<byte[]> getImageByProductId(@PathVariable int prodId){
		Product product=service.getProductById(prodId);
		byte[] imageFile=product.getImageData();
		
		return ResponseEntity.ok().contentType(MediaType.valueOf(product.getImageType())).body(imageFile);
	}
	
	
	
	@PutMapping("/products/{id}")
	public ResponseEntity<String> updateProduct(@PathVariable int id,@RequestPart Product product,@RequestPart MultipartFile imageFile) throws IOException{
		
		Product product2=service.updateProduct(id,product,imageFile);
		
		if(product2!=null) {
			return new ResponseEntity<>("Updated",HttpStatus.OK);
		}
		else {
			return new ResponseEntity<>("Failed to update",HttpStatus.BAD_REQUEST);
		}
	}
	
	@DeleteMapping("/products/{id}")
	public ResponseEntity<String> deleteProduct(@PathVariable int id){
		Product product =service.getProductById(id);
		if(product!=null) {
			service.deleteProduct(id);
			return new ResponseEntity<>("Deleted",HttpStatus.OK);
		}else {
			return new ResponseEntity<>("Product not found",HttpStatus.NOT_FOUND);
		}
	}
	
	
	
}


