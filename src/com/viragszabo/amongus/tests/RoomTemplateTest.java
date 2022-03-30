import com.viragszabo.amongus.map.GameMap;
import com.viragszabo.amongus.map.Room;
import com.viragszabo.amongus.map.RoomTemplate;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RoomTemplateTest {
    GameMap map1 = new GameMap("laboratorium");
    RoomTemplate rt1 = new RoomTemplate("hall");
    RoomTemplate rt2 = new RoomTemplate("register");
    RoomTemplate rt3 = new RoomTemplate("cafeteria");

    @Test
    void addDoorTo() {
        rt1 = map1.getStartRoom();
        map1.addRoom(rt2);
        map1.addRoom(rt3);

        rt1.addDoorTo(rt2);
        assertTrue(rt1.hasDoorTo(rt2));
        rt2.addDoorTo(rt3);
        assertTrue(rt2.hasDoorTo(rt3));
    }

    @Test
    void hasDoorTo() {
        rt1 = map1.getStartRoom();
        map1.addRoom(rt2);
        map1.addRoom(rt3);

        assertFalse(rt1.hasDoorTo(rt2));
        rt1.addDoorTo(rt2);
        assertTrue(rt1.hasDoorTo(rt2));

        assertFalse(rt2.hasDoorTo(rt3));
        rt2.addDoorTo(rt3);
        assertTrue(rt2.hasDoorTo(rt3));
    }
}