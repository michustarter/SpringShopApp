package com.capgemini.shop.service;

import java.util.List;

import com.capgemini.shop.dataaccess.entities.ProductEntity;
import com.capgemini.shop.service.exception.UnknownObjectRequestException;

/**
 * @author RWEYCHAN Service for managing data related to products
 */
public interface ProductService {

	ProductEntity getProduct(long id) throws UnknownObjectRequestException;

	List<ProductEntity> getByName(String prodName);

	List<ProductEntity> getByPriceRange(int lowBorder, int highBorder);

	List<ProductEntity> getByCustomer(String login);

	void deleteProduct(long id);

	ProductEntity createProduct(ProductEntity productEntity);

	ProductEntity updateUProduct(ProductEntity productEntity);

}
