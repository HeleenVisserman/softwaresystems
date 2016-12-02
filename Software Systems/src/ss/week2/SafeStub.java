package ss.week2;

public class SafeStub {

	private Password password;
	private boolean activated;
	private boolean open;
	
	/**
	 * Create a new <code>Safe</code> instance.
	 */
	public SafeStub() {
	}
	
	/**
	 * Returns whether the <code>Safe</code> is active.
	 * @return true if <code>Safe</code> is active, false otherwise
	 */
	public boolean isActive() {
		return false;
	}
	
	/**
	 * Returns whether the <code>Safe</code> is open.
	 * @return true if <code>Safe</code> is open, false otherwise
	 */
	public boolean isOpen() {
		return false;
	}
	
	/**
	 * Get the password for the <code>Safe</code> if set.
	 * @return password of <code>Safe</code>
	 */
	public Password getPassword() {
		return null;
	}
	
	/**
	 * Activate the <code>Safe</code>.
	 * @param password Password with which you try to activate the <code>Safe</code>.
	 */
	/*
	 *@ requires activated == false;
	 *  requires inputPassword != null;
	 *  requires inputPassword != "";
	 *  ensures activated = true;
	 */
	public void activate(String inputPassword) {
	}
	
	/**
	 * Deactivate the <code>Safe</code>.
	 */
	/*
	 *@ requires activated == true;
	 *  ensures activated = false;
	 *  ensures open = false;
	 */
	public void deactivate() {
	}
	
	/**
	 * Open the <code>Safe</code>.
	 * @param password Password with which you try to open the <code>Safe</code>.
	 */
	/*
	 *@ requires open == false;
	 *  requires inputPassword != null;
	 *  requires inputPassword != "";
	 *  ensures open = true;
	 */
	public void open(String inputPassword) {
	}
	
	/**
	 * Close the <code>Safe</code>.
	 */
	/*
	 *@ requires open == true;
	 *  ensures open = false;
	 */
	public void close() {
	}
	
}
