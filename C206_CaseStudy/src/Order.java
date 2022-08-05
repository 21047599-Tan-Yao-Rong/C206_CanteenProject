
public class Order {
	
	private String Name;
	private int OrderID;
	private double Price;
	
	public Order(int OrderID ,String Name,double Price) {
		this.Name = Name;
		this.OrderID = OrderID;
		this.Price = Price;
		
	}

	public void setName(String name) {
		Name = name;
	}

	public void setOrderID(int orderID) {
		OrderID = orderID;
	}

	public void setPrice(double price) {
		Price = price;
	}

	public String getName() {
		return Name;
	}

	public int getOrderID() {
		return OrderID;
	}

	public double getPrice() {
		return Price;
	}
	

	
	
	
}
