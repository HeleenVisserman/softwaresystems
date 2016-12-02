package ss.week1;

public class Passwordstub {
	
	public static final String INITIAL = "password";
	private String password;
	
	public Passwordstub() {
		this.password = Passwordstub.INITIAL;
	}
	
	public boolean acceptable(String suggestion) {
		return false;
	}
	
	public boolean setWord(String oldpass, String newpass) {
		return false;
	}
	
	public boolean testWord(String test) {
		return false;
	}
	
}
