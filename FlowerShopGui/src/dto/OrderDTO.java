package dto;
import java.util.Date;

public class OrderDTO {
	private double totalCost;
	private CustomerDTO customer;
	private int orderNumber;
	private Date dateOfOrder;
	private Date dateOfDelivery;
	private boolean isDelivered;
	private boolean isPaidFor;

	public OrderDTO() {

	}

	public double getTotalCost() {
		return totalCost;
	}

	public CustomerDTO getCustomer() {
		return customer;
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

	public boolean isPaidFor() {
		return isPaidFor;
	}

	public void setTotalCost(double totalCost) {
		this.totalCost = totalCost;
	}

	public void setCustomer(CustomerDTO customer) {
		this.customer = customer;
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

	public void setPaidFor(boolean isPaidFor) {
		this.isPaidFor = isPaidFor;
	}
}
