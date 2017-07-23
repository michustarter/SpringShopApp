package com.capgemini.shop.dao;

import java.util.List;

import com.capgemini.shop.dataaccess.entities.ProductEntity;

/**
 * @author RWEYCHAN DAO for making CRUD-like operations on data related to
 *         product items
 * 
 */
public interface ProductDao extends Dao<ProductEntity, Long> {

	List<ProductEntity> getByName(String prodName);

	List<ProductEntity> getByPriceRange(int lowBorder, int highBorder);

	List<ProductEntity> getByCustomer(String login);

}
