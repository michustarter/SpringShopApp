package com.capgemini.shop.service.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.capgemini.shop.service.UserAccountService;
import com.capgemini.shop.service.exception.UnknownObjectRequestException;
import com.capgemini.shop.service.exception.UserExistsException;
import com.capgemini.shop.service.mapper.UserAccountMapper;
import com.capgemini.shop.service.to.UserAccountTO;

@CrossOrigin(origins = "*")
@Controller
@RequestMapping("/rest/account")
public class UserAccountRestService {

	UserAccountService userAccountService;

	@Autowired
	public UserAccountRestService(UserAccountService userAccountService) {
		this.userAccountService = userAccountService;
	}

	@RequestMapping(value = "/find/{login}", method = RequestMethod.GET)
	@ResponseBody
	public UserAccountTO readUser(@PathVariable String login) throws UnknownObjectRequestException {

		return UserAccountMapper.map(userAccountService.getUserByLogin(login));

	}

	@RequestMapping(value = "/find/byProd/{product}", method = RequestMethod.GET)
	@ResponseBody
	public List<UserAccountTO> readUsersByProduct(@PathVariable String product) throws UnknownObjectRequestException {

		return UserAccountMapper.map2TOs(userAccountService.getByProduct(product));

	}

	@RequestMapping(value = "/usr/all", method = RequestMethod.GET)
	@ResponseBody
	public List<UserAccountTO> readAll() throws UnknownObjectRequestException {

		return UserAccountMapper.map2TOs(userAccountService.getAll());

	}

	@RequestMapping(value = "/update", method = RequestMethod.POST)
	@ResponseBody
	public UserAccountTO updateUser(@RequestBody UserAccountTO userTo) {
		return UserAccountMapper.map(userAccountService.updateUser(UserAccountMapper.map(userTo)));
	}

	@RequestMapping(value = "/create", method = RequestMethod.POST)
	@ResponseBody
	public UserAccountTO createUser(@RequestBody UserAccountTO userTo) throws UserExistsException {
		return UserAccountMapper.map(userAccountService.createUser(UserAccountMapper.map(userTo)));

	}

	@RequestMapping(value = "/delete/{id}", method = RequestMethod.POST)
	@ResponseBody
	public void deleteUser(@PathVariable Long id) {
		userAccountService.deleteUser(id);
	}

}
