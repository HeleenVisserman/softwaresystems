package ss.week3.pw;

public class StrongChecker extends BasicChecker {

	public static final String INITPASS = "kevinenchriszijngeweldig123";
	
	@Override
	public boolean acceptable(String password) {
		return super.acceptable(password) 
				&& Character.isLetter(password.charAt(0)) 
				&& Character.isDigit(password.charAt(password.length() - 1));
	}
	
	@Override
	public String generatePassword() {
		return INITPASS;
	}
	
}
