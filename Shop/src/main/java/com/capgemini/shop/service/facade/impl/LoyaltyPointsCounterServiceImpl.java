package com.capgemini.shop.service.facade.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.shop.dataaccess.entities.ProductEntity;
import com.capgemini.shop.facade.LoyaltyPointsCounterService;
import com.capgemini.shop.intern.services.LoyaltyPointsCalculator;
import com.capgemini.shop.intern.services.ShoppingListGenerator;
import com.capgemini.shop.intern.types.ShoppingList;
import com.capgemini.shop.service.ProductService;
import com.capgemini.shop.service.to.UserAccountTO;
import com.capgemini.shop.service.to.UserLoyaltyPointsTO;

@Service
public class LoyaltyPointsCounterServiceImpl implements LoyaltyPointsCounterService {

	@Autowired
	private ProductService productService;

	@Autowired
	private ShoppingListGenerator shoppingListGenerator;

	@Autowired
	private LoyaltyPointsCalculator loyaltyPointsCalculator;

	@Override
	public UserLoyaltyPointsTO computeLoyaltyPonitsForUser(UserAccountTO user) {
		List<ProductEntity> productEntityList = productService.getByCustomer(user.getLogin());
		ShoppingList shoppingList = shoppingListGenerator.generate(productEntityList);
		double loyaltyPoints = loyaltyPointsCalculator.computeLoyaltyPoints(shoppingList);
		return new UserLoyaltyPointsTO(user.getLogin(), loyaltyPoints);
	}

}
