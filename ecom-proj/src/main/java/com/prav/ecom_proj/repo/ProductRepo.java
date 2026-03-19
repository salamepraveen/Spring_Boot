package com.prav.ecom_proj.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;



import com.prav.ecom_proj.model.Product;
import java.util.*;


@Repository
public interface ProductRepo extends JpaRepository<Product,Integer> {
//		JPQL - jva persistance query language
	@Query("SELECT p from Product p WHERE "+
			"LOWER(p.name) Like LOWER(CONCAT('%', :keyword, '%')) OR "+
			"LOWER(p.description) LIKE LOWER(CONCAT('%', :keyword, '%')) OR "+
			"LOWER(p.brand) LIKE LOWER(CONCAT('%', :keyword, '%')) OR "+
			"LOWER(p.category) LIKE LOWER(CONCAT('%', :keyword, '%'))")
	List<Product> searchPrducts(String keyword);
}
