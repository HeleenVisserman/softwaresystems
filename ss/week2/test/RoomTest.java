package ss.week2.test;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import ss.week2.Password;
import ss.week2.Safe;
import ss.week2.hotel.Guest;
import ss.week2.hotel.Room;

public class RoomTest {
    private Guest guest;
    private Room room;

    @Before
    public void setUp() {
        guest = new Guest("Jip");
        room = new Room(101, new Safe(null));
    }

    @Test
    public void testSetUp() {
        assertEquals(101, room.getNumber());
    }

    @Test
    public void testSetGuest() {
        room.setGuest(guest);
        assertEquals(guest, room.getGuest());
    }
    
    @Test
    public void testGetSafe() {
    	assertEquals(true, room.getSafe().getPassword().testWord(Password.INITIAL));
    	Password word = new Password();
    	word.setWord(Password.INITIAL, "password");
    	room = new Room(101, new Safe(word));
    	assertEquals(true, room.getSafe().getPassword().testWord("password"));
    }
}
