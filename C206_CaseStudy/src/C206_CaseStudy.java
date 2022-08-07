import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class C206_CaseStudy {
	
//	creating the stallList arraylist 
	// private ArrayList<Stall> stallList = new ArrayList<Stall>();
	private Stall[] StallList = new Stall[10];
	
//  creating the menuList arrayist
	private ArrayList<Menu> menuList = new ArrayList<Menu>();
	
// creating ingrediant orderList arraylist
	private ArrayList<Order> IngrediantOrderList = new ArrayList<Order>();

//  creating cart to add orders into for customer
	private ArrayList<Cart> cart = new ArrayList<Cart>();
	
	public static void main(String[] args) 
	{
		C206_CaseStudy Cs = new C206_CaseStudy();
		Cs.loadStallList();
		Cs.loadMenuList();
		// Cs.cutomerStart();
		Cs.loadOrders();
		Cs.start();
	}
	
	public static void setHeader(String header) {
		Helper.line(80, "-");
		System.out.println(header);
		Helper.line(80, "-");
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
	private void loadIngrediantOrders() 
	{
		IngrediantOrderList.add(new Order(1,"Chicken",20));
	}
	
	private void loadOrders() {
		cart.add(new Cart(001,"Chicken Rice",5));
		cart.add(new Cart(002,"chicken cultlet",6));
	}
	
	private void loadMenuList() {
		
		menuList.add(new Menu(001,"S1", "Chicken Rice",5));
		menuList.add(new Menu(002,"S2", "Bolognese Spaghetti",3));

	
	private void CustomerMenu()
	{
		Helper.line(50, "=");
		System.out.println("Option 1: View all stalls");
		System.out.println("Option 2: View Menu");
		System.out.println("Option 3: Add orders");
		System.out.println("Option 4: View orders ");
		System.out.println("Option 5: Delete orders ");
		System.out.println("Option 6: Quit");
		Helper.line(50, "=");
	}
	
	private void CanteenAdminMenu() {
		Helper.line(50, "=");
		System.out.println("Option 1: View all stalls");
		System.out.println("Option 2: Add new stalls");
		System.out.println("Option 3: Remove Stall");
		System.out.println("Option 4: Quit");
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
		while(option != 4) {
			if (option == 1) {
				C206_CaseStudy.viewStalls(StallList);
			}
			else if (option == 2) {
				Stall newStall = inputStall();
				C206_CaseStudy.addNewStalls(StallList, newStall);
			}
			else if(option == 3) {
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
//		CustomerMenu();
//		int option = Helper.readInt("Enter option number > ");
//		while(option != 6) 
//		{ 
//			if (option == 1) 
//			{
//				viewStalls();
//			}
//			else if (option == 2) 
//			{
//				viewMenu();
//			}
//			else if(option == 3) 
//			{
//				Cart orders = inputOrder();
//				C206_CaseStudy.addOrder(cart, orders);
//			}
//			else if(option == 4) 
//			{
//				C206_CaseStudy.viewAllOrders(cart);
//			}
//			else if(option == 5) 
//			{
//				int FoodNumber = inputFoodNumber();
//				C206_CaseStudy.deleteOrder(cart, FoodNumber);
//			}
//			else {
//				System.out.println("Invaild option");	
//			}
//			CustomerMenu();
//			option = Helper.readInt("Enter option number > ");
//		}
//		System.out.println("Bye");
//	}
	
	private void viewMenu()
	{
		String ID = Helper.readString("Enter the stall ID > ");
		String output = "";
		output += String.format("%-20s%-20s%s\n", "FOOD NUMBER", "NAME", "PRICE");
		for(Menu M : menuList)
		{
			if(ID.equals(M.getStallID()))
			{
				output += String.format("%-20s%-20s%d\n", M.getNumber(), M.getName(), M.getPrice());
			}
			
		}
		
		System.out.println(output);
	}
	
	public static Cart inputOrder() {
		int foodNumber = Helper.readInt("Enter food Number > ");
		String name = Helper.readString("Enter name > ");
		int price = Helper.readInt("Enter price > ");
		
		
		Cart order = new Cart(foodNumber, name, price);
		return order;
	}
	
	public static void addOrder(ArrayList<Cart> cart, Cart order) {
		cart.add(order);
		System.out.println("Order added.");
	}
	
	
	public static int inputFoodNumber() {
		int foodNumber = Helper.readInt("Enter the food Number you want to delete > ");
		
		return foodNumber;
	}
	
	public static void deleteOrder(ArrayList<Cart> cart, int foodNumber) {
		for (int i = 0; i < cart.size(); i++) 
		{
			if(cart.get(i).getNumber() == foodNumber)
			{
				cart.remove(i);
			}
		}
		System.out.println("Order delete.");
	}
	
	
	public static String retrieveAllOrders(ArrayList<Cart> cart)
	{
		String output = "";
		
		for (int i = 0; i < cart.size(); i++) 
		{
			output += String.format("%-10d %-20s %-20d\n", i + 1, cart.get(i).getName(), cart.get(i).getPrice());
		}
		
		return output;
	}
	
	public static void viewAllOrders(ArrayList<Cart> cart) {
		C206_CaseStudy.setHeader("ORDER LIST");
		String output = String.format("%-10s %-20s %-20s\n", "No.", "NAME", "PRICE");
		 output += retrieveAllOrders(cart);	
		System.out.println(output);
	}
	
	
	
//  end of customer code =============================================================================	
	
	public static String retrieveAllStalls(Stall[] StallList) {
		String output = "";
		
		for(int i =0;i<10; i++) {
			if (StallList[i] != null) {
				output += String.format("%-20s%-20s%s\n", StallList[i].getID(), StallList[i].getName(), StallList[i].getOperationDate());
			}
		}
		return output;
		
	}
	
	private static void viewStalls(Stall[] StallList)
	{
		String output = String.format("%-20s%-20s%s\n", "STALL ID", "STALL NAME", "OPERATION DATE");
		output += retrieveAllStalls(StallList);
		System.out.println(output);
	}
	
	public static Stall inputStall() {
		String StallID = Helper.readString("Enter ID of new stall > ");
		String StallName = Helper.readString("Enter name of new stall > ");
		String operationDate = Helper.readString("Enter operation date of new stall (dd/MM/yyyy) > ");
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		LocalDate date = LocalDate.parse(operationDate, formatter);
		Stall newStall = new Stall(StallID, StallName, date);
		
		return newStall;
	}
	
	public static void addNewStalls(Stall[] StallList, Stall newStall) {
		
		boolean stallAdded = false;
		
		for(int i = 0;i<10;i++) {
			if (StallList[i] == null) {
				
				StallList[i] = newStall;
				
				stallAdded = true;
				System.out.println(newStall.getName() + " has sucessfully been added");
				break;
			}
		}
		if (stallAdded == false) {
			System.out.println("The canteen is full!");
		}
	}
	
	
	
//	private void changeStall() {
//		viewStalls();
//		String stallID = Helper.readString("Enter ID of stall to change information > ");
//		for(int i = 0;i<10;i++) {
//			if ((StallList[i] != null) && (StallList[i].getID().equalsIgnoreCase(stallID))) {
//				Helper.line(50, "=");
//				System.out.println("Option 1: Change name of store");
//				System.out.println("Option 2: Change Operation date");
//				Helper.line(50, "=");
//				int option = Helper.readInt("Enter your option > ");
//
//					if (option == 1) {
//						String newName = Helper.readString("Enter new name of stall > ");
//						StallList[i].changeName(newName);
//
//					}
//					else if (option == 2) {
//						String operationDate = Helper.readString("Enter new operation date of stall (dd/MM/yyyy) > ");
//						DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
//						LocalDate date = LocalDate.parse(operationDate, formatter);
//						StallList[i].changeOperationDate(date);
//
//					}
//			}
//		}
//
//	}
	
	private void deleteStall() {
		viewStalls();
		String stallID = Helper.readString("Enter ID of stall to delete > ");
		for(int i = 0;i<10;i++) {
			if ((StallList[i] != null) && (StallList[i].getID().equalsIgnoreCase(stallID))) {
				StallList[i] = null;
			}
		}
	}
	
// Canteen Admin codes (Menu)====================================================================================
	public static String retrieveMenu(ArrayList<Menu> menuList)
	{
		String ID = Helper.readString("Enter the stall ID > ");
		String output = "";
		output += String.format("%-20s%-20s%s\n", "FOOD NUMBER", "NAME", "PRICE");
		for(Menu M : menuList){
			if(ID.equals(M.getStallID())){
				output += String.format("%-20s%-20s%d\n", M.getNumber(), M.getName(), M.getPrice());
			}	
		}
		return output;
	}
	
	private static void viewMenu(ArrayList<Menu> menuList, Menu foodItem )
	{
		String output = String.format("%-20s %-20s %-20s %-20s\n", "FOOD NUMBER", "STALL ID", "FOOD ITEM NAME", "PRICE");
		output += retrieveMenu(menuList);
		System.out.println(output);
	}

	public static Menu inputFoodItem() {
		int number = Helper.readInt("Enter Food Number of new food item > ");
		String stallID = Helper.readString("Enter Stall ID of new food item > ");
		String name = Helper.readString("Enter name of new food item > ");
		int price = Helper.readInt("Enter price > ");

		Menu fI = new Menu(number, stallID, name, price);
		return fI;
		
	}
	public static void addFoodItem(ArrayList<Menu> menuList, Menu fI) {
		menuList.add(fI);
		System.out.println("Food Item added!");

	}
	

	public void deleteFoodItem() {
		viewMenu(); 
		int foodNum = Helper.readInt("Enter food number to delete > ");
		for (int i = 0; i < menuList.size(); i++) { 
			if (i == foodNum) { 
				menuList.remove(foodNum);
			}
			System.out.println("Food Item deleted successfully!");
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
		int OrderID = Helper.readInt("Enter amount of ingrediant");
		String Name = Helper.readString("Enter ingrediant Name");
		double getPrice = Helper.readDouble("Enter ingrediant price");
			IngrediantOrderList.add(new Order(OrderID, Name, getPrice));
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
		for(int i = 0; i < IngrediantOrderList.size(); i++) {
			if (IngrediantOrderList.get(i) != null) {
				output += String.format("%-20s%-20s%s\n", IngrediantOrderList.get(i).getOrderID(), IngrediantOrderList.get(i).getName(), IngrediantOrderList.get(i).getPrice());
			}

		}
		System.out.println(output);
	}
	private String deleteIngrediantOrder() {
		
		viewIngrediantOrder();
		boolean isDeleted = false;
		String Message = "Order was not deleted.";
		int OrderID = Helper.readInt("Enter ID of Order to delete > ");
		for(int i = 0; i < IngrediantOrderList.size(); i++) {
			if ((IngrediantOrderList.get(i) != null) && (IngrediantOrderList.get(i).getOrderID() == OrderID)) 
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
