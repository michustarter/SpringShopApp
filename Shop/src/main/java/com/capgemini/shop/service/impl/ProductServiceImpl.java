package com.capgemini.shop.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.capgemini.shop.dao.ProductDao;
import com.capgemini.shop.dataaccess.entities.ProductEntity;
import com.capgemini.shop.service.ProductService;
import com.capgemini.shop.service.exception.UnknownObjectRequestException;

/**
 * @author RWEYCHAN Methods for managing data related to full user profile
 */
@Service
@Transactional(readOnly = true)
public class ProductServiceImpl implements ProductService {

	@Autowired
	private ProductDao productDao;

	@Override
	public ProductEntity getProduct(long id) throws UnknownObjectRequestException {
		return productDao.findOne(id);
	}

	@Override
	public List<ProductEntity> getByName(String prodName) {
		return productDao.getByName(prodName);
	}

	@Override
	public List<ProductEntity> getByPriceRange(int lowBorder, int highBorder) {
		return productDao.getByPriceRange(lowBorder, highBorder);
	}

	@Override
	public List<ProductEntity> getByCustomer(String login) {
		return productDao.getByCustomer(login);
	}

	@Override
	public void deleteProduct(long id) {
		productDao.delete(id);

	}

	@Override
	public ProductEntity createProduct(ProductEntity productEntity) {
		return productDao.save(productEntity);
	}

	@Override
	public ProductEntity updateUProduct(ProductEntity productEntity) {
		return productDao.update(productEntity);
	}

}
