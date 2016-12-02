package ss.week2;

/**
 * @author Kevin Witlox Chris Witteveen
 */
public class Safe {

	private Password password;
	private boolean activated;
	private boolean open;
	
	public static void main(String[] args) {
		Safe safe = new Safe(null);
		safe.close();
	}
	
	/**
	 * Create a new <code>Safe</code> instance.
	 */
	public Safe(Password password) {
		if (password == null)
			this.password = new Password();
		else
			this.password = password;
		
		activated = false;
		open = false;
	}
	
	/**
	 * Returns whether the <code>Safe</code> is active.
	 * @return true if <code>Safe</code> is active, false otherwise
	 */
	public boolean isActive() {
		return activated;
	}
	
	/**
	 * Returns whether the <code>Safe</code> is open.
	 * @return true if <code>Safe</code> is open, false otherwise
	 */
	public boolean isOpen() {
		return open;
	}
	
	/**
	 * Get the password for the <code>Safe</code> if set.
	 * @return password of <code>Safe</code>
	 */
	public Password getPassword() {
		return password;
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
		assert !activated;
		if (inputPassword != null && inputPassword != "" && password.testWord(inputPassword))
			activated = true;
			
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
		assert activated;
		assert !open;
		activated = false;
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
		assert !open;
		assert activated;
		if (inputPassword != null && inputPassword != "" && password.testWord(inputPassword))
			open = true;
	}
	
	/**
	 * Close the <code>Safe</code>.
	 */
	/*
	 *@ requires open == true;
	 *  requires activated == true;
	 *  ensures open = false;
	 */
	public void close() {
		assert open;
		assert activated;
		open = false;
	}
	
}
