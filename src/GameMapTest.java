import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GameMapTest {

    @Test
    void addRooms() {
        GameMap map1 = new GameMap("laboratorium");
        RoomTemplate rt1 = map1.getStartRoom();
        RoomTemplate rt2 = new RoomTemplate("register");
        RoomTemplate rt3 = new RoomTemplate("labor");


        assertFalse(map1.getRooms().contains(rt2));
        map1.addRoom(rt2);
        assertTrue(map1.getRooms().contains(rt2));

        assertFalse(map1.getRooms().contains(rt3));
        map1.addRoom(rt3);
        assertTrue(map1.getRooms().contains(rt3));
    }
}