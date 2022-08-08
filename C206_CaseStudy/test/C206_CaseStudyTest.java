import static org.junit.Assert.*;

import java.time.LocalDate;
import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class C206_CaseStudyTest {
//  prepare test data
	
	private Stall Stall1;
	private Stall Stall2;
	
	private Menu menuStalla1;
	private Menu menuStalla2;
	
	private Cart order1;
	private Cart order2;
	
//	creating the stallList arraylist 
	private ArrayList<Stall> StallList;
	
//  creating the menuList arrayist
	private ArrayList<Menu> menuList;
	
// creating ingrediant orderList arraylist
	private ArrayList<Order> IngrediantOrderList;

//  creating cart to add orders into for customer
	private ArrayList<Cart> cart;

	
	@Before
	public void setUp() throws Exception 
	{
		Stall1 = new Stall("S1", "Drink Store", LocalDate.of(2017, 4, 15));
		Stall2 = new Stall("S2", "Chicken rice store", LocalDate.of(2018, 11, 14));
		menuStalla1 = new Menu(001,"S1", "Chicken Rice",5);
		menuStalla2 = new Menu(002,"S1", "Chicken Cutlet",6);
		
		order1 = new Cart(001,"Chicken Rice",5);
		order2 = new Cart(002,"Chicken Cutlet",6);
		
		StallList = new ArrayList<Stall>();
		menuList = new ArrayList<Menu>();
		IngrediantOrderList = new ArrayList<Order>();
		cart = new ArrayList<Cart>();
	}
	@Test
	public void testRetrieveMenu() { 
		// Test if Menu list is not null but empty, so that can add a new item
		assertNotNull("Test if there is valid Menu arraylist to add to", menuList);
		
		//test if the list of food items retrieved from the SourceCentre is empty
		String allMenu = C206_CaseStudy.retrieveMenu(menuList);
		String testOutput = "";
		assertEquals("Check that Menu has the correct food items", testOutput, allMenu);
		
		//Given an empty list, after adding 2 items, test if the size of the list is 2
		C206_CaseStudy.addFoodItem(menuList, menuStalla1);
		C206_CaseStudy.addFoodItem(menuList, menuStalla2);
		assertEquals("Test if that Menu arraylist size is 2?", 2, menuList.size());
		
		//test if the expected output string same as the list of food items retrieved from the SourceCentre
		allMenu = C206_CaseStudy.retrieveMenu(menuList);
		
		testOutput = String.format("%-10d %-20s %-20d\n", 1,"Chicken Rice", 5);
		testOutput += String.format("%-10d %-20s %-20d\n", 2, "chicken cultlet",6);
			
		assertEquals("Check that Menu has the correct food items ", testOutput, allMenu);
	}
	@Test
	public void testAddFoodItem() { 
		// Item list is not null, so that can add a new item
		assertNotNull("Test if there is valid Menu arraylist to add to", menuList);
				
		//Given an empty list, after adding 1 item, the size of the list is 1
		C206_CaseStudy.addFoodItem(menuList, menuStalla1);		
		assertEquals("Test if that Menu arraylist size is 1?", 1, menuList.size());
		assertSame("Check that Order is added", menuStalla1, menuList.get(0));

				
		//Add another item. test The size of the list is 2?
		C206_CaseStudy.addFoodItem(menuList, menuStalla2);
		assertEquals("Test that Menu arraylist size is 2?", 2, menuList.size());
		assertSame("Check that Order is added", menuStalla2, menuList.get(1));

	}
	@Test
	public void testDeleteFoodItem() { 
		// Menu list is not null, such that a Menu is available to delete from. 
		assertNotNull("Check if there is Menu arraylist to delete from", menuList);
		//adding one food item into the arraylist for deletion
		C206_CaseStudy.addFoodItem(menuList, menuStalla1);
		assertEquals("Test if that Menu arraylist size is 1?", 1, menuList.size());
				
		// deleting the order from the arraylist
		C206_CaseStudy.deleteFoodItem(menuList, 001);
		assertNotEquals("Test if that Menu arraylist size is not equals to 1", 0, menuList.size());
				
		boolean exist = false;
		for(Menu F : menuList) {
			if(F.getNumber() == 001) {
				exist = true;
			}
		}
		assertFalse(exist);
		//adding two orders into the arraylist
		C206_CaseStudy.addFoodItem(menuList, menuStalla1);
		C206_CaseStudy.addFoodItem(menuList, menuStalla2);
		assertEquals("Test if that Menu arraylist size is 2?", 2, menuList.size());
				
		// deleting the order from the arraylist
		C206_CaseStudy.deleteFoodItem(menuList, 001);
		assertNotEquals("Test if that Menu arraylist size is not 2", 2, menuList.size());
				
		exist = false;
		for(Menu F : menuList) {
			if(F.getNumber() == 001)  {
				exist = true;
			}
		}
				
		assertFalse(exist);
	}
//	Cutomer ==========================================================
	
	
	@Test
	public void testAddOrder() 
	{
		// Orders list is not null, so that can add a new item - boundary
		assertNotNull("Check if there is Order arraylist to add to", cart);
		//Given an empty list, after adding 1 item, the size of the list is 1 - normal
		//The order just added is as same as the first item of the list
		C206_CaseStudy.addOrder(cart, order1);
		assertEquals("Check that Order arraylist size is 1", 1, cart.size());
		assertSame("Check that Order is added", order1, cart.get(0));
				
		//Add another order. test The size of the list is 2? -normal
		//The order just added is as same as the second item of the list
		C206_CaseStudy.addOrder(cart, order2);
		assertEquals("Check that Order arraylist size is 2", 2, cart.size());
		assertSame("Check that Order is added", order2, cart.get(1));
	}
	
	@Test
	public void testDeleteOrder()
	{
		// Item list is not null, so that can add a new item - boundary
		assertNotNull("Check if there is Order arraylist to delete from", cart);
		
		//adding one orders into the arraylist
		C206_CaseStudy.addOrder(cart, order1);
		assertEquals("Test if that Camcorder arraylist size is 1?", 1, cart.size());
		
		// deleting the order from the arraylist
		C206_CaseStudy.deleteOrder(cart, 001);
		assertNotEquals("Test if that Camcorder arraylist size is not 1", 1, cart.size());
		
		boolean exist = false;
		for(Cart C : cart)
		{
			if(C.getNumber() == 001)
			{
				exist = true;
			}
		}
		
		assertFalse(exist);
	
		
		//adding two orders into the arraylist
		C206_CaseStudy.addOrder(cart, order1);
		C206_CaseStudy.addOrder(cart, order2);
		assertEquals("Test if that Camcorder arraylist size is 2?", 2, cart.size());
		
		// deleting the order from the arraylist
		C206_CaseStudy.deleteOrder(cart, 001);
		assertNotEquals("Test if that Camcorder arraylist size is not 2", 2, cart.size());
		
		exist = false;
		for(Cart C : cart)
		{
			if(C.getNumber() == 001)
			{
				exist = true;
			}
		}
		
		assertFalse(exist);
	}
	
	@Test
	public void testRetireveAllOrders()
	{
		// Test if cart list is not null but empty, so that can add a new item
		assertNotNull("Test if there is valid cart arraylist to add to", cart);
		
		//test if the list of Orders retrieved from the SourceCentre is empty
		String allOrders = C206_CaseStudy.retrieveAllOrders(cart);
		String testOutput = "";
		assertEquals("Check that viewAllOrders", testOutput, allOrders);
		
		//Given an empty list, after adding 2 items, test if the size of the list is 2
		C206_CaseStudy.addOrder(cart, order1);
		C206_CaseStudy.addOrder(cart, order2);
		assertEquals("Test if that Camcorder arraylist size is 2?", 2, cart.size());
		
		//test if the expected output string same as the list of Orders retrieved from the SourceCentre
		allOrders = C206_CaseStudy.retrieveAllOrders(cart);
		
		testOutput = String.format("%-10d %-20s %-20d\n", 1,"Chicken Rice", 5);
		testOutput += String.format("%-10d %-20s %-20d\n", 2, "chicken cultlet",6);
			
		assertEquals("Check that viewAllOrders", testOutput, allOrders);
		
	}
	
//	End of Cutomer ==========================================================
	@Test
	public void testRetrieveAllStalls() {
		//Test if Stall array is not null but empty -boundary
		assertNotNull("Test if there is valid Stall array to retrieve item", StallList);
		
		//Test if the stalls retrieved from the stall array is empty - boundary
		String allStalls = C206_CaseStudy.retrieveAllStalls(StallList); 
		String testOutput = "";
		assertEquals("Test that the retrieved stallList is empty?", testOutput, allStalls);
		
		//Given an empty list, after adding 2 stalls, test if the size of the stall array is 2 -normal
		C206_CaseStudy.addNewStalls(StallList, Stall1);
		C206_CaseStudy.addNewStalls(StallList, Stall2);
		assertEquals("Test that stall array size is 2" , 2, StallList.size());
		
		//test if the expected output string same as the stall array of stalls retrieved
		allStalls = C206_CaseStudy.retrieveAllStalls(StallList);
		testOutput += String.format("%-20s%-20s%s\n", "S1", "Drink Store", "2017-04-15");
		testOutput += String.format("%-20s%-20s%s\n", "S2", "Chicken rice store", "2018-11-14");
		
		assertEquals("Test that the data format displayed is correct for view stall list", testOutput, allStalls);
		
	}
	
	
	@After
	public void tearDown() throws Exception 
	{
		Stall1 = null;
		menuStalla1 = null;
		menuStalla2 = null;
		
		order1 = null;
		order2 = null;
		
		StallList = null;
		menuList = null;
		IngrediantOrderList = null;
		cart = null;
	}

	@Test
	public void c206_test() {
		//fail("Not yet implemented"); 
		assertTrue("C206_CaseStudy_SampleTest ",true);
	}

}
