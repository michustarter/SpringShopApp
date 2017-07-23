package com.capgemini.shop.dataaccess.entities;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "USER_ACCOUNT")
public class UserAccountEntity implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2590219530360537793L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	@Column(name = "login", columnDefinition = "VARCHAR(45) DEFAULT ''", nullable = false, unique = true, length = 20)
	private String login;

	@Column(name = "name", columnDefinition = "VARCHAR(45) DEFAULT ''", nullable = true, length = 20)
	private String name;

	@Column(name = "surname", columnDefinition = "VARCHAR(45) DEFAULT ''", nullable = true, length = 20)
	private String surname;

	@Column(name = "discount", columnDefinition = "INTEGER DEFAULT 0", nullable = false)
	private int discount;

	@OneToMany(targetEntity = HistoryEntity.class, mappedBy = "userAccount", cascade = CascadeType.ALL)
	private Set<HistoryEntity> boughtItems = new HashSet<HistoryEntity>();

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

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

	public Set<HistoryEntity> getBoughtItems() {
		return boughtItems;
	}

	public void setBoughtItems(Set<HistoryEntity> boughtItems) {
		this.boughtItems = boughtItems;
	}

	////// hibernate ////
	public UserAccountEntity() {

	}

}