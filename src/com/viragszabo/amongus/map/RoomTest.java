package com.viragszabo.amongus.map;

import com.viragszabo.amongus.task.RegularTask;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RoomTest {

    @Test
    void addTasks() {
        GameMap map1 = new GameMap("laboratorium");
        RoomTemplate rt1 = map1.getStartRoom();
        Room room1 = new Room(rt1);
        RoomTemplate rt2 = new RoomTemplate("register");
        Room room2 = new Room(rt2);
        map1.addRoom(rt2);
        RoomTemplate rt3 = new RoomTemplate("register");
        Room room3 = new Room(rt3);
        map1.addRoom(rt3);
        RegularTask task1 = new RegularTask("Wet floor", "Mop the floor.", 0.0);
        RegularTask task2 = new RegularTask("Register", "Check in.", 0.0);
        RegularTask task3 = new RegularTask("Documentation", "Update the research document.", 0.0);

        room1.addTasks(task1);
        assertTrue(room1.getTasks().contains(task1));
        room2.addTasks(task2);
        assertTrue(room2.getTasks().contains(task2));
        room3.addTasks(task3);
        assertTrue(room3.getTasks().contains(task3));
    }

    @Test
    void hasDoorTo() {
        GameMap map1 = new GameMap("laboratorium");
        RoomTemplate rt1 = map1.getStartRoom();
        Room room1 = new Room(rt1);
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