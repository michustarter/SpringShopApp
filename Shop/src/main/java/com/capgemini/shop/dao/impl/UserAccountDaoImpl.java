package com.capgemini.shop.dao.impl;

import java.util.List;

import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import com.capgemini.shop.dao.UserAccountDao;
import com.capgemini.shop.dataaccess.entities.UserAccountEntity;
import com.capgemini.shop.service.exception.UnknownObjectRequestException;

/**
 * @author RWEYCHAN Methods for CRUD-like operations on user profile data stored
 *         in database
 */
@Repository
public class UserAccountDaoImpl extends AbstractDao<UserAccountEntity, Long> implements UserAccountDao {

	/**
	 * Just a constructor
	 * 
	 * @throws UnknownObjectRequestException
	 */
	public UserAccountDaoImpl() {

	}

	@Override
	public List<UserAccountEntity> getAccountsByIdList(List<Long> idList) {

		TypedQuery<UserAccountEntity> query = entityManager.createQuery(
				"select profile from UserProfileEntity profile where profile.id IN :idList", UserAccountEntity.class);

		query.setParameter("idList", idList);

		return query.getResultList();

	}

	@Override
	public UserAccountEntity getByLogin(String login) {
		TypedQuery<UserAccountEntity> query = entityManager.createQuery(
				"select account from UserAccountEntity account where account.login = :login", UserAccountEntity.class);

		query.setParameter("login", login);

		return query.getResultList().isEmpty() ? null : query.getSingleResult();
	}

	@Override
	public List<UserAccountEntity> getByProduct(String product) {
		TypedQuery<UserAccountEntity> query = entityManager.createQuery(
				"select distinct account from UserAccountEntity account "
						+ " join fetch account.boughtItems history join fetch history.product prod where prod.name = :prodName",
				UserAccountEntity.class);

		query.setParameter("prodName", product);
		return query.getResultList();
	}

}
