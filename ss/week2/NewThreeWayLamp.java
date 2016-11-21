package ss.week2;

public class NewThreeWayLamp {
	
	private Setting setting;
	
	/**
	 * Create a new lamp, Set setting to OFF.
	 */
	/*
	 *@ ensures this.setting = Setting.OFF;
	 */
	public NewThreeWayLamp() {
		setting = Setting.OFF;
	}
	
	/**
	 * Get the current setting of the lamp.
	 * @return current setting of lamp
	 */
	/*@ pure */public Setting getState() {
		return setting;
	}
	
	/**
	 * Switches the setting of the lamp.
	 * Changes to low if setting is high.
	 */
	/*
	 *@ ensures \old(this.getState()) == Setting.OFF ==> this.getState() == Setting.LOW
	 *  ensures \old(this.getState()) == Setting.LOW ==> this.getState() == Setting.MEDIUM
	 *  ensures \old(this.getState()) == Setting.MEDIUM ==> this.getState() == Setting.HIGH
	 *  ensures \old(this.getState()) == Setting.HIGH ==> this.getState() == Setting.OFF
	 */
	public void switchSetting() {
		switch (setting) {
			case OFF:
				this.setting = Setting.LOW;
				return;
			case LOW:
				this.setting = Setting.MEDIUM;
				return;
			case MEDIUM:
				this.setting = Setting.HIGH;
				return;
			case HIGH:
				this.setting = Setting.OFF;
				return;
		}
	}
}
