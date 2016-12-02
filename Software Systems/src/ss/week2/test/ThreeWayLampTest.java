package ss.week2.test;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import ss.week2.NewThreeWayLamp;
import ss.week2.Setting;

public class ThreeWayLampTest {

	NewThreeWayLamp lamp;
	
	@Before
	public void setUp() {
		lamp = new NewThreeWayLamp();
	}
	
	@Test
	public void testSettingOFF() {
		assertEquals(Setting.OFF, lamp.getState());
	}
	
	@Test
	public void testSettingLOW() {
		lamp.switchSetting();
		assertEquals(Setting.LOW, lamp.getState());
	}
	
	@Test
	public void testSettingMEDIUM() {
		lamp.switchSetting();
		lamp.switchSetting();
		assertEquals(Setting.MEDIUM, lamp.getState());
	}
	
	@Test
	public void testSettingHIGH() {
		lamp.switchSetting();
		lamp.switchSetting();
		lamp.switchSetting();
		assertEquals(Setting.HIGH, lamp.getState());
	}
	
	@Test
	public void testSettingHIGHToOFF() {
		lamp.switchSetting();
		lamp.switchSetting();
		lamp.switchSetting();
		lamp.switchSetting();
		assertEquals(Setting.OFF, lamp.getState());
	}
	
}
