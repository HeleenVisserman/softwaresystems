package ss.week1;

public class Student {
	
	int score;
	
	public boolean passed() {
		if (score >= 70) {
			return true;
		}
		return false;
	}
	
}
