package com.capgemini.shop.service;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.capgemini.shop.dataaccess.entities.UserAccountEntity;
import com.capgemini.shop.service.exception.UnknownObjectRequestException;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class UserAccountServiceTest {

	@Autowired
	UserAccountService userAccountService;

	@Test
	@Transactional
	public void shouldGetAccountByLogin() throws UnknownObjectRequestException {
		// given
		String login = "zbyniu";

		// when
		UserAccountEntity user = userAccountService.getUserByLogin(login);

		// then
		assertTrue(user != null);
		assertEquals(user.getLogin(), login);

	}

}
