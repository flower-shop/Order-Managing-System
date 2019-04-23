import java.util.ArrayList;

public class Arrangement {
	private double cost;
	private ArrangementTheme theme;
	private FlowerType flowerType;
	private int flowerQuantity;
	private ArrayList<Flower> flowersInArrangement = new ArrayList<>();
	private Accessory accessory;
	private boolean hasCard = false;
	private String cardText;

	public Arrangement(FlowerType flowerType, int flowerQuantity, ArrangementTheme theme,
			AccessoryType accessoryType, boolean hasCard) {
		this.flowerType = flowerType;
		this.theme = theme;
		this.hasCard = hasCard;
		this.accessory = new Accessory(accessoryType);

		int count = 0;

		for (Flower flower : ShopData.getFlowerInventory())
			if (flower.getType().equals(flowerType)) {
				flowersInArrangement.add(flower);
				count++;
			}

		if (count == flowerQuantity) {
			calculateCost();
		} else {
			flowersInArrangement.clear();
		}
	}

	public void calculateCost() {
		for (Flower flower : flowersInArrangement) {
			cost += flower.getCost();
		}
		cost += accessory.getCost();
	}

	public double getCost() {
		return cost;
	}

	public ArrangementTheme getTheme() {
		return theme;
	}

	public ArrayList<Flower> getFlowersInArrangement() {
		return flowersInArrangement;
	}

	public Accessory getAccessory() {
		return accessory;
	}

	public boolean hasCard() {
		return hasCard;
	}

	public String getCardText() {
		return cardText;
	}

	public void setCost(double cost) {
		this.cost = cost;
	}

	public void setTheme(ArrangementTheme theme) {
		this.theme = theme;
	}

	public void setFlowersInArrangement(ArrayList<Flower> flowersInArrangement) {
		this.flowersInArrangement = flowersInArrangement;
	}

	public void setAccessory(Accessory accessory) {
		this.accessory = accessory;
	}

	public void setHasCard(boolean hasCard) {
		this.hasCard = hasCard;
	}

	public void setCardText(String cardText) {
		this.cardText = cardText;
	}
}
