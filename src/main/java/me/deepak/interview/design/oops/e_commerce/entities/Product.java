package me.deepak.interview.design.oops.e_commerce.entities;

import java.math.BigDecimal;
import java.util.List;

public class Product {

	private String productId;
	private String name;
	private String brand;
	private BigDecimal price;
	private double rating;
	private List<String> mediaFileURLs;

	public String getProductId() {
		return productId;
	}

	public String getName() {
		return name;
	}

	public String getBrand() {
		return brand;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public double getRating() {
		return rating;
	}

	public List<String> getMediaFileURLs() {
		return mediaFileURLs;
	}

}
