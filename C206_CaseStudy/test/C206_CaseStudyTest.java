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
	private Stall Stall3;
	private Stall Stall4;
	private Stall Stall5;
	private Stall Stall6;
	private Stall Stall7;
	private Stall Stall8;
	private Stall Stall9;
	private Stall Stall10;
	private Stall Stall11;
	private Stall StallLateDate;

	
	private Menu menuStalla1;
	private Menu menuStalla2;
	
	private Cart order1;
	private Cart order2;
	
	private Order IngrediantOrder1;
	private Order IngrediantOrder2;
	
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
		Stall1 = new Stall("S1", "Drink Store", LocalDate.of(2023, 4, 15));
		Stall2 = new Stall("S2", "Chicken Rice Store", LocalDate.of(2024, 5, 18));
		Stall3 = new Stall("S3", "Western Cuisine", LocalDate.of(2023, 12, 12));
		Stall4 = new Stall("S4", "Japanese Cuisine", LocalDate.of(2023, 11, 13));
		Stall5 = new Stall("S5", "Korean Cuisine", LocalDate.of(2024, 8, 14));
		Stall6 = new Stall("S6", "Indian Cuisine", LocalDate.of(20124, 1, 4));
		Stall7 = new Stall("S7", "Waffle Store", LocalDate.of(2025, 5, 23));
		Stall8 = new Stall("S8", "Mala Store", LocalDate.of(2024, 9, 1));
		Stall9 = new Stall("S9", "Noodle Store", LocalDate.of(2026, 7, 17));
		Stall10 = new Stall("S10", "Muslim Store", LocalDate.of(2023, 10, 27));
		Stall11 = new Stall("S11", "French Cuisine", LocalDate.of(2023, 12, 16));
		StallLateDate = new Stall("S63", "Chinese Cuisine", LocalDate.of(2019, 11, 21));
		menuStalla1 = new Menu(001,"S1", "Chicken Rice",5);
		 menuStalla2 = new Menu(2,"S2", "Chicken Cutlet",6);
		
		order1 = new Cart(001,"Chicken Rice",5);
		order2 = new Cart(002,"Chicken Cutlet",6);
		
		IngrediantOrder1 = new Order(1,"Chicken",10);
		IngrediantOrder2 = new Order(2,"Egg",5);
		
		StallList = new ArrayList<Stall>();
		menuList = new ArrayList<Menu>();
		IngrediantOrderList = new ArrayList<Order>();
		cart = new ArrayList<Cart>();
	}
    @Test
    public void testRetrieveMenu() {
        // Test if menuList is not null but empty, so that can add a new item
        assertNotNull("Test if there is valid Menu arraylist to add to", menuList);
        
        //test if the list of food items retrieved from the menuList is empty
        String allMenu = C206_CaseStudy.retrieveMenu(menuList);
        String testOutput = "";
        assertEquals("Check that Menu has the correct food items", testOutput, allMenu);
        
        //Given an empty list, after adding 2 food items, test if the size of the list is 2
        C206_CaseStudy.addFoodItem(menuList, menuStalla1);
        C206_CaseStudy.addFoodItem(menuList, menuStalla2);
        assertEquals("Test if that Menu arraylist size is 2?", 2, menuList.size());
        
        //test if the expected output string same as the list of food items retrieved from the menuList
        allMenu = C206_CaseStudy.retrieveMenu(menuList);
        
        testOutput = String.format("%-20d %-20s %-20s %-20d\n", 1, "S1", "Chicken Rice", 5);
        testOutput += String.format("%-20d %-20s %-20s %-20d\n", 2, "S2","Chicken Cutlet",6);
            
        assertEquals("Check that Menu has the correct food items ", testOutput, allMenu);
    }
	@Test
    public void testAddFoodItem() {
        //menuList is not null, such that there is a menuList to add to.
        assertNotNull("Test if there is valid Menu arraylist to add to", menuList);
                
        //Given an empty list, after adding 1 item, the size of the list is 1
        //The foodItem just added is as same as the first item of menuList
        C206_CaseStudy.addFoodItem(menuList, menuStalla1);        
        assertEquals("Test if that Menu arraylist size is 1?", 1, menuList.size());
        assertSame("Check that Order is added", menuStalla1, menuList.get(0));
           
        //Add another food item. test that the size of menuList is 2?
        //The foodItem just added is as same as the second item of menuList.
        C206_CaseStudy.addFoodItem(menuList, menuStalla2);
        assertEquals("Test that Menu arraylist size is 2?", 2, menuList.size());
        assertSame("Check that Order is added", menuStalla2, menuList.get(1));
    }
    @Test
    public void testDeleteFoodItem() {
        //menuList is not null, such that a menuList is available to delete from.
        assertNotNull("Check if there is Menu arraylist to delete from", menuList);
        
        //adding one food item into the menuList for deletion
        C206_CaseStudy.addFoodItem(menuList, menuStalla1);
        assertEquals("Test if that Menu arraylist size is 1?", 1, menuList.size());
                
        // deleting the food item from the menuList
        C206_CaseStudy.deleteFoodItem(menuList, menuStalla1.getNumber());
        assertNotEquals("Test if that Menu arraylist size is not equals to 1", 1, menuList.size());
                
        boolean exist = false;
        for(Menu F : menuList) {
            if(F.getNumber() == 001) {
                exist = true;
            }
        }
        assertFalse(exist);
        
        //adding two food items into the menuList
        C206_CaseStudy.addFoodItem(menuList, menuStalla1);
        C206_CaseStudy.addFoodItem(menuList, menuStalla2);
        assertEquals("Test if that Menu arraylist size is 2?", 2, menuList.size());
                
        // deleting the a food item from the menuList
        C206_CaseStudy.deleteFoodItem(menuList, menuStalla1.getNumber());
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
		assertNotNull("Check if there is cart arraylist to delete from", cart);
		
		//adding one orders into the arraylist
		C206_CaseStudy.addOrder(cart, order1);
		assertEquals("Test if that cart arraylist size is 1?", 1, cart.size());
		
		// deleting the order from the arraylist
		C206_CaseStudy.deleteOrder(cart, 001);
		assertNotEquals("Test if that cart arraylist size is not 1", 1, cart.size());
		
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
		assertEquals("Test if that cart arraylist size is 2?", 2, cart.size());
		
		// deleting the order from the arraylist
		C206_CaseStudy.deleteOrder(cart, 001);
		assertNotEquals("Test if that cart arraylist size is not 2", 2, cart.size());
		
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
		
		//test if the list of Orders retrieved from the cart is empty
		String allOrders = C206_CaseStudy.retrieveAllOrders(cart);
		String testOutput = "";
		assertEquals("Check that viewAllOrders", testOutput, allOrders);
		
		//Given an empty list, after adding 2 items, test if the size of the list is 2
		C206_CaseStudy.addOrder(cart, order1);
		C206_CaseStudy.addOrder(cart, order2);
		assertEquals("Test if that cart arraylist size is 2?", 2, cart.size());
		
		//test if the expected output string same as the list of Orders retrieved from the cart
		allOrders = C206_CaseStudy.retrieveAllOrders(cart);
		
		testOutput = String.format("%-10d %-20s %-20d\n", 1,"Chicken Rice", 5);
		testOutput += String.format("%-10d %-20s %-20d\n", 2, "Chicken Cutlet",6);
			
		assertEquals("Check that viewAllOrders", testOutput, allOrders);
		
	}
	
