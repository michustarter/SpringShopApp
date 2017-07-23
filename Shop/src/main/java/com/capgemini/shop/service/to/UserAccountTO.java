package com.capgemini.shop.service.to;

/**
 * @author RWEYCHAN Transport object for user profile data - getters and setters
 */
public class UserAccountTO {

	public UserAccountTO() {

	}

	private long id;
	private String login;
	private String name;
	private String surname;
	private int discount;

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public int getDiscount() {
		return discount;
	}

	public void setDiscount(int discount) {
		this.discount = discount;
	}

	public long getId() {
		return id;
	}

	public UserAccountTO(String login, String name, String surname, int discount) {
		super();
		this.login = login;
		this.name = name;
		this.surname = surname;
		this.discount = discount;
	}

}
