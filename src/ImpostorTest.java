import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class ImpostorTest {
    Application app1 = new Application("amongUs");
    Player player1 = new Player("Flower", "red", "leaf");
    Player player2 = new Player("DrCooper", "black", "train");
    WaitingRoom wr1 = new WaitingRoom("21rwe21", 1, player1);
    GameMap map1 = new GameMap("laboratorium");
    Game game1 = new Game(map1, wr1, app1.getPlayers());
    RoomTemplate rt1 = new RoomTemplate("cafeteria");
    Room room1 = new Room(rt1);
    CrewMate e1 = new CrewMate(game1, player1, room1);
    Impostor i1 = new Impostor(game1, player2, room1);

    @Test
    void kill() {
        i1.kill(e1);
        assertTrue(true);
    }

    @Test
    void sabotage() {
        i1.sabotage(room1);
        assertTrue(true);
    }
}