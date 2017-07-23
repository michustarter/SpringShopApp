package com.capgemini.shop.dataaccess.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "HISTORY")
public class HistoryEntity implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2590219530360537793L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "user_account", nullable = false)
	private UserAccountEntity userAccount;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "product", nullable = false)
	private ProductEntity product;

	@Column(name = "quantity", columnDefinition = "INTEGER DEFAULT 0", nullable = false)
	private int quantity;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public UserAccountEntity getUser() {
		return userAccount;
	}

	public void setUser(UserAccountEntity user) {
		this.userAccount = user;
	}

	public ProductEntity getProduct() {
		return product;
	}

	public void setProduct(ProductEntity product) {
		this.product = product;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	////// hibernate ////
	public HistoryEntity() {

	}
}