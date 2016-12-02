package ss.week1;

public class ThreeWayLamp {
	
	public static final int OFF = 0;
	public static final int LOW = 1;
	public static final int MEDIUM = 2;
	public static final int HIGH = 3;
	public static final int SETTINGCOUNT = 4;
	
	private int setting;
	
	public ThreeWayLamp() {
		setting = OFF;
	}
	
	public int getCurrentSetting() {
		return setting;
	}
	
	public void switchSetting() {
		setting = (setting + 1) % SETTINGCOUNT;
	}
	
}
