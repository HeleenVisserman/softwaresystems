package ss.week1;

public class TWLTest {

	public static void main(String[] args) {
		ThreeWayLamp lamp = new ThreeWayLamp();
		
		System.out.println(lamp.getCurrentSetting());
		
		for (int i = 0; i < 7; i++) {
			lamp.switchSetting();
			System.out.println(lamp.getCurrentSetting());
		}
		
	}
	
}