//	End of Cutomer ==========================================================
	
// Stall Administrator ==============================================================
	
	@Test
	public void testRetrieveAllStalls() {
		//Test if Stall array is not null but empty
		assertNotNull("Test if there is valid Stall arrayList to retrieve item", StallList);
		
		//Test if the stalls retrieved from the stall array is empty
		String allStalls = C206_CaseStudy.retrieveAllStalls(StallList); 
		String testOutput = "";
		assertEquals("Test that the retrieved stallList is empty?", testOutput, allStalls);
		
		//Given an empty list, after adding 2 stalls, test if the size of the stall array is 2 
		C206_CaseStudy.addNewStalls(StallList, Stall1);
		C206_CaseStudy.addNewStalls(StallList, Stall2);
		assertEquals("Test that stall array size is 2" , 2, StallList.size());
		
		//test if the expected output string same as the stall array of stalls retrieved
		allStalls = C206_CaseStudy.retrieveAllStalls(StallList);
		testOutput += String.format("%-20s%-20s%s\n", "S1", "Drink Store", "2023-04-15");
		testOutput += String.format("%-20s%-20s%s\n", "S2", "Chicken Rice Store", "2024-05-18");
		
		assertEquals("Test that the data format displayed is correct for view stall list", testOutput, allStalls);
		
	}
	
	@Test
	public void testViewSelectedStall() {
		//Test if Stall array is not null but empty
		assertNotNull("Test if there is valid Stall arrayList to retrieve item", StallList);
		
		//Test if the stalls retrieved from the stall array is empty
		String allStalls = C206_CaseStudy.retrieveAllStalls(StallList); 
		String testOutput = "";
		assertEquals("Test that the retrieved stallList is empty?", testOutput, allStalls);
		
		//Test that after adding a stall, the stall can be selected is displayed 
		C206_CaseStudy.addNewStalls(StallList, Stall1);
		String selectedStall = C206_CaseStudy.retrieveSelectedStall(StallList, "S1");
		testOutput += String.format("%-20s%-20s%s\n", "S1", "Drink Store", "2023-04-15");
		assertEquals("Test that the selected stall display is correct", testOutput, selectedStall);
		
		//Test that stall non-existing stall will not be retrieved from the stall list
		String nonExistingStall = C206_CaseStudy.retrieveSelectedStall(StallList, "S22");
		assertNull("Test that null value is returned when the stall does not exist", nonExistingStall);
	}
	
	@Test
	public void testAddStalls() {
		
		//Test that stall list is not null , so that a new stall can be added
		assertNotNull("Test if there is valid stall arrayList to add to", StallList);
		
		//Given an empty stall list, after adding 1 stall, the size of the stall list is 1
		C206_CaseStudy.addNewStalls(StallList, Stall1);
		assertEquals("Test if the stall arraylist size is 1?", 1 , StallList.size());
		
		//Test that the item that was added is the same as the first item in the stall list
		assertSame("Test that stall added same as 1st item of the stall list?", Stall1, StallList.get(0));
		
		//Add another stall, test that the size of stall list is 2?
		C206_CaseStudy.addNewStalls(StallList, Stall2);
		assertEquals("Test if the stall arraylist size is 2?", 2 , StallList.size());
		
		//Test that the stall that was added is the same as the second stall in the stall list
		assertSame("Test that stall added same as 1st item of the list?", Stall2, StallList.get(1));
		
		//Test that the stalls being added with similar stall ID as the stalls in the stall list will not be added
		C206_CaseStudy.addNewStalls(StallList, Stall1);
		assertEquals("Test if the stall arraylist size is 2 as duplicate stalls is not added into the stall list", 2 , StallList.size());
		
		//Test that stall added with operational date before today's date will not be added
		C206_CaseStudy.addNewStalls(StallList, StallLateDate);
		assertEquals("Test if the stall arraylist size is 2 as stall with operational date before today's date will not be added into the stall list", 2 , StallList.size());
		
		//Add another 8 stalls, test that the size of the stall list is 10

		C206_CaseStudy.addNewStalls(StallList, Stall3);
		C206_CaseStudy.addNewStalls(StallList, Stall4);
		C206_CaseStudy.addNewStalls(StallList, Stall5);
		C206_CaseStudy.addNewStalls(StallList, Stall6);
		C206_CaseStudy.addNewStalls(StallList, Stall7);
		C206_CaseStudy.addNewStalls(StallList, Stall8);
		C206_CaseStudy.addNewStalls(StallList, Stall9);
		C206_CaseStudy.addNewStalls(StallList, Stall10);
		assertEquals("Test if the stall arraylist size is 10?", 10 , StallList.size());
			
		//Test when there is 10 stall in the stall arraylist, the 11th stall added will not exist in the stall arraylist
		C206_CaseStudy.addNewStalls(StallList, Stall11);
		assertEquals("Test if the stall arraylist size is still 10 after adding the 11th stall?", 10 , StallList.size());
	
	}
	
	@Test
	public void testDeleteStalls() {
		//Test if there is a valid stall arraylist to add stalls to
		assertNotNull("Test if there is valid stall arrayList to add to", StallList);
		C206_CaseStudy.addNewStalls(StallList, Stall1);
		
		//Test that Stall1 of Stall ID of "S1" is deleted	
		boolean isDeleted = C206_CaseStudy.doDeleteStall(StallList, "S1");
		assertTrue("Test if the deletion of stall is successful", isDeleted);
		
		//Test that size of Stall arraylist is 0 after deletion of stall1	
		assertEquals("Test if the stall arraylist size is 0?", 0 , StallList.size());
		
		//Test that the non-existing stall is not deleted in the stall list
		isDeleted = C206_CaseStudy.doDeleteStall(StallList, "S20");
		assertFalse("Test if non-existing stall S20 is deleted -false", isDeleted);
		
		
		
		
	}
	
