package ss.week1;

public class DollarsAndCentsCounter {

	private int dollars = 0;
	private int cents = 0;
	
	public int dollars() {
		if (dollars < 0) {
			return 0;
		}
		return dollars;
	}
	
	public int cents() {
		if (cents < 0) {
			return 0;
		}
		return cents;
	}
	
	public void add(int dollars, int cents) {
		this.dollars += dollars;
		this.cents += cents;
		
		if (this.cents > 99) {
			int centsToDollars = this.cents / 100;
			this.cents -= 100*centsToDollars;
			this.dollars += centsToDollars;
		}
	}
	
	public void reset() {
		this.dollars = 0;
		this.cents = 0;
	}
	
	public void substracrt(int dollars, int cents) {
		this.dollars -= dollars;
		this.cents -= cents;
	}
	
}
