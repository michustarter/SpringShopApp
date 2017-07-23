package com.capgemini.shop.service;

import java.util.List;

import com.capgemini.shop.dataaccess.entities.UserAccountEntity;
import com.capgemini.shop.service.exception.UnknownObjectRequestException;

/**
 * @author RWEYCHAN Service for managing data related to player profiles
 */
public interface UserAccountService {

	/**
	 * @param id
	 *            Id of user to read his profile
	 * @return Profile of user
	 * @throws UnknownObjectRequestException
	 */
	UserAccountEntity getUser(long id) throws UnknownObjectRequestException;

	UserAccountEntity getUserByLogin(String login) throws UnknownObjectRequestException;

	void deleteUser(long id);

	UserAccountEntity createUser(UserAccountEntity userAccountEntity);

	UserAccountEntity updateUser(UserAccountEntity userAccountEntity);

	List<UserAccountEntity> getByProduct(String product);

	List<UserAccountEntity> getAccountsByIdList(List<Long> idList);

	List<UserAccountEntity> getAll();

}
