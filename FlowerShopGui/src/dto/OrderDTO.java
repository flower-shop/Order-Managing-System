package dto;
import java.util.Date;

public class OrderDTO {
	private Date dateOfOrder;
	private String firstName;
	private String lastName;
	private String flowerType;
	private int flowerQty;
	private String accessory;
	private String arrangementType;
	private String address;
	private Date deliveryDate;
	private double totalCost;
	private String hasCard;
	private String cardText;
	private String isPaidFor;
	private String isDelivered;
	private int orderNumber;

	public OrderDTO(Date dateOfOrder, String firstName, String lastName, String flowerType, int flowerQty,
			String accessory, String arrangementType, String address, Date deliveryDate, double totalCost,
			String hasCard, String cardText, String isPaidFor, String isDelivered, int orderNumber) {

		this.dateOfOrder = dateOfOrder;
		this.firstName = firstName;
		this.lastName = lastName;
		this.flowerType = flowerType;
		this.flowerQty = flowerQty;
		this.accessory = accessory;
		this.arrangementType = arrangementType;
		this.address = address;
		this.deliveryDate = deliveryDate;
		this.totalCost = totalCost;
		this.hasCard = hasCard;
		this.cardText = cardText;
		this.isPaidFor = isPaidFor;
		this.isDelivered = isDelivered;
		this.orderNumber = orderNumber;
	}

	public Date getDateOfOrder() {
		return dateOfOrder;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public String getFlowerType() {
		return flowerType;
	}

	public int getFlowerQty() {
		return flowerQty;
	}

	public String getAccessory() {
		return accessory;
	}

	public String getArrangementType() {
		return arrangementType;
	}

	public String getAddress() {
		return address;
	}

	public Date getDeliveryDate() {
		return deliveryDate;
	}

	public double getTotalCost() {
		return totalCost;
	}

	public String getHasCard() {
		return hasCard;
	}

	public String getCardText() {
		return cardText;
	}

	public String getIsPaidFor() {
		return isPaidFor;
	}

	public String getIsDelivered() {
		return isDelivered;
	}

	public int getOrderNumber() {
		return orderNumber;
	}

	public void setDateOfOrder(Date dateOfOrder) {
		this.dateOfOrder = dateOfOrder;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public void setFlowerType(String flowerType) {
		this.flowerType = flowerType;
	}

	public void setFlowerQty(int flowerQty) {
		this.flowerQty = flowerQty;
	}

	public void setAccessory(String accessory) {
		this.accessory = accessory;
	}

	public void setArrangementType(String arrangementType) {
		this.arrangementType = arrangementType;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public void setDeliveryDate(Date deliveryDate) {
		this.deliveryDate = deliveryDate;
	}

	public void setTotalCost(double totalCost) {
		this.totalCost = totalCost;
	}

	public void setHasCard(String hasCard) {
		this.hasCard = hasCard;
	}

	public void setCardText(String cardText) {
		this.cardText = cardText;
	}

	public void setIsPaidFor(String isPaidFor) {
		this.isPaidFor = isPaidFor;
	}

	public void setIsDelivered(String isDelivered) {
		this.isDelivered = isDelivered;
	}

	public void setOrderNumber(int orderNumber) {
		this.orderNumber = orderNumber;
	}
}
