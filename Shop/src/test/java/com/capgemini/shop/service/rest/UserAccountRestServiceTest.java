package com.capgemini.shop.service.rest;

import static org.junit.Assert.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.io.File;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.context.WebApplicationContext;

import com.capgemini.shop.dataaccess.entities.UserAccountEntity;
import com.capgemini.shop.service.UserAccountService;
import com.capgemini.shop.utils.FileUtils;

@WebAppConfiguration
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class UserAccountRestServiceTest {

	@Autowired
	private UserAccountService userAccountService;

	@Autowired
	private WebApplicationContext wac;

	private MockMvc mockMvc;

	@Before
	public void setUp() {
		MockitoAnnotations.initMocks(this);
		this.mockMvc = MockMvcBuilders.webAppContextSetup(this.wac).build();
	}

	@Test
	@Transactional
	public void shouldReadUserByLogin() throws Exception {

		// given:
		String login = "zbyniu";
		UserAccountEntity user = userAccountService.getUserByLogin(login);

		// when
		ResultActions response = this.mockMvc.perform(get("/rest/account/find/" + login));

		// then
		response.andExpect(status().isOk())//
				.andExpect(jsonPath(".login").value((String) user.getLogin()));
	}

	@Test
	@Transactional
	public void shouldReadUsersByProduct() throws Exception {

		// given:
		String product = "banana";
		List<UserAccountEntity> user = userAccountService.getByProduct(product);

		// when
		ResultActions response = this.mockMvc.perform(get("/rest/account/find/byProd/" + product));

		// then
		response.andExpect(status().isOk())//
				.andExpect(jsonPath("[0].login").value((String) user.get(0).getLogin()))
				.andExpect(jsonPath("[1].login").value((String) user.get(1).getLogin()));
	}

	@Test
	@Transactional
	public void testShouldCreateUser() throws Exception {

		// given
		File file = FileUtils.getFileFromClasspath("classpath:com/capgemini/shop/json/userToSave.json");
		String json = FileUtils.readFileToString(file);
		int numOfEntries = userAccountService.getAll().size();
		// when
		ResultActions response = this.mockMvc.perform(post("/rest/account/create").accept(MediaType.APPLICATION_JSON)
				.contentType(MediaType.APPLICATION_JSON).content(json.getBytes()));
		// then
		response.andExpect(status().isOk());
		assertTrue(userAccountService.getAll().size() == numOfEntries + 1);
	}

	@Test
	@Transactional
	public void testShouldUpdateUser() throws Exception {

		// given
		File file = FileUtils.getFileFromClasspath("classpath:com/capgemini/shop/json/userToUpdate.json");
		String json = FileUtils.readFileToString(file);
		int numOfEntries = userAccountService.getAll().size();
		String updatedLogin = "updated";

		// when
		ResultActions response = this.mockMvc.perform(post("/rest/account/update").accept(MediaType.APPLICATION_JSON)
				.contentType(MediaType.APPLICATION_JSON).content(json.getBytes()));
		// then
		response.andExpect(status().isOk());
		assertTrue(userAccountService.getAll().size() == numOfEntries);
		response.andExpect(status().isOk())//
				.andExpect(jsonPath(".login").value(updatedLogin));
	}

}
