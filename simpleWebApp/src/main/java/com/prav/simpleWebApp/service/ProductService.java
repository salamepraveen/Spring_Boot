package com.prav.simpleWebApp.service;
import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.prav.simpleWebApp.model.*;
import com.prav.simpleWebApp.repository.ProductRepo;


@Service
public class ProductService {
	
	@Autowired
	ProductRepo productRepo;
	
		
//	List<Product> products=new ArrayList<>(Arrays.asList(new Product(101,"Iphone",5000),new Product(102,"Canon Camera",70000),new Product(103,"Shure Mic",10000)));
	
//	public List<Product> products;
	
	
	
	public List<Product> getProducts(){
		
		return productRepo.findAll();
	}
	
	public Product getProductById(int prodId){
		return productRepo.findById(prodId).orElse(new Product());
	}
	
//	public Product getProductById1(int prodId) {
//		return products.stream().filter(n->n.getProdId()==prodId).findFirst().get();
//		
//	}

	public void addProduct(Product prod) {
		// TODO Auto-generated method stub
//		products.add(prod);
		productRepo.save(prod);
	}
	
	public void updateProduct(Product prod) {
//		int index=0;
//		for(int i=0;i<products.size();i++) 
//			if(products.get(i).getProdId()==prod.getProdId())
//				index=i;
//		
//		products.set(index, prod);
		productRepo.save(prod);
	}

	public void deleteProduct(int prod) {
		// TODO Auto-generated method stub
//		int index=0;
//		for(int i=0;i<products.size();i++) 
//			if(products.get(i).getProdId()==prod)
//				index=i;
//		products.remove(index);
		productRepo.deleteById(prod);
	}
}
