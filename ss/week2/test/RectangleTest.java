package ss.week2.test;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import ss.week2.Rectangle;

public class RectangleTest {

	Rectangle validRectangle;
	public static final int LENGTH = 30;
	public static final int WIDTH = 20;
	
	@Before
	public void setUp() {
		validRectangle = new Rectangle(LENGTH, WIDTH);
	}
	
	@Test
	public void testWidth() {
		assertEquals(WIDTH, validRectangle.width());
	}
	
	@Test
	public void testLength() {
		assertEquals(LENGTH, validRectangle.length());
	}
	
	@Test
	public void testArea() {
		int area = LENGTH * WIDTH;
		assertEquals(area, validRectangle.area());
	}
	
	@Test
	public void testPerimeter() {
		int perimeter = LENGTH + WIDTH + LENGTH + WIDTH;
		assertEquals(perimeter, validRectangle.perimeter());
	}
	
/*
	@Test (expected = AssertionError.class)
	public void testInvalidLength() {
		Rectangle invalid = new Rectangle(-1, WIDTH);
	}
	
	@Test (expected = AssertionError.class)
	public void testInvalidWidth() {
		Rectangle invalid = new Rectangle(LENGTH, -1);
	}
	
	@Test (expected = AssertionError.class)
	public void testInvalidLengthWidth() {
		Rectangle invalid = new Rectangle(-1, -1);
	}
*/
}
