package ss.week4.math;

public interface Function {
	
	/**
	 * Apply this <code>Function</code> to a value of x
	 * @param x value of x
	 * @return returns the function value
	 */
	double apply(double x);
	
	/**
	 * Returns the derivative of the current <code>Function</code>
	 * @return the <code>Function</code> containing the derivative
	 */
	Function derivative();
	
	/**
	 * Returns a <code>String</code> representation of this Function
	 * @return the <code>String</code> representation
	 */
	String toString();
	
}
