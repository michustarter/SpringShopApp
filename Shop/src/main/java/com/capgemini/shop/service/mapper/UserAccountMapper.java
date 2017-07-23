package com.capgemini.shop.service.mapper;

import java.util.List;
import java.util.stream.Collectors;

import com.capgemini.shop.dataaccess.entities.UserAccountEntity;
import com.capgemini.shop.service.to.UserAccountTO;;

public class UserAccountMapper {

	public static UserAccountTO map(UserAccountEntity userAccountEntity) {
		if (userAccountEntity != null) {
			UserAccountTO userAccountTO = new UserAccountTO(userAccountEntity.getLogin(), userAccountEntity.getName(),
					userAccountEntity.getSurname(), userAccountEntity.getDiscount());

			return userAccountTO;
		}
		return null;
	}

	public static UserAccountEntity map(UserAccountTO userAccountTO) {
		if (userAccountTO != null) {
			UserAccountEntity userAccountEntity = new UserAccountEntity();
			userAccountEntity.setDiscount(userAccountTO.getDiscount());
			userAccountEntity.setLogin(userAccountTO.getLogin());
			userAccountEntity.setName(userAccountTO.getName());
			userAccountEntity.setSurname(userAccountTO.getSurname());
			return userAccountEntity;
		}
		return null;
	}

	public static UserAccountEntity update(UserAccountEntity userEntity, UserAccountTO userTO) {
		if (userTO != null && userEntity != null) {

		}
		return userEntity;
	}

	public static List<UserAccountTO> map2TOs(List<UserAccountEntity> userEntities) {
		return userEntities.stream().map(UserAccountMapper::map).collect(Collectors.toList());
	}

	public static List<UserAccountEntity> map2Entities(List<UserAccountTO> userTOs) {
		return userTOs.stream().map(UserAccountMapper::map).collect(Collectors.toList());
	}

}
