package dto;
import java.util.Date;

public class OrderDTO {
	private double totalCost;
	private CustomerDTO customer;
	private FlowerDTO flower;
	private AccessoryDTO accessory;
	private String arrangementTheme;
	private String address;
	private int orderNumber;
	private Date dateOfOrder;
	private Date dateOfDelivery;
	private boolean isDelivered;
	private boolean hasCard;
	private String cardText;
	private boolean isPaidFor;

	public OrderDTO() {

	}

	public double getTotalCost() {
		return totalCost;
	}

	public CustomerDTO getCustomer() {
		return customer;
	}
	
	public FlowerDTO getFlower() {
		return flower;
	}
	
	public AccessoryDTO  getAccessory() {
		return accessory;
	}
	
	public String getArrangementTheme() {
		return arrangementTheme;
	}
	public String getAddress() {
		return address;
	}

	public int getOrderNumber() {
		return orderNumber;
	}

	public Date getDateOfOrder() {
		return dateOfOrder;
	}

	public Date getDateOfDelivery() {
		return dateOfDelivery;
	}

	public boolean isDelivered() {
		return isDelivered;
	}
	
	public boolean hasCard() {
		return hasCard;
	}
	
	public String getCardText() {
		return cardText;
	}

	public boolean isPaidFor() {
		return isPaidFor;
	}

	public void setTotalCost(double totalCost) {
		this.totalCost = totalCost;
	}

	public void setCustomer(CustomerDTO customer) {
		this.customer = customer;
	}
	
	public void setFlower(FlowerDTO flower) {
		this.flower = flower;
	}
	
	public void setAccessory(AccessoryDTO accessory) {
		this.accessory = accessory;
	}
	
	public void setArrangementTheme(String arrangementTheme) {
		this.arrangementTheme = arrangementTheme;
	}
	public void setAddress(String address) {
		this.address = address;
	}

	public void setOrderNumber(int orderNumber) {
		this.orderNumber = orderNumber;
	}

	public void setDateOfOrder(Date dateOfOrder) {
		this.dateOfOrder = dateOfOrder;
	}

	public void setDateOfDelivery(Date dateOfDelivery) {
		this.dateOfDelivery = dateOfDelivery;
	}

	public void isDelivered(boolean hasBeenDelivered) {
		this.isDelivered = hasBeenDelivered;
	}
	
	public void hasCard(boolean orderHasCard) {
		this.hasCard = orderHasCard;
    }
	
	public void setCardText(String orderCardText) {
		this.cardText = orderCardText;
	}

	public void setPaidFor(boolean isPaidFor) {
		this.isPaidFor = isPaidFor;
	}
}
