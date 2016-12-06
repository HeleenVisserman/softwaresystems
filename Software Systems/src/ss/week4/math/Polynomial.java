package ss.week4.math;

public class Polynomial implements Function, Integrandable {

	private LinearProduct[] linearProducts;

	private Polynomial(LinearProduct[] products) {
		this.linearProducts = products;
	}

	public Polynomial(double[] input) {
		if (input.length % 2 == 1)
			throw new IllegalArgumentException("length of input must be even");

		linearProducts = new LinearProduct[input.length / 2];
		for (int i = 0; i < input.length; i += 2) {
			linearProducts[i/2] = new LinearProduct(new Constant(input[i]), new Exponent((int) input[i + 1]));
		}
	}

	@Override
	public double apply(double x) {
		double sum = 0;
		for (int i = 0; i < linearProducts.length; i++) {
			sum += linearProducts[i].apply(x);
		}

		return sum;
	}

	@Override
	public Function derivative() {
		LinearProduct[] products = new LinearProduct[linearProducts.length];

		for (int i = 0; i < products.length; i++) {
			products[i] = (LinearProduct) linearProducts[i].derivative();
		}

		return new Polynomial(products);
	}

	@Override
	public Function integrand() {
		LinearProduct[] products = new LinearProduct[linearProducts.length];

		for (int i = 0; i < products.length; i++) {
			products[i] = (LinearProduct) linearProducts[i].integrand();
		}

		return new Polynomial(products);
	}

}
