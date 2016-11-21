package ss.week2.hotel;

import ss.week2.Password;
import ss.week2.Safe;

public class Hotel {

	private Password password;
	private String name;

	private Room room1;
	private Room room2;

	public Hotel(String name) {
		this.name = name;
		this.room1 = new Room(1, new Safe(null));
		this.room2 = new Room(2, new Safe(null));
		this.password = new Password();
		
	}

	public String getName() {
		return name;
	}

	public Room getFreeRoom() {
		return (room1.getGuest() == null || room2.getGuest() == null) ? (room1.getGuest() == null ? room1 : room2)
				: null;
	}

	public Room getRoom(String name) {
		if (room1.getGuest() != null && room1.getGuest().getName().equals(name))
			return room1;
		if (room2.getGuest() != null && room2.getGuest().getName().equals(name))
			return room2;
		return null;
	}

	public Password getPassword() {
		return password;
	}

	public String toString() {
		return "Room " + room1.getNumber() + ": { Guest name: "
				+ ((room1.getGuest() != null) ? room1.getGuest().getName() : "null") + ", safe: {"
				+ (room1.getSafe().isActive() ? "activated" : "deactivated") + ", "
				+ (room1.getSafe().isOpen() ? "open" : "closed") + "} }" + "\n" + "Room " + room2.getNumber()
				+ ": { Guest name: " + ((room2.getGuest() != null) ? room2.getGuest().getName() : "null") + ", safe: {"
				+ (room2.getSafe().isActive() ? "activated" : "deactivated") + ", "
				+ (room2.getSafe().isOpen() ? "open" : "closed") + "} }";
	}

	public Room checkIn(String password, String name) {
		Room freeRoom = getFreeRoom();
		if (this.password.testWord(password)) {
			if (freeRoom != null && getRoom(name) == null) {
				freeRoom.setGuest(new Guest(name));
				return freeRoom
						;
			}
		}

		return null;
	}

	public void checkOut(String name) {
		Room room = getRoom(name);
		if (room != null) {
			room.getGuest().checkout();
			room.setGuest(null);
			room.getSafe().deactivate();
		}
	}

}
