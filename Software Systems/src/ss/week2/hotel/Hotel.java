package ss.week2.hotel;

import ss.week2.Password;
import ss.week2.Safe;

public class Hotel {

	private Password password;
	private String name;

	private Room room1;
	private Room room2;

	//@ invariant getName() != null;
	
	/**
	 * Create new <code>Hotel</code> with name.
	 * @param name Name of hotel
	 */
	//@ requires n != null;
	//@ ensures getName() != null;
	public Hotel(String n) {
		assert n != null;
		
		name = n;
		room1 = new Room(1, new Safe(new Password()));
		room2 = new Room(2, new Safe(new Password()));
		password = new Password();
		
	}

	/**
	 * Get the name of the <code>Hotel</code>.
	 * @return name of the <code>Hotel</code>
	 */
	/*@ pure */public String getName() {
		return name;
	}

	/**
	 * Get an available <code>Room</code>.
	 * @return <code>Room</code>-object if a <code>Room</code> is available, null otherwise
	 */
	/*@ pure */public Room getFreeRoom() {
		if (room1.getGuest() == null) {
			return room1;
		}
		if (room2.getGuest() == null) {
			return room2;
		}
		return null;
	}

	/**
	 * Get <code>Room</code> in which a <code>Guest</code> stays.
	 * @param n Name of the <code>Guest</code>
	 * @return <code>Room</code>-object if the <code>Guest</code> stays in a <code>Room</code>,
	 * null otherwise
	 */
	//@ requires n != null;
	/*@ pure */public Room getRoom(String n) {
		assert n != null;
		
		if (room1.getGuest() != null && room1.getGuest().getName().equals(n)) {
			return room1;
		}
		if (room2.getGuest() != null && room2.getGuest().getName().equals(n)) {
			return room2;
		}
		return null;
	}

	/**
	 * Get the password of the <code>Hotel</code>.
	 * @return password of <code>Hotel</code>
	 */
	/*@ pure */public Password getPassword() {
		return password;
	}

	/**
	 * Get all information about the every <code>Room</code> of the <code>Hotel</code>.
	 * @return String with all information
	 */
	/*@ pure */public String toString() {
		return	"Room " + room1.getNumber() + ":" + "\n" +
				"  Guest name: " + ((room1.getGuest() != null) ? room1.getGuest().getName() : "-") 
					+ "\n" +
				"  Safe:" + "\n" +
				"    Activated: " + room1.getSafe().isActive() + "\n" +
				"    Open: " + room1.getSafe().isOpen() + "\n" + 
				"Room " + room2.getNumber() + ":" + "\n" +
				"  Guest name: " + ((room2.getGuest() != null) ? room2.getGuest().getName() : "-") 
					+ "\n" +
				"  Safe:" + "\n" +
				"    Activated: " + room2.getSafe().isActive() + "\n" +
				"    Open: " + room2.getSafe().isOpen();	
	}

	/**
	 * Check a <code>Guest</code> in into a <code>Room</code>.
	 * @param pass Password of the <code>Hotel</code>
	 * @param n Name of the <code>Guest</code>
	 * @return <code>Room</code>-object if there was a free <code>Room</code>
	 * and the <code>Guest</code> was successfully checked-in, null otherwise
	 */
	//@ requires pass != null;
	//@ requires n != null;
	public Room checkIn(String pass, String n) {
		assert pass != null;
		assert n != null;
		
		Room freeRoom = getFreeRoom();
		if (this.password.testWord(pass)) {
			if (freeRoom != null && getRoom(n) == null) {
				freeRoom.setGuest(new Guest(n));
				return freeRoom;
			}
		}
		return null;
	}

	/**
	 * Check a <code>Guest</code> out of <code>Hotel</code>.
	 * @param n Name of the <code>Guest</code>
	 */
	//@ requires n != null;
	public void checkOut(String n) {
		assert n != null;
		
		Room room = getRoom(n);
		if (room != null) {
			room.getGuest().checkout();
			room.setGuest(null);
			room.getSafe().deactivate();
		}
	}

}
