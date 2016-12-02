package ss.week3.pw;

public class BasicChecker implements Checker {

	public static final String INITPASS = "kevinenchriszijngeweldig";
	
	@Override
	public boolean acceptable(String password) {
		return !password.contains(" ") && password.length() >= 6;
	}

	@Override
	public String generatePassword() {
		return INITPASS;
	}

}
