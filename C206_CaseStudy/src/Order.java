
public class Order {
	
	private int Number;
	private String Name;
	private double Price;
	
	public Order(int number, String name, double price) {
		Number = number;
		Name = name;
		Price = price;
	}

	public int getNumber() {
		return Number;
	}

	public String getName() {
		return Name;
	}

	public double getPrice() {
		return Price;
	}

	
}
