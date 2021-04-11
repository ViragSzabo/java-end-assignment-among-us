import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class UrgentTaskTest {

    @Test
    void setIsDone() {
        Player player1 = new Player("Flower", "red", "leaf");
        Player player2 = new Player("DrCooper", "black", "train");
        GameMap map1 = new GameMap("laboratorium");
        WaitingRoom wr1 = new WaitingRoom("21rwe21", 2, player1);
        wr1.startGame(map1);
        Game game1 = wr1.getGame();
        RoomTemplate rt1 = map1.getStartRoom();
        Room room1 = new Room(rt1);
        CrewMate e1 = new CrewMate(game1, player1, room1);
        Impostor i1 = new Impostor(game1, player2, room1);

        i1.sabotage(room1);
        assertTrue(room1.isSabotaged());
        e1.fixSabotage(room1);
        assertFalse(room1.isSabotaged());
    }

    @Test
    void getIsUrgent() {
        UrgentTask urgent1 = new UrgentTask("Leaking", "Gas leaking", 0.0);
        RegularTask task3 = new RegularTask("Documentation", "Update the research document.", 0.0);

        assertTrue(urgent1.getIsUrgent());
        assertFalse(task3.getIsUrgent());
    }
}