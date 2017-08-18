package com.capgemini.shop.service.facade;

import java.util.ArrayList;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.capgemini.shop.dataaccess.entities.ProductEntity;
import com.capgemini.shop.intern.services.LoyaltyPointsCalculator;
import com.capgemini.shop.intern.services.ShoppingListGenerator;
import com.capgemini.shop.intern.types.ShoppingList;
import com.capgemini.shop.service.ProductService;
import com.capgemini.shop.service.facade.impl.LoyaltyPointsCounterServiceImpl;
import com.capgemini.shop.service.to.UserAccountTO;
import com.capgemini.shop.service.to.UserLoyaltyPointsTO;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class LoyaltyPointsCounterServiceImplTest {

	@Mock
	private ProductService productService;

	@Mock
	private ShoppingListGenerator shoppingListGenerator;

	@Mock
	private LoyaltyPointsCalculator loyaltyPointsCalculator;

	@InjectMocks
	private LoyaltyPointsCounterServiceImpl loyaltyPointsCounterService;

	@Test
	public void shouldComputeLoyaltyPoints() {

		// given
		UserAccountTO user = new UserAccountTO("login", "name", "surname", 0);
		ShoppingList shoppingList = Mockito.mock(ShoppingList.class);
		double loyaltyPoints = 10;
		Mockito.when(productService.getByCustomer(Mockito.anyString())).thenReturn(new ArrayList<ProductEntity>());
		Mockito.when(shoppingListGenerator.generate(Mockito.anyListOf(ProductEntity.class))).thenReturn(shoppingList);
		Mockito.when(loyaltyPointsCalculator.computeLoyaltyPoints(Mockito.any(ShoppingList.class)))
				.thenReturn(loyaltyPoints);

		// when
		UserLoyaltyPointsTO userLoyaltyPoints = loyaltyPointsCounterService.computeLoyaltyPonitsForUser(user);

		// then
		Assert.assertNotNull(userLoyaltyPoints);
		Assert.assertEquals(user.getLogin(), userLoyaltyPoints.getLogin());
		Assert.assertEquals(loyaltyPoints, userLoyaltyPoints.getLoyaltyPoints(), 0.01);
		Mockito.verify(loyaltyPointsCalculator, Mockito.times(1)).computeLoyaltyPoints(Mockito.any(ShoppingList.class));

	}

}