// End of stall administrator =============================================
	
	// Stall Operator ================================================================
		@Test
		public void testRetrieveIngrediantOrder() { 
			// IngredientOrderlist is not null, so that can add a new Order
			assertNotNull("Test if there is valid Menu arraylist to add to", IngrediantOrderList);
			
			//test if the list of IngredientOrder retrieved from the SourceCentre is empty
			String allOrders = C206_CaseStudy.retrieveAllIngredientOrders(IngrediantOrderList);
			String testOutput = "";
			assertEquals("Check that IngredientOrderList has the correct Orders", testOutput, allOrders);
			
			//Given an empty list, after adding 2 Orders, test if the size of the list is 2
			C206_CaseStudy.addIngredientOrder(IngrediantOrderList, IngrediantOrder1);
			C206_CaseStudy.addIngredientOrder(IngrediantOrderList, IngrediantOrder2);
			
			assertEquals("Test if that IngredientOrder arraylist size is 2?", 2, IngrediantOrderList.size());
			
			//test if the expected output string same as the list of Orders retrieved from the SourceCentre
			allOrders = C206_CaseStudy.retrieveAllIngredientOrders(IngrediantOrderList);
			
			testOutput = String.format("%-10d %-20s %-20d\n", 1,"Chicken", 10);
			
				
			assertEquals("Check that IngredientOrderList has the correct Orders ", testOutput, allOrders);
		}
		@Test
		public void testAddIngredientOrder() { 
			// IngredientOrderlist is not null, so that can add a new Order
			assertNotNull("Test if there is valid Menu arraylist to add to", IngrediantOrderList);
					
			//Given an empty list, after adding 1 Order, the size of the list is 1
			C206_CaseStudy.addIngredientOrder(IngrediantOrderList, IngrediantOrder1);		
			assertEquals("Test if that IngrediantOrder arraylist size is 1?", 1, IngrediantOrderList.size());
			assertSame("Check that Order is added", IngrediantOrder1, IngrediantOrderList.get(0));

					
			//Add another Order. test The size of the list is 2?
			C206_CaseStudy.addIngredientOrder(IngrediantOrderList, IngrediantOrder2);
			assertEquals("Test that IngredientOrder arraylist size is 2?", 2, IngrediantOrderList.size());
			assertSame("Check that Order is added", IngrediantOrder2, IngrediantOrderList.get(1));

		}
		@Test
		public void testDeleteIngredientOrder() { 
			// IngrediantOrder list is not null, such that a List is available to delete from. 
			assertNotNull("Check if there is Menu arraylist to delete from", menuList);
			//adding one Order into the arraylist for deletion
			C206_CaseStudy.addIngredientOrder(IngrediantOrderList, IngrediantOrder1);
			assertEquals("Test if that IngrediantOrder arraylist size is 1?", 1, IngrediantOrderList.size());
					
			// deleting the order from the arraylist
			C206_CaseStudy.deleteIngrediantOrder(IngrediantOrderList, 1);
			assertNotEquals("Test if that IngrediantOrder arraylist size is not equals to 1", 0, IngrediantOrderList.size());
					
			boolean exist = false;
			for(Order O : IngrediantOrderList) {
				if(O.getOrderID() == 1) {
					exist = true;
				}
			}
			
			assertFalse(exist);
			//adding two orders into the arraylist
			C206_CaseStudy.addIngredientOrder(IngrediantOrderList, IngrediantOrder1);
			C206_CaseStudy.addIngredientOrder(IngrediantOrderList, IngrediantOrder2);
			assertEquals("Test that IngredientOrder arraylist size is 2?", 2, IngrediantOrderList.size());
					
			// deleting the order from the arraylist
			C206_CaseStudy.deleteIngrediantOrder(IngrediantOrderList, 1);
			assertNotEquals("Test if that Ingrediant arraylist size is not 2", 2, IngrediantOrderList.size());
					
			exist = false;
			for(Order O : IngrediantOrderList) {
				if(O.getOrderID() == 1)  {
					exist = true;
				}
			}
					
			assertFalse(exist);
		}
	// end of StallOperator tests =========================
	
	
	@After
	public void tearDown() throws Exception 
	{
		Stall1 = null;
		Stall2 = null;
		Stall3 = null;
		Stall4 = null;
		Stall5 = null;
		Stall6 = null;
		Stall7 = null;
		Stall8 = null;
		Stall9 = null;
		Stall10 = null;
		Stall11 = null;
		StallLateDate = null;
		
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
