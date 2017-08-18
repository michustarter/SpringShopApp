package com.capgemini.shop.service.to;

public class UserLoyaltyPointsTO {

	private String login;
	private double loyaltyPoints;

	public UserLoyaltyPointsTO(String login, double loyaltyPoints) {
		this.login = login;
		this.loyaltyPoints = loyaltyPoints;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public double getLoyaltyPoints() {
		return loyaltyPoints;
	}

	public void setLoyaltyPoints(long loyaltyPoints) {
		this.loyaltyPoints = loyaltyPoints;
	}

}
