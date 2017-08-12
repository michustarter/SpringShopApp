package com.capgemini.shop.service.to;

public class UserLoyaltyPointsTO {

	private String login;
	private long loyaltyPoints;

	public UserLoyaltyPointsTO(String login, long loyaltyPoints) {
		this.login = login;
		this.loyaltyPoints = loyaltyPoints;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public long getLoyaltyPoints() {
		return loyaltyPoints;
	}

	public void setLoyaltyPoints(long loyaltyPoints) {
		this.loyaltyPoints = loyaltyPoints;
	}

}
