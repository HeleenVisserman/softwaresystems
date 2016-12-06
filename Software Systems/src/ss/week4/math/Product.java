package ss.week4.math;

public class Product implements Function {
	
	public Function a, b;
	
	public Product(Function a, Function b) {
		this.a = a;
		this.b = b;
	}

	@Override
	public double apply(double x) {
		double temp = a.apply(x) * b.apply(x);
		return temp;
	}

	@Override
	public Function derivative() {
		return new Sum(new Product(a, b.derivative()), new Product(a.derivative(), b));
	}
	
	@Override
	public String toString() {
		return "Product { " + a.toString() + ", " + b.toString() + " }";
	}

}
