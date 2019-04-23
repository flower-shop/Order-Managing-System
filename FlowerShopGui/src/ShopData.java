import java.util.ArrayList;

public class ShopData {
	private static ArrayList<Employee> employees = new ArrayList<>();
	private static ArrayList<Flower> flowerInventory = new ArrayList<>();
	private static ArrayList<Accessory> accessoryInventory = new ArrayList<>();
	private static ArrayList<Customer> customers = new ArrayList<>();

	public static ArrayList<Employee> getEmployees() {
		return employees;
	}

	public static ArrayList<Flower> getFlowerInventory() {
		return flowerInventory;
	}

	public static ArrayList<Accessory> getAccessoryInventory() {
		return accessoryInventory;
	}

	public static ArrayList<Customer> getCustomers() {
		return customers;
	}
}
