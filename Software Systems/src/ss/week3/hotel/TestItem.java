package ss.week3.hotel;

public class TestItem implements Bill.Item {

	private String name;
	private double amount;
	
	public TestItem(String name, double amount) {
		this.name = name;
		this.amount = amount;
	}
	
	@Override
	public double getAmount() {
		return amount;
	}
	
	@Override
	public String toString() {
		return name;
	}

}
