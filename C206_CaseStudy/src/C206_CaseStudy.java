import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class C206_CaseStudy {
	
//	creating the stallList arraylist 
	// private ArrayList<Stall> stallList = new ArrayList<Stall>();
	private ArrayList<Stall> stallList = new ArrayList<Stall>();
	
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
		//Cs.cutomerStart();
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
		stallList.add(new Stall("S1", "Drink Store", LocalDate.of(2023, 4, 15)));
		stallList.add(new Stall("S2", "Chicken Rice Store", LocalDate.of(2024, 5, 18)));
		stallList.add(new Stall("S3", "Western Cuisine", LocalDate.of(2023, 12, 12)));
		stallList.add(new Stall("S4", "Japanese Cuisine", LocalDate.of(2023, 11, 13)));
		stallList.add(new Stall("S5", "Korean Cuisine", LocalDate.of(2024, 8, 14)));
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
	}

	
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
		System.out.println("Option 2: Add new food items");
		System.out.println("Option 3: Delete food item");
		System.out.println("Option 4: Quit");
		Helper.line(50, "=");
	}
	private void StallOperatorMenu() { 
		Helper.line(50, "=");
		System.out.println("Option 1: View all Ingrediant Orders");
		System.out.println("Option 2: Add new Ingrediant Order");
		System.out.println("Option 3: Delete Ingrediant Order");
		Helper.line(50, "=");
	}
	
