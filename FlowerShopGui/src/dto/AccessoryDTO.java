package dto;

public class AccessoryDTO {
	private double cost;
	private AccessoryType type;

	public AccessoryDTO(AccessoryType type) {
		this.type = type;

		switch (type) {
		case Vase:
			this.cost = 5.00;
			break;
		case Wreath:
			this.cost = 8.00;
			break;
		case Bouquet:
			this.cost = 4.00;
			break;
		case None:
			break;
		default:
			break;
		}
	}

	public double getCost() {
		return cost;
	}

	public AccessoryType getType() {
		return type;
	}

	public void setCost(double cost) {
		this.cost = cost;
	}

	public void setType(AccessoryType type) {
		this.type = type;
	}
}
