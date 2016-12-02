package ss.week1;

public class Password {
	
	public static final String INITIAL = "password";
	private String password;
	
	public Password() {
		this.password = Password.INITIAL;
	}
	
	public boolean acceptable(String suggestion) {
		if (suggestion.contains(" ") || suggestion.length() < 6) {
			return false;
		} else {
			return true;
		}
	}
	
	public boolean setWord(String oldpass, String newpass) {
		if (this.password == oldpass) {
			if (acceptable(newpass)) {
				this.password = newpass;
				return true;
			}
		}
		return false;
	}
	
	public boolean testWord(String test) {
		return this.password.equals(test);
	}
	
}
