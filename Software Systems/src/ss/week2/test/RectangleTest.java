package ss.week2.test;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import ss.week2.Rectangle;

public class RectangleTest {

	/**
	 * Testvariables for a <code>Rectangle</code>-object.
	 */
	Rectangle validRectangle;
	public static final int LENGTH = 30;
	public static final int WIDTH = 20;
	
	/**
	 * Assigns a <code>Rectangle</code>-object to the validRectangle variable.
	 */
	@Before
	public void setUp() {
		validRectangle = new Rectangle(LENGTH, WIDTH);
	}
	
	/**
	 * Test width function of <code>Rectangle</code>.
	 */
	@Test
	public void testWidth() {
		assertEquals(WIDTH, validRectangle.width());
	}
	
	/**
	 * Test length function of <code>Rectangle</code>.
	 */
	@Test
	public void testLength() {
		assertEquals(LENGTH, validRectangle.length());
	}
	
	/**
	 * Test area function of <code>Rectangle</code>.
	 */
	@Test
	public void testArea() {
		int area = LENGTH * WIDTH;
		assertEquals(area, validRectangle.area());
	}
	
	/**
	 * Test perimeter function of <code>Rectangle</code>.
	 */
	@Test
	public void testPerimeter() {
		int perimeter = LENGTH + WIDTH + LENGTH + WIDTH;
		assertEquals(perimeter, validRectangle.perimeter());
	}
}
