package ss.week2.test;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import ss.week2.Password;
import ss.week2.Safe;

public class SafeTest {

	Safe safe;
	String password;

	@Before
	public void setUp() throws Exception {
		password = "password";
		
		Password passwordObject = new Password();
		passwordObject.setWord(Password.INITIAL, password);
		safe = new Safe(passwordObject);
	}

	@Test
	public void testSetup() {
		assertEquals(true, safe.getPassword().testWord(password));
		safe = new Safe(null);
		assertEquals(true, safe.getPassword().testWord(Password.INITIAL));
	}

	@Test
	public void testActivateCorrectPassword() {
		assertEquals(false, safe.isActive());
		safe.activate(password);
		assertEquals(true, safe.isActive());
	}

	@Test
	public void testActivateWrongPassword() {
		assertEquals(false, safe.isActive());
		safe.activate("wrong");
		assertEquals(false, safe.isActive());
		safe.activate(null);
		assertEquals(false, safe.isActive());
		safe.activate("");
		assertEquals(false, safe.isActive());
	}

	@Test
	public void testDeactive() {
		safe.activate(password);
		assertEquals(true, safe.isActive());
		safe.deactivate();
		assertEquals(false, safe.isActive());
	}

	@Test
	public void testOpenCorrectPassword() {
		assertEquals(false, safe.isOpen());
		safe.activate(password);
		assertEquals(true, safe.isActive());
		safe.open(password);
		assertEquals(true, safe.isOpen());
	}

	@Test
	public void testOpenWrongPassword() {
		safe.activate(password);
		assertEquals(true, safe.isActive());
		assertEquals(false, safe.isOpen());
		safe.open("wrong");
		assertEquals(false, safe.isOpen());
		safe.open("");
		assertEquals(false, safe.isOpen());
		safe.open(null);
		assertEquals(false, safe.isOpen());
	}

	@Test
	public void testClose() {
		safe.activate(password);
		assertEquals(true, safe.isActive());
		safe.open(password);
		assertEquals(true, safe.isOpen());
		safe.close();
		assertEquals(false, safe.isOpen());
	}

	@Test
	public void testGetPassword() {
		assertEquals(true, safe.getPassword().testWord(password));
	}

	@Test
	public void testIsOpen() {
		safe.activate(password);
		assertEquals(true, safe.isActive());
		assertEquals(false, safe.isOpen());
		safe.open(password);
		assertEquals(true, safe.isOpen());
	}

	@Test
	public void testIsActivated() {
		assertEquals(false, safe.isActive());
		safe.activate(password);
		assertEquals(true, safe.isActive());
	}

}
