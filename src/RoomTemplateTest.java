import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RoomTemplateTest {

    @Test
    void addDoorTo() {
        GameMap map1 = new GameMap("laboratorium");
        RoomTemplate rt1 = map1.getStartRoom();
        RoomTemplate rt2 = new RoomTemplate("register");
        Room room2 = new Room(rt2);
        map1.addRoom(rt2);
        RoomTemplate rt3 = new RoomTemplate("register");
        Room room3 = new Room(rt3);
        map1.addRoom(rt3);

        rt1.addDoorTo(rt2);
        assertTrue(rt1.hasDoorTo(rt2));
        rt2.addDoorTo(rt3);
        assertTrue(rt2.hasDoorTo(rt3));
    }

    @Test
    void hasDoorTo() {
        GameMap map1 = new GameMap("laboratorium");
        RoomTemplate rt1 = map1.getStartRoom();
        RoomTemplate rt2 = new RoomTemplate("register");
        Room room2 = new Room(rt2);
        map1.addRoom(rt2);
        RoomTemplate rt3 = new RoomTemplate("register");
        Room room3 = new Room(rt3);
        map1.addRoom(rt3);

        assertFalse(rt1.hasDoorTo(rt2));
        rt1.addDoorTo(rt2);
        assertTrue(rt1.hasDoorTo(rt2));

        assertFalse(rt2.hasDoorTo(rt3));
        rt2.addDoorTo(rt3);
        assertTrue(rt2.hasDoorTo(rt3));
    }
}