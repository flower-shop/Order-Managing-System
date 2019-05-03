import java.util.ArrayList;

import dto.AccessoryDTO;
import dto.FlowerDTO;
import enums.AccessoryType;
import enums.ArrangementTheme;
import enums.FlowerType;

public class Arrangement {
	private double cost;
	private ArrangementTheme theme;
	private FlowerType flowerType;
	private int flowerQuantity;
	private ArrayList<FlowerDTO> flowersInArrangement = new ArrayList<>();
	private AccessoryDTO accessory;
	private boolean hasCard = false;
	private String cardText;

	public Arrangement(FlowerType flowerType, int flowerQuantity, ArrangementTheme theme,
			AccessoryType accessoryType, boolean hasCard) {
		this.flowerType = flowerType;
		this.theme = theme;
		this.hasCard = hasCard;
		this.accessory = new AccessoryDTO(accessoryType);

		int count = 0;

		for (FlowerDTO flower : ShopData.getFlowerInventory())
			if (flower.getFlowerType().equals(flowerType)) {
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
		for (FlowerDTO flower : flowersInArrangement) {
			cost += flower.getFlowerCost();
		}
		cost += accessory.getCost();
	}

	public double getCost() {
		return cost;
	}

	public ArrangementTheme getTheme() {
		return theme;
	}

	public ArrayList<FlowerDTO> getFlowersInArrangement() {
		return flowersInArrangement;
	}

	public AccessoryDTO getAccessory() {
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

	public void setFlowersInArrangement(ArrayList<FlowerDTO> flowersInArrangement) {
		this.flowersInArrangement = flowersInArrangement;
	}

	public void setAccessory(AccessoryDTO accessory) {
		this.accessory = accessory;
	}

	public void setHasCard(boolean hasCard) {
		this.hasCard = hasCard;
	}

	public void setCardText(String cardText) {
		this.cardText = cardText;
	}
}
