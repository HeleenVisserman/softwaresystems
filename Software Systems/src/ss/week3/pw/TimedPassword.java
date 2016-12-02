package ss.week3.pw;

public class TimedPassword extends Password {

	/*
	 * Excercises:
	 * 	3.7 -> You won't be able to change the password
	 */
	
	private long validTime;
	private long timestamp;
	
	public TimedPassword() {
		this(1);
	}
	
	public TimedPassword(long validTime) {
		this.timestamp = System.currentTimeMillis() + (validTime * 1000);
		this.validTime = validTime;
	}
	
	public boolean isExpired() {
		return System.currentTimeMillis() > timestamp;
		
	}
	
	public boolean setWord(String oldpass, String newpass) {
		if (super.setWord(oldpass, newpass)) {
			this.timestamp = System.currentTimeMillis() + (validTime * 1000);
			return true;
		}
		return false;
	}
	
}
