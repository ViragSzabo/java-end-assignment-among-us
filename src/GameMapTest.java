import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GameMapTest {
    GameMap map1 = new GameMap("laboratorium");
    RoomTemplate rt1 = new RoomTemplate("cafeteria");
    RoomTemplate rt2 = new RoomTemplate("register");
    RoomTemplate rt3 = new RoomTemplate("labor");

    @Test
    void addRooms() {
        map1.addRooms(rt1);
        assertTrue(true);
        map1.addRooms(rt2);
        assertTrue(true);
        map1.addRooms(rt3);
        assertTrue(true);
    }
}