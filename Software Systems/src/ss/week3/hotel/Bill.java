package ss.week3.hotel;

import java.io.PrintStream;

public class Bill {

	private PrintStream stream;
	private double sum;
	
	public Bill(PrintStream outStream) {
		sum = 0.0;
		stream = outStream;
	}
	
	public void addNewItem(Bill.Item item) {
		if (stream != null) {
			stream.println(item.toString());
		}
		sum += item.getAmount();
	}
	
	public void close() {
		if (stream == null) {
			return;
		}
		stream.println(sum);
	}
	
	public double getSum() {
		return sum;
	}
	
	public static interface Item {

		public double getAmount();
		
	}
}
