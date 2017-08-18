package com.capgemini.shop.intern.types;

import java.util.Map;

import com.capgemini.shop.service.to.ProductTO;

public class ShoppingList {

	public ShoppingList(Map<ProductTO, Integer> productList) {
		super();
		this.productList = productList;
	}

	public Map<ProductTO, Integer> getProductList() {
		return productList;
	}

	public void setProductList(Map<ProductTO, Integer> productList) {
		this.productList = productList;
	}

	public void add(ProductTO product) {
		if (productList.containsKey(product)) {
			productList.put(product, productList.get(product) + 1);
		} else {
			productList.put(product, 1);
		}
	}

	private Map<ProductTO, Integer> productList;

}
