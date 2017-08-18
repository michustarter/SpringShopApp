package com.capgemini.shop.service.mapper;

import java.util.List;
import java.util.stream.Collectors;

import com.capgemini.shop.dataaccess.entities.ProductEntity;
import com.capgemini.shop.dataaccess.entities.UserAccountEntity;
import com.capgemini.shop.service.to.ProductTO;
import com.capgemini.shop.service.to.UserAccountTO;

public class ProductMapper {

	public static ProductTO map(ProductEntity productEntity) {
		if (productEntity != null) {
			ProductTO productTO = new ProductTO(productEntity.getUnit(), productEntity.getName(),
					productEntity.getPrice());

			return productTO;
		}
		return null;
	}

	public static ProductEntity map(ProductTO productTO) {
		if (productTO != null) {
			ProductEntity productEntity = new ProductEntity();
			productEntity.setName(productTO.getName());
			productEntity.setPrice(productTO.getPrice());
			productEntity.setUnit(productTO.getUnit());

			return productEntity;
		}
		return null;
	}

	public static ProductEntity update(ProductEntity productEntity, ProductTO productTO) {
		if (productTO != null && productEntity != null) {

		}
		return productEntity;
	}

	public static List<ProductTO> map2TOs(List<ProductEntity> productEntities) {
		return productEntities.stream().map(ProductMapper::map).collect(Collectors.toList());
	}

	public static List<ProductEntity> map2Entities(List<ProductTO> productTOs) {
		return productTOs.stream().map(ProductMapper::map).collect(Collectors.toList());
	}

}
