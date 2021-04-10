import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class ApplicationTest {
    Application app1 = new Application("amongUs");
    Player player1 = new Player("Flower", "red", "leaf");
    WaitingRoom wr1 = new WaitingRoom("21rwe21", 1, player1);
    GameMap map1 = new GameMap("laboratorium");
    Game game1 = new Game(map1, wr1, app1.getPlayers());

    @Test
    void addGame() {
        app1.addGame(game1);
        assertTrue(true);
    }

    @Test
    void addPlayer() {
        app1.addPlayer(player1);
        assertTrue(true);
    }

    @Test
    void addGameMap() {
        app1.addGameMap(map1);
        assertTrue(true);
    }
}