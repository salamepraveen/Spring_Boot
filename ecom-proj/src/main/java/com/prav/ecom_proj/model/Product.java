package com.prav.ecom_proj.model;

import java.math.BigDecimal;
import java.sql.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import lombok.AllArgsConstructor;
import lombok.*;
import lombok.NoArgsConstructor;


@Entity

public class Product {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;
    private String brand;
    private String description;
    private String category;

    private Double price;

    private Integer quantity;

    private Boolean available;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private Date releaseDate;

    private String imageName;
    private String imageType;

    @Lob
    private byte[] imageData;

    public Product() {
		
	}

	

	public Product(Integer id, String name, String brand, String description, String category, Double price,
			Integer quantity, Boolean available, Date releaseDate, String imageName, String imageType,
			byte[] imageData) {
	
		this.id = id;
		this.name = name;
		this.brand = brand;
		this.description = description;
		this.category = category;
		this.price = price;
		this.quantity = quantity;
		this.available = available;
		this.releaseDate = releaseDate;
		this.imageName = imageName;
		this.imageType = imageType;
		this.imageData = imageData;
	}



	public Integer getId() {
		return id;
	}



	public void setId(Integer id) {
		this.id = id;
	}



	public String getName() {
		return name;
	}



	public void setName(String name) {
		this.name = name;
	}



	public String getBrand() {
		return brand;
	}



	public void setBrand(String brand) {
		this.brand = brand;
	}



	public String getDescription() {
		return description;
	}



	public void setDescription(String description) {
		this.description = description;
	}



	public String getCategory() {
		return category;
	}



	public void setCategory(String category) {
		this.category = category;
	}



	public Double getPrice() {
		return price;
	}



	public void setPrice(Double price) {
		this.price = price;
	}



	public Integer getQuantity() {
		return quantity;
	}



	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}



	public Boolean getAvailable() {
		return available;
	}



	public void setAvailable(Boolean available) {
		this.available = available;
	}



	public Date getReleaseDate() {
		return releaseDate;
	}



	public void setReleaseDate(Date releaseDate) {
		this.releaseDate = releaseDate;
	}



	public String getImageName() {
		return imageName;
	}



	public void setImageName(String imageName) {
		this.imageName = imageName;
	}



	public String getImageType() {
		return imageType;
	}



	public void setImageType(String imageType) {
		this.imageType = imageType;
	}



	public byte[] getImageData() {
		return imageData;
	}



	public void setImageData(byte[] imageData) {
		this.imageData = imageData;
	}
	
	
	
	}



	
