package ss.week3;

public class Format {

	public static void main(String[] args) {
		Format.printLine("text1", 1.00);
		Format.printLine("other text", -12.12);
		Format.printLine("something", 0.20);
	}
	
	static void printLine(String text, double amount) {
		System.out.println(String.format("%-15s%15.2f", text, amount));
	}
	
}
