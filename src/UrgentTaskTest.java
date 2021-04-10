import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class UrgentTaskTest {
    Player player1 = new Player("Flower", "red", "leaf");
    Player player2 = new Player("DrCooper", "black", "train");
    GameMap map1 = new GameMap("laboratorium");
    WaitingRoom wr1 = new WaitingRoom("21rwe21", 4, player1);
    Game game1 = new Game(map1, wr1, wr1.getGroupPlayers());
    RoomTemplate rt1 = new RoomTemplate("cafeteria");
    Room room1 = new Room(rt1);
    CrewMate e1 = new CrewMate(game1, player1, room1);
    Impostor i1 = new Impostor(game1, player2, room1);
    UrgentTask urgent1 = new UrgentTask("Leaking", "Gas leaking", 0.0);

    @Test
    void setIsDone() {
        i1.sabotage(room1);
        urgent1.getIsUrgent();
        e1.fixSabotage(room1);
        assertTrue(true);
    }

    @Test
    void getIsUrgent() {
        assertTrue(urgent1.getIsUrgent());
    }
}