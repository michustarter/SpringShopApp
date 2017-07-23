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
@Table(name = "PRODUCT")
public class ProductEntity implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2590219530360537793L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	@Column(name = "name", columnDefinition = "VARCHAR(45) DEFAULT ''", nullable = false, length = 45)
	private String name;

	@Column(name = "price", columnDefinition = "INTEGER DEFAULT 0", nullable = false)
	private int price;

	@Column(name = "unit", columnDefinition = "VARCHAR(45) DEFAULT ''", nullable = false, length = 45)
	private String unit;

	@OneToMany(targetEntity = HistoryEntity.class, mappedBy = "product", cascade = CascadeType.ALL)
	private Set<HistoryEntity> purchaseHistory = new HashSet<HistoryEntity>();

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public String getUnit() {
		return unit;
	}

	public void setUnit(String unit) {
		this.unit = unit;
	}

	public Set<HistoryEntity> getPurchaseHistory() {
		return purchaseHistory;
	}

	public void setPurchaseHistory(Set<HistoryEntity> purchaseHistory) {
		this.purchaseHistory = purchaseHistory;
	}

	////// hibernate ////
	public ProductEntity() {

	}
}