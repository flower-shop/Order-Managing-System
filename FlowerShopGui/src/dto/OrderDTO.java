package dto;
import java.util.Date;

public class OrderDTO {
	private int orderNumber;
	private double totalCost;
	private String phoneNumber;
	private String flowerType;
	private String address;
	private Date dateOfOrder;
	private Date dateOfDelivery;
	private String isDelivered;
	private String cardText;
	private String isPaidFor;

	public OrderDTO(int orderNumber, double totalCost, String phoneNumber, String flowerType, 
			String address, Date dateOfOrder, Date dateOfDelivery, String isDelivered, String cardText, 
			String isPaidFor) {
		this.orderNumber = orderNumber;
		this.totalCost = totalCost;
		this.phoneNumber = phoneNumber;
		this.flowerType = flowerType;
		this.address = address;
		this.dateOfOrder = dateOfOrder;
		this.dateOfDelivery = dateOfDelivery;
		this.isDelivered = isDelivered;
		this.cardText = cardText;
		this.isPaidFor = isPaidFor;
	}
	
	public int getOrderNumber() {
		return orderNumber;
	}
	
	public double getTotalCost() {
		return totalCost;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}
	
	public String getFlowerType() {
		return flowerType;
	}
	
	/*public AccessoryDTO  getAccessory() {
		return accessory;
	}
	
	public String getArrangementTheme() {
		return arrangementTheme;
	}*/
	public String getAddress() {
		return address;
	}

	

	public Date getDateOfOrder() {
		return dateOfOrder;
	}

	public Date getDateOfDelivery() {
		return dateOfDelivery;
	}

	public String getIsDelivered() {
		return isDelivered;
	}
	
	public String getCardText() {
		return cardText;
	}

	public String getIsPaidFor() {
		return isPaidFor;
	}
	public void setOrderNumber(int orderNumber) {
		this.orderNumber = orderNumber;
	}

	public void setTotalCost(double totalCost) {
		this.totalCost = totalCost;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	
	public void setFlowerType(String flowerType) {
		this.flowerType = flowerType;
	}
	
	/*public void setAccessory(AccessoryDTO accessory) {
		this.accessory = accessory;
	}
	
	public void setArrangementTheme(String arrangementTheme) {
		this.arrangementTheme = arrangementTheme;
	}*/
	public void setAddress(String address) {
		this.address = address;
	}

	public void setDateOfOrder(Date dateOfOrder) {
		this.dateOfOrder = dateOfOrder;
	}

	public void setDateOfDelivery(Date dateOfDelivery) {
		this.dateOfDelivery = dateOfDelivery;
	}

	public void setisDelivered(String isDelivered) {
		this.isDelivered = isDelivered;
	}
	
	public void setCardText(String orderCardText) {
		this.cardText = orderCardText;
	}

	public void setPaidFor(String isPaidFor) {
		this.isPaidFor = isPaidFor;
	}
}
