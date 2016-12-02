package ss.week3.hotel;

import ss.week3.Safe;
import ss.week3.pw.Password;

public class PricedSafe extends Safe implements Bill.Item {

	private double cost;

	public PricedSafe(double price) {
		super(new Password());
		this.cost = price;
	}

	@Override
	public double getAmount() {
		return cost;
	}

	@Override
	public String toString() {
		return "pricedsafe: " + cost;
	}
	
}
