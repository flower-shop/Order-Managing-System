import java.util.ArrayList;
import java.util.Date;

public class Order {
	private ArrayList<Arrangement> arrangementsInOrder = new ArrayList<>();
	private double totalCost;
	private Customer customer;
	private int orderNumber;
	private Date dateOfOrder;
	private Date dateOfDelivery;
	private boolean isDelivered;
	private boolean isPaidFor;

	public Order() {

	}

	public ArrayList<Arrangement> getArrangementsInOrder() {
		return arrangementsInOrder;
	}

	public double getTotalCost() {
		return totalCost;
	}

	public Customer getCustomer() {
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

	public void setArrangementsInOrder(ArrayList<Arrangement> arrangementsInOrder) {
		this.arrangementsInOrder = arrangementsInOrder;
	}

	public void setTotalCost(double totalCost) {
		this.totalCost = totalCost;
	}

	public void setCustomer(Customer customer) {
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
