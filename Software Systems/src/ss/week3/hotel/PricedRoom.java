package ss.week3.hotel;

import ss.week3.pw.Password;
import ss.week3.Safe;

public class PricedRoom extends Room implements Bill.Item {

	private double cost;
	private int amount;
	
	public PricedRoom(int no, double cost, int amount) {
		super(no, new Safe(new Password()));
		
		this.amount = amount;
		this.cost = cost;
	}

	@Override
	public double getAmount() {
		return cost;
	}
	
	@Override
	public String toString() {
		return "pricedroom: " + cost;
	}

}
