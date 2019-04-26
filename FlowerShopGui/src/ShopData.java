import java.util.ArrayList;

import dto.AccessoryDTO;
import dto.CustomerDTO;
import dto.EmployeeDTO;
import dto.FlowerDTO;

public class ShopData {
	private static ArrayList<EmployeeDTO> employees = new ArrayList<>();
	private static ArrayList<FlowerDTO> flowerInventory = new ArrayList<>();
	private static ArrayList<AccessoryDTO> accessoryInventory = new ArrayList<>();
	private static ArrayList<CustomerDTO> customers = new ArrayList<>();

	public static ArrayList<EmployeeDTO> getEmployees() {
		return employees;
	}

	public static ArrayList<FlowerDTO> getFlowerInventory() {
		return flowerInventory;
	}

	public static ArrayList<AccessoryDTO> getAccessoryInventory() {
		return accessoryInventory;
	}

	public static ArrayList<CustomerDTO> getCustomers() {
		return customers;
	}
}
