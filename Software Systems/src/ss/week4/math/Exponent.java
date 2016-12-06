package ss.week4.math;

public class Exponent implements Function, Integrandable {

	private boolean negative = false;
	private int exp;
	
	public Exponent(int exp) {
		if (exp < 0) {
			this.exp = exp * -1;
			negative = true;
		} else {
			this.exp = exp;
		}
	}
	
	@Override
	public double apply(double x) {
		double sum = 1;
		for (int i = 0; i < exp; i++)
			sum *= x;
		
		if (x == 0) {
			return 0;
		} else {
			if (negative)
				return 1 / sum;
			else
				return sum;
		}
	}

	@Override
	public Function derivative() {
		return new LinearProduct(new Constant(exp), new Exponent(exp - 1));
	}
	
	@Override
	public String toString() {
		return "Exponent: " + exp;
	}

	@Override
	public Function integrand() {
		return new LinearProduct(new Constant(1/(exp + 1)), new Exponent(exp + 1));
	}
	
}
