package ss.week2;

import ss.week3.pw.BasicChecker;
import ss.week3.pw.Checker;

public class Password {
	
	public static final String INITIAL = "password";
	private String password;
	
	private Checker checker;
	private String factoryPassword;
	
	/**
	 * Create a new <code>Password</code> with the initial password set to INITIAL.
	 */
	//@ ensures testWord(INITIAL) == true;
	public Password() {
		this(new BasicChecker());
	}
	
	public Password(Checker checker) {
		this.checker = checker;
		factoryPassword = this.checker.generatePassword();
		
		this.password = factoryPassword;
	}
	
	public Checker getChecker() {
		return checker;
	}
	
	public String getFactoryPassword() {
		return factoryPassword;
	}
	
	/**
	 * Test if a given <code>String</code> is acceptable.
	 * Acceptable:
	 *  - longer than 6 characters
	 *  - contains no spaces
	 * @param suggestion Word to be tested if acceptable
	 * @return true if suggestion is acceptable, false otherwise
	 */
	/*@ pure */public boolean acceptable(String suggestion) {
		return !(suggestion.contains(" ") || suggestion.length() < 6);
	}
	
	/**
	 * Changes the password.
	 * @param oldpass Current password
	 * @param newpass New password
	 * @return true if oldpass is equal to the currentpass
	 * and newpass is acceptable
	 */
	//@ ensures !\old(testWord(oldpass)) ==> testWord(newpass) == false;
	//@ ensures acceptable(newpass) && \old(testWord(oldpass)) ==> testWord(newpass) == true;
	//@ ensures !acceptable(newpass) && testWord(oldpass) ==> testWord(oldpass) == true;
	public boolean setWord(String oldpass, String newpass) {
		if (testWord(newpass) && checker.acceptable(newpass)) {
			this.password = newpass;
			return true;
		}
		return false;
	}
	
	/**
	 * Tests if a given <code>String</code> is equal to the current password.
	 * @param test String to test
	 * @return true if test is equal to current password, false otherwise
	 */
	/*@ pure */public boolean testWord(String test) {
		return this.password.equals(test);
	}
	
}
