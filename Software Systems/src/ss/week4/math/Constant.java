package ss.week4.math;

public class Constant implements Function, Integrandable {

	private double c;

	public Constant(double c) {
		this.c = c;
	}

	@Override
	public double apply(double x) {
		return c;
	}

	@Override
	public Function derivative() {
		return new Constant(0);
	}
	
	@Override
	public String toString() {
		return "(" + c + ")";
	}

	@Override
	public Function integrand() {
		return new LinearProduct(this, new Exponent(1));
	}

}
