
public class Menu {
	
	private int Number;
	private String Name;
	private int Price;
	
	public Menu(int number, String name, int price) {
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

	public int getPrice() {
		return Price;
	}
	public void setPrice(int Price) {
		this.Price = Price;
	}
	
	

	
}
