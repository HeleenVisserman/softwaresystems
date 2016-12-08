
package ss.week4.math;

public class Sum implements Function{
	
	private Function a, b;
	
	public Sum(Function a, Function b) {
		this.a = a;
		this.b = b;
	}

	@Override
	public double apply(double x) {
		return a.apply(x) + b.apply(x);
	}

	@Override
	public Function derivative() {
		return new Sum(a.derivative(), b.derivative());
	}
	
	@Override
	public String toString() {
		return "(" + a.toString() + " + " + b.toString() + ")";
	}
	
}
