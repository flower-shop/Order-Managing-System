package dto;

public class OrderDTO {
	private int orderNumber;
	private String orderDate;
	private String firstName;
	private String lastName;
	private String phoneNumber;
	private String email;
	private String flowerType;
	private int flowerQty;
	private String accessoryType;
	private String arrangementTheme;
	private String address;
	private String deliveryDate;
	private double totalCost;
	private String hasCard;
	private String cardText;
	private String isPaidFor;
	private String isDelivered;

	public OrderDTO(int orderNumber, String orderDate, String firstName, String lastName, String phoneNumber,
			String email, String flowerType, int flowerQty, String accessoryType, String arrangementTheme, String address,
			String deliveryDate, double totalCost, String hasCard, String cardText, String isPaidFor,
			String isDelivered) {

		this.orderNumber = orderNumber;
		this.orderDate = orderDate;
		this.firstName = firstName;
		this.lastName = lastName;
		this.phoneNumber = phoneNumber;
		this.email = email;
		this.flowerType = flowerType;
		this.flowerQty = flowerQty;
		this.accessoryType = accessoryType;
		this.arrangementTheme = arrangementTheme;
		this.address = address;
		this.deliveryDate = deliveryDate;
		this.totalCost = totalCost;
		this.hasCard = hasCard;
		this.cardText = cardText;
		this.isPaidFor = isPaidFor;
		this.isDelivered = isDelivered;
	}
	public int getOrderNumber() {
		return orderNumber;
	}
	public String getOrderDate() {
		return orderDate;
	}
	public String getFirstName() {
		return firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public String getEmail() {
		return email;
	}
	public String getFlowerType() {
		return flowerType;
	}
	public int getFlowerQty() {
		return flowerQty;
	}
	public String getAccessoryType() {
		return accessoryType;
	}
	public String getArrangementTheme() {
		return arrangementTheme;
	}
	public String getAddress() {
		return address;
	}
	public String getDeliveryDate() {
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
	public void setOrderNumber(int orderNumber) {
		this.orderNumber = orderNumber;
	}
	public void setOrderDate(String orderDate) {
		this.orderDate = orderDate;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public void setFlowerType(String flowerType) {
		this.flowerType = flowerType;
	}
	public void setFlowerQty(int flowerQty) {
		this.flowerQty = flowerQty;
	}
	public void setAccessory(String accessory) {
		this.accessoryType = accessory;
	}
	public void setArrangementType(String arrangementType) {
		this.arrangementTheme = arrangementType;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public void setDeliveryDate(String deliveryDate) {
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
}
