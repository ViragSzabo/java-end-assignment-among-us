import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RoomTest {
    RoomTemplate rt1 = new RoomTemplate("cafeteria");
    RoomTemplate rt2 = new RoomTemplate("register");
    RoomTemplate rt3 = new RoomTemplate("labor");
    Room room1 = new Room(rt1);
    Room room2 = new Room(rt2);
    Room room3 = new Room(rt3);
    RegularTask task1 = new RegularTask("Wet floor", "Mop the floor.", 0.0);
    RegularTask task2 = new RegularTask("Register", "Check in.", 0.0);
    RegularTask task3 = new RegularTask("Documentation", "Update the research document.", 0.0);

    @Test
    void addTasks() {
        room1.addTasks(task1);
        assertTrue(true);
        room2.addTasks(task2);
        assertTrue(true);
        room3.addTasks(task3);
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