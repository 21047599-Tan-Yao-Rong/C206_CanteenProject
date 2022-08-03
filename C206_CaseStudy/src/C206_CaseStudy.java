import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class C206_CaseStudy {
	
//	creating the stallList arraylist 
	// private ArrayList<Stall> stallList = new ArrayList<Stall>();
	private Stall[] StallList = new Stall[10];
	
//  creating the menuList arrayist
	private ArrayList<Menu> menuList = new ArrayList<Menu>();
	
//	creating the orderList arraylist
	private ArrayList<Order> orderList = new ArrayList<Order>();
	
	public static void main(String[] args) 
	{
		C206_CaseStudy Cs = new C206_CaseStudy();
		Cs.loadStallList();
		Cs.loadMenuList();
		Cs.start();
	}
	
	private void loadStallList()
	{
		StallList[0] = new Stall("S1", "Drink Store", LocalDate.of(2017, 4, 15));
		//stallList.add(new Stall("S1", "Drink Store", LocalDate.of(2017, 4, 15)));
		//stallList.add(new Stall("S2", "Chicken Rice Store", LocalDate.of(2018, 5, 18)));
		//stallList.add(new Stall("S3", "Western Cuisine", LocalDate.of(2022, 12, 12)));
		//stallList.add(new Stall("S4", "Japanese Cuisine", LocalDate.of(2023, 7, 13)));
		//stallList.add(new Stall("S5", "Korean Cuisine", LocalDate.of(2016, 8, 14)));
	}
	
	private void loadMenuList() {
		
		menuList.add(new Menu(001,"Chicken Rice",3));
		menuList.add(new Menu(002,"Bolognese Spaghetti",2));
		menuList.add(new Menu(003,"Fish and Chips",3));
		menuList.add(new Menu(004,"Kimchi Fried Rice",4));
		menuList.add(new Menu(005,"Soda Drinks",2));
	}
	
	private void CanteenAdminMenu() {
		Helper.line(50, "=");
		System.out.println("Option 1: View all stalls");
		System.out.println("Option 2: Add new stalls");
		System.out.println("Option 3: Change stall information");
		System.out.println("Option 4: Remove Stall");
		System.out.println("Option 5: Quit");
		Helper.line(50, "=");
	}
	
	
	private void start()
	{
		CanteenAdminMenu();
		int option = Helper.readInt("Enter your option > ");
		while(option != 5) {
			if (option == 1) {
				viewStalls();
			}
			else if (option == 2) {
				addNewStalls();
			}
			else if(option == 3) {
				changeStall();
			}
			else if(option == 4) {
				deleteStall();
			}
			else {
				System.out.println("Invaild option");
			}
			CanteenAdminMenu();
			option = Helper.readInt("Enter your option > ");
		}
		
		
		
		System.out.println("Bye bye");
		
	}
	
//  CUSTOMER CODE====================================================================
	
	private void viewStalls()
	{
		String output = "";
		output += String.format("%-20s%-20s%s\n", "STALL ID", "STALL NAME", "OPERATION DATE");
		for(int i =0;i<10; i++) {
			if (StallList[i] != null) {
				output += String.format("%-20s%-20s%s\n", StallList[i].getID(), StallList[i].getName(), StallList[i].getOperationDate());
			}

		}
		System.out.println(output);
	}
	
	private void addNewStalls() {
		
		boolean stallAdded = false;
		
		for(int i = 0;i<10;i++) {
			if (StallList[i] == null) {
				String newStall = Helper.readString("Enter name of new stall > ");
				String operationDate = Helper.readString("Enter operation date of new stall (dd/MM/yyyy) > ");
				DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
				LocalDate date = LocalDate.parse(operationDate, formatter);
				StallList[i] = new Stall("S" + (i+1), newStall, date);
				stallAdded = true;
				System.out.println(newStall + " has sucessfully been added");
				break;
			}
		}
		if (stallAdded == false) {
			System.out.println("The canteen is full!");
		}
	}
	
	private void changeStall() {
		viewStalls();
		String stallID = Helper.readString("Enter ID of stall to change information > ");
		for(int i = 0;i<10;i++) {
			if ((StallList[i] != null) && (StallList[i].getID().equalsIgnoreCase(stallID))) {
				Helper.line(50, "=");
				System.out.println("Option 1: Change name of store");
				System.out.println("Option 2: Change Operation date");
				Helper.line(50, "=");
				int option = Helper.readInt("Enter your option > ");

					if (option == 1) {
						String newName = Helper.readString("Enter new name of stall > ");
						StallList[i].changeName(newName);

					}
					else if (option == 2) {
						String operationDate = Helper.readString("Enter new operation date of stall (dd/MM/yyyy) > ");
						DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
						LocalDate date = LocalDate.parse(operationDate, formatter);
						StallList[i].changeOperationDate(date);

					}
			}
		}

	}
	
	private void deleteStall() {
		viewStalls();
		String stallID = Helper.readString("Enter ID of stall to delete > ");
		for(int i = 0;i<10;i++) {
			if ((StallList[i] != null) && (StallList[i].getID().equalsIgnoreCase(stallID))) {
				StallList[i] = null;
			}
		}
	}
	
	private void viewMenu()
	{
		String output = "";
		output += String.format("%-20s%-20s%s\n", "FOOD NUMBER", "NAME", "PRICE");
		for(Menu M : menuList)
		{
			output += String.format("%-20s%-20s%.2f\n", M.getNumber(), M.getName(), M.getPrice());
		}
		System.out.println(output);
	}
	private void addFoodItem() { 
		boolean foodAdded = false;
		
		for(int i = 0; i < menuList.size(); i++) {
			if (menuList.get(i) == null) {
				String newFoodItem = Helper.readString("Enter name of new food item > ");
				int price = Helper.readInt("Enter price of new food item > ");
				menuList.add(new Menu(i+1, newFoodItem, price));
				foodAdded = true;
				System.out.println(newFoodItem + " has sucessfully been added");
				break;
			}
		}
		if (foodAdded == false) {
			System.out.println("Food Item is not added!");
		}
	}
	private void deleteFoodItem() {
		
	}
	private String addOrder(int foodNumber)
	{
		boolean isAdd = false;
		String Message = "Order was not added successfully.";
		
		for(Menu M : menuList)
		{
			if(M.getNumber() == foodNumber)
			{
				orderList.add(new Order(foodNumber, M.getName(), M.getPrice()));
				isAdd = true;
			}
		}
		
		if(isAdd == true)
		{
			Message = "Order was added successfully.";
		}
		
		return Message;
	}
	
	private String deleteOrder(int foodNumber)
	{
		boolean isDeleted = false;
		String Message = "Order was not deleted.";
		
		for(int O = 0;O < orderList.size();O++)
		{
			if(orderList.get(O).getNumber() == foodNumber)
			{
				orderList.remove(O);
				isDeleted = true;
			}
		}
		
		if(isDeleted == true)
		{
			Message = "Order was deleted successfully.";
		}
		
		return Message;
	}
	
	private void viewOrders()
	{
		String output = "";
		output += String.format("%-20s%-20s%s\n", "No.", "NAME", "PRICE");
		for(int i = 0;i < orderList.size();i++)
		{
			output += String.format("%-20d%-20s%.2f\n", i, orderList.get(i).getName(), orderList.get(i).getPrice());
		}
		System.out.println(output);
	}
	
	private void placeOrder()
	{
		
	}
	
}
