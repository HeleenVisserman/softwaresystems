package ss.week3.hotel;

import ss.week3.Safe;

/**
 * Hotel room with number and possibly a guest.
 * @author Arend Rensink
 * @version $Revision: 1.2 $
 */
public class Room {
    // ------------------ Instance variables ----------------

    private int number;
    private Guest guest;
    private Safe safe;

    // ------------------ Constructor ------------------------

    /**
     * Creates a <code>Room</code> with the given number and a safe, without a guest.
     * @param no number of the new <code>Room</code>
     * @param sf Safe of the new <code>Room</code>
     */
    public Room(int no, Safe sf) {
    	number = no;
    	safe = sf;
    }

    // ------------------ Queries --------------------------

    /**
     * Returns the number of this <code>Room</code>.
     */
    public int getNumber() {
    	return number;
    }

    /**
     * Returns the current guest living in this <code>Room</code>.
     * @return the guest of this <code>Room</code>;
     *         <code>null</code> if this <code>Room</code> 
     *         is not currently rented
     */
    public Guest getGuest() {
    	return guest;
    }
    
    /**
     * Return the safe of this <code>Room</code>.
     * @return safe Safe of this <code>Room</code>
     */
    public Safe getSafe() {
    	return safe;
    }

    // ------------------ Commands --------------------------

    /**
     * Assigns a <code>Guest</code> to this <code>Room</code>.
     * @param g the next guest renting this <code>Room</code>;
     *        if <code>null</code> is passed, this <code>Room</code>
     *        is empty afterwards
     */
    public void setGuest(Guest g) {
    	guest = g;
    }
    
    /**
     * Serialize the <code>Room</code>.
     * @return "Room " + room number
     */
    @Override
    public String toString() {
    	return "Room " + number;
    }
}
