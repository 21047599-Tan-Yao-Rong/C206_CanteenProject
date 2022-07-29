import java.util.ArrayList;

public class C206_CaseStudy {
	
//	creating the stallList arraylist 
	private ArrayList<Stall> stallList = new ArrayList<Stall>();
	
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
		stallList.add(new Stall("S1", "Drink Store"));
		stallList.add(new Stall("S2", "Chicken Rice Store"));
		stallList.add(new Stall("S3", "Western Cuisine"));
		stallList.add(new Stall("S4", "Japanese Cuisine"));
		stallList.add(new Stall("S5", "Korean Cuisine"));
	}
	
	private void loadMenuList()
	{
		menuList.add(new Menu(001,"Chicken Rice",3.50));
		menuList.add(new Menu(002,"Bolognese Spaghetti",2.50));
		menuList.add(new Menu(003,"Fish and Chips",3.00));
		menuList.add(new Menu(004,"Kimchi Fried Rice",4.00));
		menuList.add(new Menu(005,"Soda Drinks",2.00));
	}
	
	
	private void start()
	{
		
	}
	
//  CUSTOMER CODE====================================================================
	
	private void viewStalls()
	{
		String output = "";
		output += String.format("%-20s%s\n", "STALL ID", "STALL NAME");
		for(Stall S : stallList)
		{
			output += String.format("%-20s%s\n", S.getID(), S.getName());
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
