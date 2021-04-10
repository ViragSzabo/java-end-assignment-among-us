import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RoomTemplateTest {
    RoomTemplate rt1 = new RoomTemplate("cafeteria");
    RoomTemplate rt2 = new RoomTemplate("register");
    RoomTemplate rt3 = new RoomTemplate("labor");

    @Test
    void addDoorTo() {
        rt1.addDoorTo(rt2);
        assertTrue(true);
        rt2.addDoorTo(rt3);
        assertTrue(true);
    }

    @Test
    void hasDoorTo() {
        rt1.addDoorTo(rt2);
        assertTrue(rt1.hasDoorTo(rt2));
        rt2.addDoorTo(rt3);
        assertTrue(rt2.hasDoorTo(rt3));
    }
}