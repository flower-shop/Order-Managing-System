public class Flower {
	private double cost;
	private FlowerType type;

	public Flower(FlowerType type) {
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
		// this.color = color;
	}

	public double getCost() {
		return cost;
	}

	public FlowerType getType() {
		return type;
	}

	// public Color getColor() {
	// return color;
	// }

	public void setCost(double cost) {
		this.cost = cost;
	}

	public void setType(FlowerType type) {
		this.type = type;
	}

	// public void setColor(Color color) {
	// this.color = color;
	// }
}
