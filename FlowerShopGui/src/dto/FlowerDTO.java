package dto;

import enums.FlowerType;

public class FlowerDTO {
	private double cost;
	private FlowerType type;
	private int flowerQuantity;

	public FlowerDTO(FlowerType type) {
		this.type = type;

		switch (type) {
			case Tulip :
				cost = 2.00;
				break;
			case Rose :
				cost = 2.50;
				break;
			case Gardenia :
				cost = 1.00;
				break;
			default :
				break;
		}
	}

	public double getCost() {
		return cost;
	}

	public FlowerType getType() {
		return type;
	}

	public int getFlowerQuantity() {
		return flowerQuantity;
	}

	public void setCost(double cost) {
		this.cost = cost;
	}

	public void setType(FlowerType type) {
		this.type = type;
	}

	public void setFlowerQuantity(int flowerQuantity) {
		this.flowerQuantity = flowerQuantity;
	}
}
