package ss.week3;

import ss.week3.pw.Password;

/**
 * @author kevin witlox
 * @author chris witteveen
 *
 */
public class Safe {

	private Password password;
	private boolean activated;
	private boolean open;
	
	/**
	 * Test method.
	 * @param args
	 */
	public static void main(String[] args) {
		Safe safe = new Safe(null);
		safe.close();
	}
	
	/**
	 * Create a new <code>Safe</code> instance.
	 * @param password Password of the safe
	 */
	//@ ensures isActive() == false;
	//@ ensures isOpen() == false;
	public Safe(Password pass) {
		password = pass;
		activated = false;
		open = false;
	}
	
	/**
	 * Returns whether the <code>Safe</code> is active.
	 * @return true if <code>Safe</code> is active, false otherwise
	 */
	/*@ pure */public boolean isActive() {
		return activated;
	}
	
	/**
	 * Returns whether the <code>Safe</code> is open.
	 * @return true if <code>Safe</code> is open, false otherwise
	 */
	/*@ pure */public boolean isOpen() {
		return open;
	}
	
	/**
	 * Get the password for the <code>Safe</code> if set.
	 * @return password of <code>Safe</code>
	 */
	/*@ pure */public Password getPassword() {
		return password;
	}
	
	/**
	 * Activate the <code>Safe</code>.
	 * @param password Password with which you try to activate the <code>Safe</code>.
	 */
	//@ requires isActive() == false;
	//@ ensures getPassword().testWord(pass) ==> isActive() == true;
	public void activate(String pass) {
		assert !activated;
		
		if (pass != null && !pass.equals("") && password.testWord(pass)) {
			activated = true;
		}
	}
	
	/**
	 * Deactivate the <code>Safe</code>.
	 */
	//@ requires isActive() == true;
	//@ ensures isActive() == false;
	//@ ensures isOpen() == false;
	public void deactivate() {
		assert activated;
		
		if (open) { 
			this.close(); 
		}
		activated = false;
	}
	
	/**
	 * Open the <code>Safe</code>.
	 * @param password Password with which you try to open the <code>Safe</code>.
	 */
	//@ requires isActive() == true;
	//@ requires isOpen() == false;
	//@ ensures getPassword().testWord(pass) ==> isOpen() == true;
	public void open(String pass) {
		assert !open;
		assert activated;
		
		if (pass != null && !pass.equals("") && password.testWord(pass)) {
			open = true;
		}
	}
	
	/**
	 * Close the <code>Safe</code>.
	 */
	//@ requires isOpen() == true;
	//@ requires isActive() == true;
	//@ ensures isOpen() == false;
	public void close() {
		assert open;
		assert activated;
		
		open = false;
	}
}