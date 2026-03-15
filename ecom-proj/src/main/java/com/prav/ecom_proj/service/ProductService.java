package com.prav.ecom_proj.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.prav.ecom_proj.repo.ProductRepo;
import com.prav.ecom_proj.model.*;

import java.io.IOException;
import java.util.*;

@Service
public class ProductService {
		
	@Autowired
	private ProductRepo repo;
	
	public List<Product> getAllProducts(){
		return repo.findAll();
	}

	public Product getProductById(int prodId) {
		// TODO Auto-generated method stub
		return repo.findById(prodId).orElse(null);
	}

	public Product addProduct(Product product, MultipartFile imageFile) throws IOException {
		// TODO Auto-generated method stub
		product.setImageName(imageFile.getOriginalFilename());
		product.setImageType(imageFile.getContentType());
	
		product.setImageData(imageFile.getBytes());
		
		
		return repo.save(product);
		
	}

	public Product updateProduct(int id, Product product, MultipartFile imageFile) throws IOException{
		// TODO Auto-generated method stub
		product.setImageData(imageFile.getBytes());
		product.setImageName(imageFile.getOriginalFilename());
		product.setImageType(imageFile.getContentType());
		
		
		return repo.save(product);
	}

	public void deleteProduct(int id) {
		// TODO Auto-generated method stub
		repo.deleteById(id);
	}
	
	
	
	
	
}