//	private void start()
//	{
//		CanteenAdminMenu();
//		int option = Helper.readInt("Enter your option > ");
//		while(option != 4) {
//			if (option == 1) {
//				C206_CaseStudy.viewStalls(stallList);
//			}
//			else if (option == 2) {
//				Stall newStall = inputStall();
//				C206_CaseStudy.addNewStalls(stallList, newStall);
//			}
//			else if(option == 3) {
//				C206_CaseStudy.deleteStall(stallList);
//			}
//			else {
//				System.out.println("Invaild option");
//			}
//			CanteenAdminMenu();
//			option = Helper.readInt("Enter your option > ");
//		}
//		
//		
//		
//		System.out.println("Bye bye");
//		
//	}
	
	private void start() { 
		CanteenAdminFoodMenu();
		int option = Helper.readInt("Enter option number > ");
		while(option != 4) { 
			if (option == 1) {
				viewMenu();
			}
			else if (option == 2) {
				Menu foodItem = inputFoodItem();
				addFoodItem(menuList, foodItem);
			}
			else if(option == 3) {
				int foodNum = inputFoodNum();
				deleteFoodItem(menuList, foodNum);
			}
			else if (option == 4) { 
				System.out.println("Bye bye");
			}
			else {
				System.out.println("Invaild option");
			}
			CanteenAdminFoodMenu();
			option = Helper.readInt("Enter option number > ");
		}
	}
	
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
	
	public static String retrieveAllStalls(ArrayList<Stall> stallList2) {
		String output = "";
		
		for(int i =0;i<stallList2.size(); i++) {
			if (stallList2.get(i) != null) {
				output += String.format("%-20s%-20s%s\n", stallList2.get(i).getID(), stallList2.get(i).getName(), stallList2.get(i).getOperationDate());
			}
		}
		return output;
		
	}
	
	private static void viewStalls(ArrayList<Stall> stallList2)
	{
		String output = String.format("%-20s%-20s%s\n", "STALL ID", "STALL NAME", "OPERATION DATE");
		output += retrieveAllStalls(stallList2);
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
	
	public static void addNewStalls(ArrayList<Stall> stallList2, Stall newStall) {
		
		boolean hasSameID = false;
		boolean afterCurrentDate = newStall.getOperationDate().isAfter(LocalDate.now());
		
		for(int i = 0;i<stallList2.size();i++) {
			
			if (stallList2.get(i).getID().equals(newStall.getID())) {
				hasSameID = true;
			}
		}
		
		if (stallList2.size() < 10 && hasSameID == false && afterCurrentDate == true) {
			
			stallList2.add(newStall);
			
			System.out.println(newStall.getName() + " has sucessfully been added");
		}
		
		else if(hasSameID == true && afterCurrentDate == true) {
			System.out.println("ERROR! Duplicate stall ID ");
		}
		
		else if(hasSameID == false && afterCurrentDate == false) {
			System.out.println("The operation date must be before today's date!");
		}
		else {
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
	
	public static boolean doDeleteStall(ArrayList<Stall> stallList2, String stallID) {
		
		boolean isDeleted = false;
		
		for(int i = 0;i<stallList2.size();i++) {
			if ( (stallList2.get(i).getID().equalsIgnoreCase(stallID))) {
				stallList2.remove(i);
				isDeleted= true;
				
			}
		}
		
		return isDeleted;
		
	}
	
	public static void deleteStall(ArrayList<Stall> stallList2) {
		viewStalls(stallList2);
		String stallID = Helper.readString("Enter ID of stall to delete > ");
		Boolean isDeleted = doDeleteStall(stallList2, stallID);
		if (isDeleted == true) {
			System.out.println("Stall successfully deleted");
		}
		else {
			System.out.println("Deletion of stall is unsucessful");
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

	private static void viewMenu(ArrayList<Menu> menuList) {
		String output = String.format("%-20s %-20s %-20s %-20s\n", "FOOD NUMBER", "STALL ID", "FOOD ITEM NAME", "PRICE");
		output += retrieveMenu(menuList);
		System.out.println(output);
	}

	public static Menu inputFoodItem() {
		int number = Helper.readInt("Enter Food Number of new food item > ");
		String stallID = Helper.readString("Enter Stall ID of new food item > ");
		String name = Helper.readString("Enter name of new food item > ");
		int price = Helper.readInt("Enter price > ");

		Menu foodItem = new Menu(number, stallID, name, price);
		return foodItem;
		
	}
	public static void addFoodItem(ArrayList<Menu> menuList, Menu foodItem) {
		menuList.add(foodItem);
		System.out.println("Food Item added!");

	}
	public static int inputFoodNum() {
		int foodNumber = Helper.readInt("Enter the food Number you want to delete > ");
		return foodNumber;
	}

	public static void deleteFoodItem(ArrayList<Menu> menuList, int foodNumber) {
		for (int i = 0; i < menuList.size(); i++) { 
			if (i == foodNumber) { 
				menuList.remove(foodNumber);
			}
			System.out.println("Food Item deleted successfully!");
		}
	}
	
//Stall operator Code-----------------------------------------------------------------------------------------------

	/*private void start() {
	
	StallOperatorMenu();
	int option = Helper.readInt("Enter your option > ");
	while(option != 4) {
		if (option == 1) {
			viewIngrediantOrder();
		}
		else if (option == 2) {
			Order newOrder = InputIngredientOrder();
			addIngredientOrder(IngrediantOrderList, newOrder);
		}
		else if(option == 3) {
			int OrderID = inputOrderID();
			deleteIngrediantOrder(IngrediantOrderList, OrderID);
		}
		else if(option == 4) {
			System.out.println("Bye");
		}else {
			System.out.println("Invaild option");
		}
		StallOperatorMenu();
	    option = Helper.readInt("Enter option number > ");
	
	}
	}*/

	
	public static Order InputIngredientOrder()
	{
		int OrderID = Helper.readInt("Enter Order ID> ");
		String Name = Helper.readString("Enter ingrediant Name> ");
		double getPrice = Helper.readDouble("Enter ingrediant price> ");
		Order ingrediantorder = new Order(OrderID, Name, getPrice);
		return ingrediantorder;
	}
	public static int inputOrderID(){
		int OrderID = Helper.readInt("Enter Order ID> ");
		return OrderID;
	}
	public static void addIngredientOrder(ArrayList<Order> Order, Order order) {
		Order.add(order);
		System.out.println("Order added.");
	}
	private void viewIngrediantOrder()
	{
		String output = "";
		output += String.format("%-20s%-20s%s\n", "ORDER NUMBER", "INGREDIANT NAME", "ORDER PRICE");
		for(Order i : IngrediantOrderList) {
			if (i != null) {
				output += String.format("%-20s%-20s%s\n", i.getOrderID(), i.getName(), i.getPrice());
			}

		}
		System.out.println(output);
	}
	public static void deleteIngrediantOrder(ArrayList<Order> Order, int order) {
		for (int i = 0; i < Order.size(); i++) 
		{
			if(Order.get(i).getOrderID() == order)
			{
				Order.remove(i);
			}
		}
		System.out.println("Order deleted.");
	}
	public static String retrieveAllIngredientOrders(ArrayList<Order> Order)
	{
		String output = "";
		
		for (int i = 0; i < Order.size(); i++) 
		{
			output += String.format("%-10d %-20s %-20d\n", i + 1, Order.get(i).getOrderID(),Order.get(i).getName() ,Order.get(i).getPrice());
		}
		
		return output;
	}
	
}
