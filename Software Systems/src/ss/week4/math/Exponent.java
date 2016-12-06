package ss.week4.math;

public class Exponent implements Function, Integrandable {

	private int exp;
	
	public Exponent(int exp) {		
		this.exp = exp;
	}
	
	@Override
	public double apply(double x) {		
		return Math.pow(x, exp);
	}

	@Override
	public Function derivative() {
		return new LinearProduct(new Constant(exp), new Exponent(exp - 1));
	}
	
	@Override
	public String toString() {
		return "(x^" + exp + ")";
	}

	@Override
	public Function integrand() {
		LinearProduct debug = new LinearProduct(new Constant((double) 1/(exp + 1)), new Exponent(exp + 1));
		return debug;
	}
	
}
