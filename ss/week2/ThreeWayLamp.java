package ss.week2;

public class ThreeWayLamp {
	
	public static final int OFF = 0;
	public static final int LOW = 1;
	public static final int MEDIUM = 2;
	public static final int HIGH = 3;
	public static final int SETTINGCOUNT = 4;
	
	private int setting;
	
	/**
	 * Create a new lamp, Set setting to OFF
	 */
	/*
	 *@ ensures this.setting = OFF;
	 */
	public ThreeWayLamp() {
		setting = OFF;
	}
	
	/**
	 * Get the current setting of the lamp
	 * @return current setting of lamp
	 */
	/*
	 *@ ensures \result >= OFF;
	 *  ensures \result <= HIGH;
	 */
	/*@ pure */public int getState() {
		assert this.setting >= OFF;
		assert this.setting <= HIGH;
		
		return setting;
	}
	
	/**
	 * Switches the setting of the lamp
	 * Changes to low if setting is high
	 */
	/*
	 *@ requires this.setting >= OFF;
	 *  requires this.setting <= HIGH;
	 *  ensures \old(this.getState()) == OFF ==> this.getState() == LOW
	 *  ensures \old(this.getState()) == LOW ==> this.getState() == MEDIUM
	 *  ensures \old(this.getState()) == MEDIUM ==> this.getState() == HIGH
	 *  ensures \old(this.getState()) == HIGH ==> this.getState() == OFF
	 */
	public void switchSetting() {
		assert this.setting >= OFF;
		assert this.setting <= HIGH;
		
		setting = (setting + 1) % SETTINGCOUNT;
	}
	
}
