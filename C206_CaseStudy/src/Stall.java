import java.time.LocalDate;
import java.util.ArrayList;

public class Stall {
	
	private String ID;
	private String Name;
	private LocalDate OperationDate;
	
	public Stall(String iD, String name, LocalDate OperationDate) 
	{
		this.ID  = iD;
		this.Name = name;
		this.OperationDate = OperationDate;
	}

	public String getID() {
		return ID;
	}

	
	public String getName() {
		return Name;
	}
	
	public LocalDate getOperationDate() {
		return OperationDate;
	}
	
	public void changeID(String ID) {
		this.ID = ID;
	}
	
	public void changeName(String Name) {
		this.Name = Name;
	}
	
	public void changeOperationDate(LocalDate OperationDate) {
		this.OperationDate = OperationDate;
	}
	
}
