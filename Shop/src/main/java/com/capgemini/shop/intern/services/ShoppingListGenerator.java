package com.capgemini.shop.intern.services;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.capgemini.shop.dataaccess.entities.ProductEntity;
import com.capgemini.shop.intern.types.ShoppingList;
import com.capgemini.shop.service.mapper.ProductMapper;
import com.capgemini.shop.service.to.ProductTO;

@Service
public class ShoppingListGenerator {

	/**
	 * @param productList
	 * @return
	 */
	public ShoppingList generate(List<ProductEntity> productList) {
		Map<ProductTO, Integer> productListWithAmount = new HashMap<ProductTO, Integer>();

		for (ProductEntity product : productList) {
			ProductTO productTO = ProductMapper.map(product);
			if (productListWithAmount.containsKey(productTO)) {
				productListWithAmount.put(productTO, productListWithAmount.get(productTO) + 1);
			} else {
				productListWithAmount.put(productTO, 1);
			}
		}
		return new ShoppingList(productListWithAmount);
	}

}
