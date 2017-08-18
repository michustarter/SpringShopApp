package com.capgemini.shop.intern.services;

import java.util.Map;

import org.springframework.stereotype.Service;

import com.capgemini.shop.intern.enums.ProductUnitWeight;
import com.capgemini.shop.intern.types.ShoppingList;
import com.capgemini.shop.service.to.ProductTO;

@Service
public class LoyaltyPointsCalculator {

	/**
	 * @param shoppingList
	 * @return
	 */
	public double computeLoyaltyPoints(ShoppingList shoppingList) {

		double result = 0;

		for (Map.Entry<ProductTO, Integer> entry : shoppingList.getProductList().entrySet()) {
			int weight = determineWeight(entry);
			result += entry.getValue() * entry.getKey().getPrice() * weight / 100;

		}
		return result;
	}

	private int determineWeight(Map.Entry<ProductTO, Integer> entry) {
		int weight = 1;
		for (ProductUnitWeight productUnitWeight : ProductUnitWeight.values()) {
			if (productUnitWeight.getUnit().equals(entry.getKey().getUnit())) {
				weight = productUnitWeight.getWeight();
			}
		}
		return weight;
	}

}
