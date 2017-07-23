package com.capgemini.shop.service.to;

/**
 * @author RWEYCHAN Transport object for user profile data - getters and setters
 */
public class ProductTO {

	public ProductTO() {

	}

	private long id;
	private String unit;
	private String name;
	private int price;

	public String getUnit() {
		return unit;
	}

	public void setUnit(String unit) {
		this.unit = unit;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public long getId() {
		return id;
	}

	public ProductTO(String unit, String name, int price) {
		super();
		this.unit = unit;
		this.name = name;
		this.price = price;
	}

}
