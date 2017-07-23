package com.capgemini.shop.dao.impl;

import java.util.List;

import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import com.capgemini.shop.dao.ProductDao;
import com.capgemini.shop.dataaccess.entities.ProductEntity;
import com.capgemini.shop.service.exception.UnknownObjectRequestException;

/**
 * @author RWEYCHAN Methods for CRUD-like operations on user profile data stored
 *         in database
 */
@Repository
public class ProductDaoImpl extends AbstractDao<ProductEntity, Long> implements ProductDao {

	/**
	 * Just a constructor
	 * 
	 * @throws UnknownObjectRequestException
	 */
	public ProductDaoImpl() {

	}

	@Override
	public List<ProductEntity> getByName(String prodName) {
		TypedQuery<ProductEntity> query = entityManager
				.createQuery("select prod from ProductEntity prod where prod.name = :prodName", ProductEntity.class);

		query.setParameter("prodName", prodName);

		return query.getResultList().isEmpty() ? null : query.getResultList();
	}

	@Override
	public List<ProductEntity> getByPriceRange(int lowBorder, int highBorder) {
		TypedQuery<ProductEntity> query = entityManager.createQuery(
				"select prod from ProductEntity prod where prod.price < :highBorder and prod.price > :lowBorder",
				ProductEntity.class);

		query.setParameter("lowBorder", lowBorder);
		query.setParameter("highBorder", highBorder);

		return query.getResultList().isEmpty() ? null : query.getResultList();
	}

	@Override
	public List<ProductEntity> getByCustomer(String login) {
		TypedQuery<ProductEntity> query = entityManager.createQuery(
				"select distinct prod from ProductEntity prod "
						+ " join fetch prod.purchaseHistory history join fetch history.userAccount usr where usr.login = : login",
				ProductEntity.class);

		query.setParameter("login", login);
		return query.getResultList();
	}

}
