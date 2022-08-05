import static org.junit.Assert.*;

import java.time.LocalDate;
import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class C206_CaseStudyTest {
//  prepare test data
	
	private Stall Stall1;
	
	private Menu menuStalla1;
	private Menu menuStalla2;
	
	private Cart order1;
	private Cart order2;
	
//	creating the stallList arraylist 
	private Stall[] StallList;
	
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
		menuStalla1 = new Menu(001,"S1", "Chicken Rice",5);
		menuStalla2 = new Menu(002,"S1", "Chicken Cutlet",6);
		
		order1 = new Cart(001,"Chicken Rice",5);
		order2 = new Cart(002,"Chicken Cutlet",6);
		
		StallList = new Stall[10];
		menuList = new ArrayList<Menu>();
		IngrediantOrderList = new ArrayList<Order>();
		cart = new ArrayList<Cart>();
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
