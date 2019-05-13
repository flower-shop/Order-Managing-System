package dto;

/*
 * File: FLowerDTO.java
 * Date: May 12, 2019
 * Authors: Olga Samborski, Jasmine Jones, Scott Hussey, and James DeBenedictis
 */

public class FlowerDTO {
	private double flowerCost;
	private String flowerType;
	private int flowerQty;

	public FlowerDTO(String flowerType, double flowerCost, int flowerQty) {
		this.flowerType = flowerType;
		this.flowerCost = flowerCost;
		this.flowerQty = flowerQty;
	}

	public double getFlowerCost() {
		return flowerCost;
	}

	public String getFlowerType() {
		return flowerType;
	}

	public int getFlowerQty() {
		return flowerQty;
	}

	public void setFlowerCost(double flowerCost) {
		this.flowerCost = flowerCost;
	}

	public void setFlowerType(String flowerType) {
		this.flowerType = flowerType;
	}

	public void setFlowerQuantity(int flowerQty) {
		this.flowerQty = flowerQty;
	}
}
