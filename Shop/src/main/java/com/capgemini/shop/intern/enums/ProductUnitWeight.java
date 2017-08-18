package com.capgemini.shop.intern.enums;

public enum ProductUnitWeight {
	M3(10, "m3"), LITER(6, "liter"), KG(4, "kg"), PIECE(14, "piece");

	private int weight;
	private String unit;

	ProductUnitWeight(int weight, String unit) {
		this.weight = weight;
		this.unit = unit;
	}

	public int getWeight() {
		return weight;
	}

	public String getUnit() {
		return unit;
	}
}
