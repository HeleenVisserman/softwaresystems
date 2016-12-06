package ss.week4.math;

public class LinearProduct extends Product implements Integrandable {
	
	public LinearProduct(Constant a, Function b) {
		super(a, b);
	}
	
	@Override
	public Function derivative() {
		return new LinearProduct((Constant) a, b.derivative());
	}

	@Override
	public Function integrand() {
		if (b instanceof Integrandable)
			return new LinearProduct((Constant) a, ((Integrandable) b).integrand());
		else
			throw new UnsupportedOperationException("The function needs to be integrandable");
	}

}
