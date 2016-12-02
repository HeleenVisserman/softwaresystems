package ss.week2.test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import ss.week2.Password;
import ss.week2.Safe;

public class SafeTest {

	Safe safe;
	Password password;
	String correctpass = Password.INITIAL;
	String wrongpass = Password.INITIAL + "_invalid";
	
	/**
	 * Set initial values.
	 */
	@Before
	public void setUp() {
		password = new Password();
		safe = new Safe(password);
	}

	/**
	 * Test initial values.
	 */
	@Test
	public void testSetup() {
		assertEquals(password, safe.getPassword());
	}

	/**
	 * Test if safe activates with correct password.
	 */
	@Test
	public void testActivateCorrectPassword() {
		assertFalse(safe.isActive());
		safe.activate(correctpass);
		assertTrue(safe.isActive());
	}

	/**
	 * Test if safe activates with wrong password.
	 */
	@Test
	public void testActivateWrongPassword() {
		assertFalse(safe.isActive());
		safe.activate(wrongpass);
		assertFalse(safe.isActive());
	}

	/**
	 * Test if safe deactivates if it is active.
	 */
	@Test
	public void testDeactive() {
		safe.activate(correctpass);
		assertTrue(safe.isActive());
		safe.deactivate();
		assertFalse(safe.isActive());
	}

	/**
	 * Test if safe opens with correct password.
	 */
	@Test
	public void testOpenCorrectPassword() {
		//First activate the safe
		safe.activate(correctpass);
		
		//Now try to open it
		assertFalse(safe.isOpen());
		safe.open(correctpass);
		assertTrue(safe.isOpen());
	}

	/**
	 * Test if safe opens with wrong password.
	 */
	@Test
	public void testOpenWrongPassword() {
		//First activate the safe
		safe.activate(correctpass);
			
		//Now try to open it
		assertFalse(safe.isOpen());
		safe.open(wrongpass);
		assertFalse(safe.isOpen());
	}

	/**
	 * Test if safe closes when it is open.
	 */
	@Test
	public void testClose() {
		//First activate the safe
		safe.activate(correctpass);
		
		//Then open it
		safe.open(correctpass);
		
		
		//Now try to close it
		assertTrue(safe.isOpen());
		safe.close();
		assertFalse(safe.isOpen());
	}

}
