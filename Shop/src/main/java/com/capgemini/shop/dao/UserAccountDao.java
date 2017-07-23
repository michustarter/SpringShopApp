package com.capgemini.shop.dao;

import java.util.List;

import com.capgemini.shop.dataaccess.entities.UserAccountEntity;

/**
 * @author RWEYCHAN DAO for making CRUD-like operations on data related to user
 *         account
 */
public interface UserAccountDao extends Dao<UserAccountEntity, Long> {

	UserAccountEntity getByLogin(String login);

	List<UserAccountEntity> getByProduct(String product);

	List<UserAccountEntity> getAccountsByIdList(List<Long> idList);

}
