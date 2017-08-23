package com.capgemini.shop.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.capgemini.shop.dao.UserAccountDao;
import com.capgemini.shop.dataaccess.entities.UserAccountEntity;
import com.capgemini.shop.service.ProductService;
import com.capgemini.shop.service.UserAccountService;
import com.capgemini.shop.service.exception.UnknownObjectRequestException;

/**
 * @author RWEYCHAN Methods for managing data related to full user profile
 */
@Service
@Transactional(readOnly = true)
public class UserAccountServiceImpl implements UserAccountService {

	@Autowired
	private UserAccountDao userAccountDao;

	@Autowired
	private ProductService pruductService;

	@Override
	public UserAccountEntity getUser(long id) throws UnknownObjectRequestException {
		return userAccountDao.findOne(id);
	}

	@Override
	public UserAccountEntity getUserByLogin(String login) throws UnknownObjectRequestException {
		return userAccountDao.getByLogin(login);
	}

	@Transactional(readOnly = false)
	@Override
	public void deleteUser(long id) {
		userAccountDao.delete(id);

	}

	@Transactional(readOnly = false)
	@Override
	public UserAccountEntity createUser(UserAccountEntity userAccountEntity) {

		return userAccountDao.save(userAccountEntity);
	}

	@Transactional(readOnly = false)
	@Override
	public UserAccountEntity updateUser(UserAccountEntity userAccountEntity) {
		return userAccountDao.update(userAccountEntity);
	}

	@Override
	public List<UserAccountEntity> getByProduct(String product) {
		return userAccountDao.getByProduct(product);
	}

	@Override
	public List<UserAccountEntity> getAccountsByIdList(List<Long> idList) {
		return userAccountDao.getAccountsByIdList(idList);
	}

	@Override
	public List<UserAccountEntity> getAll() {
		return userAccountDao.findAll();
	}

}
