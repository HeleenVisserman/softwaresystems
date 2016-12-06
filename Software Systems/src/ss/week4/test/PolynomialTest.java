package ss.week4.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import ss.week4.math.Polynomial;

public class PolynomialTest {
	
	private static final double DELTA = 1e-15;
	
	private Polynomial poly, deriv, integr;
	
	@Before
	public void setUp() {
		double[] dpoly = {
				1, 2,
				2, 1,
				3, 0,
				4, 3};
		double[] dderiv = {
				2, 1,
				2, 0,
				12, 2};
		double[] dintegr = {
				1.0/3.0, 3,
				1, 2,
				3, 1,
				1, 4};
		poly = new Polynomial(dpoly);
		deriv = new Polynomial(dderiv);
		integr = new Polynomial(dintegr);
	}
	
	@Test
	public void testInputOdd(){
		boolean failed = false;
		try {
			double[] dpoly = {1};
			Polynomial poly = new Polynomial(dpoly);
		} catch (Exception e) {
			failed = true;
		}
		
		assertTrue(failed);
	}
	
	@Test
	public void testInputEmpty() {
		
	}

	@Test
	public void testApply() {
		assertEquals(poly.apply(-3), -102.0, DELTA);
		assertEquals(deriv.apply(3), 116.0, DELTA);
		assertEquals(integr.apply(0), 0.0, DELTA);
	}
	
	@Test
	public void testDerivative() {
		assertTrue(poly.derivative() instanceof Polynomial);
		assertEquals(poly.derivative().apply(3), deriv.apply(3), DELTA);
	}
	
	@Test
	public void testIntegrand() {
		Polynomial f = (Polynomial) poly.integrand();
		assertTrue(poly.integrand() instanceof Polynomial);
		assertEquals(poly.integrand().apply(3), integr.apply(3), DELTA);
	}

}
