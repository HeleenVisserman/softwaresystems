package ss.week3.hotel;

/**
 * Guest with name and room
 * @author Kevin Witlox, Chris Witteveen
 * @version 0.0.5
 */
public class Guest {

	Room room;
	String name;
	
	/**
	 * Initialize new <code>Guest</code> with a name
	 * @param name Name of the guest
	 */
	public Guest(String name) {
		this.name = name;
	}
	
	/**
	 * Get <code>Room</code> of the <code>Guest</code>
	 * @return room
	 */
	public Room getRoom() {
		return room;
	}
	
	/**
	 * Get the name of the <code>Guest</code>
	 * @return name
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * Checks the Guest in into a room
	 * @param r <code>Room</code> the <code>Guest</code> should be checked in
	 * @return false on a fail, else true
	 */
	public boolean checkin(Room r) {
		if (r.getGuest() == null) {
			r.setGuest(this);
			room = r;
			return true;
		}
		return false;
	}
	
	/**
	 * Check the <code>Guest</code> out
	 * @return true if the guest was checked out, else false
	 */
	public boolean checkout() {
		if (room != null) {
			room.setGuest(null);
			room = null;
			return true;
		}
		return false;
	}
	
	/**
	 * Serialize <code>Guest</code> 
	 * @return "Guest " + the name of the Guest
	 */
	public String toString() {
		return "Guest " + name;
	}
	
}
