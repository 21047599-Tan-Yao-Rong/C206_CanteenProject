
public class Menu {
	
	private int Number;
	private String Name;
	private int Price;
	private String stallID;
	
	public Menu(int number, String stallID, String name, int price) {
		Number = number;
		Name = name;
		Price = price;
		this.stallID = stallID;
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

	public String getStallID() {
		return stallID;
	}
	
	

	
}
