package com.capgemini.shop.facade;

import com.capgemini.shop.service.to.UserAccountTO;
import com.capgemini.shop.service.to.UserLoyaltyPointsTO;

public interface LoyaltyPointsCounterService {

	UserLoyaltyPointsTO computeLoyaltyPonitsForUser(UserAccountTO user);

}
