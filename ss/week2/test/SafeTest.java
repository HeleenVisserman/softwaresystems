package ss.week2.test;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import ss.week2.Password;
import ss.week2.Safe;

public class SafeTest {

	Safe safe;

	@Before
	public void setUp() throws Exception {
		safe = new Safe(new Password());
	}

	@Test
	public void testSetup() {
		assertEquals(true, safe.getPassword().testWord(Password.INITIAL));
	}

	@Test
	public void testActivateCorrectPassword() {
		assertEquals(false, safe.isActive());
		safe.activate(Password.INITIAL);
		assertEquals(true, safe.isActive());
	}

	@Test
	public void testActivateWrongPassword() {
		assertEquals(false, safe.isActive());
		safe.activate("wrong");
		assertEquals(false, safe.isActive());
	}

	@Test
	public void testDeactive() {
		safe.activate(Password.INITIAL);
		assertEquals(true, safe.isActive());
		safe.deactivate();
		assertEquals(false, safe.isActive());
	}

	@Test
	public void testOpenCorrectPassword() {
		safe.open(Password.INITIAL);
		assertEquals(true, safe.isOpen());
	}

	@Test
	public void testOpenWrongPassword() {
		safe.open("wrong");
		assertEquals(false, safe.isOpen());
	}

	@Test
	public void testClose() {
		safe.open(Password.INITIAL);
		assertEquals(true, safe.isOpen());
		safe.close();
		assertEquals(false, safe.isOpen());
	}

	@Test
	public void testGetPassword() {
		assertEquals(Password.INITIAL, safe.getPassword());
	}

	@Test
	public void testIsOpen() {
		assertEquals(false, safe.isOpen());
		safe.open(Password.INITIAL);
		assertEquals(true, safe.isOpen());
	}

	@Test
	public void testIsActivated() {
		assertEquals(true, safe.isActive());
		safe = new Safe(null);
		assertEquals(false, safe.isActive());
	}

}
