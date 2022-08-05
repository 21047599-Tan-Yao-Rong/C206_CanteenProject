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
	
// creating ingrediant orderList arraylist
	private ArrayList<Order> IngrediantOrderList = new ArrayList<Order>();
	
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
		
		menuList.add(new Menu(001, "S1", "Chicken Rice",5));
		menuList.add(new Menu(002,"S2", "Bolognese Spaghetti",3));
		menuList.add(new Menu(003, "S3", "Fish and Chips",5));
		menuList.add(new Menu(004, "S4", "Kimchi Fried Rice",6));
		menuList.add(new Menu(005,"S5", "Soda Drinks",3));
	}
	
	private void CustomerMenu()
	{
		
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
	private void CanteenAdminFoodMenu() { 
		Helper.line(50, "=");
		System.out.println("Option 1: View all food items");
		System.out.println("Option 1: Add new food items");
		System.out.println("Option 1: Delete food item");
		System.out.println("Option 1: Change food items price");
		Helper.line(50, "=");
	}
	private void StallOperatorMenu() { 
		Helper.line(50, "=");
		System.out.println("Option 1: View all Ingrediant Orders");
		System.out.println("Option 2: Add new Ingrediant Order");
		System.out.println("Option 3: Delete Ingrediant Order");
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
	/*private void start() { 
		CanteenAdminFoodMenu();
		int option = Helper.readInt("Enter option number > ");
		while(option != 5) { 
			if (option == 1) {
				viewMenu();
			}
			else if (option == 2) {
				addFoodItem();
			}
			else if(option == 3) {
				deleteFoodItem();
			}
			else if(option == 4) {
				changePrice();
			}
			else {
				System.out.println("Invaild option");
			}
			CanteenAdminFoodMenu();
			option = Helper.readInt("Enter option number > ");
		}
	}*/
	
//  CUSTOMER CODE====================================================================
	
//	private void cutomerStart() { 
//		CanteenAdminFoodMenu();
//		int option = Helper.readInt("Enter option number > ");
//		while(option != 5) { 
//			if (option == 1) {
//				viewStalls();
//			}
//			else if (option == 2) {
//				viewMenu();
//			}
//			else if(option == 3) {
//				deleteFoodItem();
//			}
//			else if(option == 4) {
//				changePrice();
//			}
//			else {
//				System.out.println("Invaild option");
//			}
//			CanteenAdminFoodMenu();
//			option = Helper.readInt("Enter option number > ");
//		}
//		System.out.println("Bye");
//	}
	
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
	
	private String addOrder()
	{
		boolean isAdd = false;
		String Message = "Order was not added successfully.";
		int foodNumber = Helper.readInt("Enter food");
		
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
	
//  end of customer code =============================================================================	
	
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
		viewMenu(); 
		int foodNum = Helper.readInt("Enter food number to delete > ");
		for (int i = 0; i < menuList.size(); i++) { 
			if (i == foodNum) { 
				menuList.remove(foodNum);
			}
		}
	}
	
	
	private void changePrice() { 
		viewMenu();
		int foodNum = Helper.readInt("Enter food number to change price > ");
		int newPrice = Helper.readInt("Enter new price for food item > ");
		for (int i = 0; i < menuList.size(); i++) { 
			if (i == foodNum || newPrice < 15 || newPrice > 3) { 
				menuList.get(foodNum).setPrice(newPrice);
				System.out.println("Price successfully updated.");
			}
		}
	}
	
//Stall operator Code-----------------------------------------------------------------------------------------------

/*private void start() { 
StallOperatorMenu()
int option = Helper.readInt("Enter option number > ");
while(option != 5) { 
	if (option == 1) {
		viewIngrediantOrder()
	}
	else if (option == 2) {
		AddIngredientOrder()
	}
	else if(option == 3) {
		DeleteIngrediantOrder()
	}
	else if(option == 4) {
		
	}
	else {
		System.out.println("Invaild option");
	}
	StallOperatorMenu()
	option = Helper.readInt("Enter option number > ");
}
}*/
	private String AddIngredientOrder()
	{
		boolean isAdd = false;
		String Message = "Order was not added successfully.";
		int IngrediantAmount = Helper.readInt("Enter amount of ingrediant");
		String Name = Helper.readString("Enter ingrediant Name");
		double getPrice = Helper.readDouble("Enter ingrediant price");
			orderList.add(new Order(IngrediantAmount, Name, getPrice));
				isAdd = true;
			
		
		
		if(isAdd == true)
		{
			Message = "Order was added successfully.";
		}
		
		return Message;
		
	}
	private void viewIngrediantOrder()
	{
		String output = "";
		output += String.format("%-20s%-20s%s\n", "ORDER NUMBER", "INGREDIANT NAME", "ORDER PRICE");
		for(int i =0;i<10; i++) {
			if (IngrediantOrderList.get(i) != null) {
				output += String.format("%-20s%-20s%s\n", IngrediantOrderList.get(i).getNumber(), IngrediantOrderList.get(i).getName(), IngrediantOrderList.get(i).getPrice());
			}

		}
		System.out.println(output);
	}
	private String deleteIngrediantOrder() {
		
		viewIngrediantOrder();
		boolean isDeleted = false;
		String Message = "Order was not deleted.";
		int OrderID = Helper.readInt("Enter ID of Order to delete > ");
		for(int i = 0;i<10;i++) {
			if ((IngrediantOrderList.get(i) != null) && (IngrediantOrderList.get(i).getNumber() == OrderID)) 
			{
				IngrediantOrderList.remove(i);
				isDeleted = true;
			}
		}
		if(isDeleted == true)
		{
			Message = "Order was deleted successfully.";
		}
		
		return Message;
	}
	
}
