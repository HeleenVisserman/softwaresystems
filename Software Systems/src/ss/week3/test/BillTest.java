package ss.week3.test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import ss.week3.hotel.Bill;
import ss.week3.hotel.TestItem;

public class BillTest {

	Bill billWithStream;
	Bill billWithoutStream;
	
	@Before
	public void setUp() throws Exception {
		billWithStream = new Bill(System.out);
		billWithoutStream = new Bill(null);
	}

	//overbodig
	@Test
	public void testAddItem() {
		//nothing to be tested, just no error expected
		billWithStream.addNewItem(new TestItem("test1", 1.00));
		billWithoutStream.addNewItem(new TestItem("test2", 1.00));
	}
	
	@Test
	public void testGetSum() {
		assertEquals(0.00, billWithStream.getSum(), 0);
		billWithStream.addNewItem(new TestItem("Kaas", 1.00));
		assertEquals(1.00, billWithStream.getSum(), 0);
		billWithStream.addNewItem(new TestItem("Is", 2.00));
		assertEquals(3.00, billWithStream.getSum(), 0);
		
		assertEquals(0.00, billWithoutStream.getSum(), 0);
		billWithoutStream.addNewItem(new TestItem("Kaas", 1.00));
		assertEquals(1.00, billWithoutStream.getSum(), 0);
		billWithoutStream.addNewItem(new TestItem("Is", 2.00));
		assertEquals(3.00, billWithoutStream.getSum(), 0);
	}
	
	@Test
	public void testClose() {
		billWithStream.addNewItem(new TestItem("Kaas", 24.00));
		billWithStream.close();
		
		billWithoutStream.addNewItem(new TestItem("Kaas", 87.00));
		billWithoutStream.close();
	}

}
