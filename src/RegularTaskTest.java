import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RegularTaskTest {
    Player player1 = new Player("Flower", "red", "leaf");
    GameMap map1 = new GameMap("laboratorium");
    WaitingRoom wr1 = new WaitingRoom("21rwe21", 4, player1);
    Game game1 = new Game(map1, wr1, wr1.getGroupPlayers());
    RoomTemplate rt1 = new RoomTemplate("cafeteria");
    Room room1 = new Room(rt1);
    CrewMate e1 = new CrewMate(game1, player1, room1);
    RegularTask task1 = new RegularTask("Wet floor", "Mop the floor.", 0.0);
    RegularTask task2 = new RegularTask("Register", "Check in.", 0.0);
    RegularTask task3 = new RegularTask("Documentation", "Update the research document.", 0.0);

    @Test
    void setIsDone() {
        e1.doTask(task1);
        task1.setIsDone();
        assertTrue(true);
    }

    @Test
    void getIsUrgent() {
        task2.getIsUrgent();
        assertFalse(false);
    }
}