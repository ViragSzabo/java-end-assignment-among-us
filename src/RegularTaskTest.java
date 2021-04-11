import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RegularTaskTest {

    @Test
    void setIsDone() {
        Player player1 = new Player("Flower", "red", "leaf");
        GameMap map1 = new GameMap("laboratorium");
        WaitingRoom wr1 = new WaitingRoom("21rwe21", 4, player1);
        RoomTemplate rt1 = map1.getStartRoom();
        Room room1 = new Room(rt1);
        wr1.startGame(map1);
        Game game1 = wr1.getGame();
        CrewMate e1 = new CrewMate(game1, player1, room1);
        RegularTask task1 = new RegularTask("Wet floor", "Mop the floor.", 0.0);

        e1.doTask(task1);
        assertTrue(task1.getIsDone());
    }

    @Test
    void getIsUrgent() {
        RegularTask task2 = new RegularTask("Register", "Check in.", 0.0);
        UrgentTask urgent1 = new UrgentTask("Leaking", "Gas leaking", 0.0);

        assertFalse(task2.getIsUrgent());
        assertTrue(urgent1.getIsUrgent());
    }
}