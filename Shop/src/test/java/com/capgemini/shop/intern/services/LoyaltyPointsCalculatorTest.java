package com.capgemini.shop.intern.services;

import java.util.HashMap;
import java.util.Map;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.capgemini.shop.intern.types.ShoppingList;
import com.capgemini.shop.service.to.ProductTO;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class LoyaltyPointsCalculatorTest {

	@Autowired
	private LoyaltyPointsCalculator loyaltyPointsCalculatorTest;

	private ShoppingList shoppingList;

	@Before
	public void setup() {
		ProductTO product1 = new ProductTO("kg", "aa", 2);
		ProductTO product2 = new ProductTO("kg", "ww", 2);
		ProductTO product3 = new ProductTO("liter", "bb", 5);
		ProductTO product4 = new ProductTO("piece", "cc", 10);

		Map<ProductTO, Integer> prodMap = new HashMap<>();
		prodMap.put(product1, 2);
		prodMap.put(product2, 1);
		prodMap.put(product3, 5);
		prodMap.put(product4, 10);

		shoppingList = new ShoppingList(prodMap);

	}

	@Test
	public void shouldComputePointsForNonEmptyList() {
		// given
		int expectedLoyaltyPoints = 15;

		// when
		double points = loyaltyPointsCalculatorTest.computeLoyaltyPoints(shoppingList);

		// then
		Assert.assertTrue(points != 1);
		Assert.assertTrue(points == expectedLoyaltyPoints);

	}

}
