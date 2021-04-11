import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class ApplicationTest {

    @Test
    void addGame() {
        Application app1 = new Application("amongUs");
        Player player1 = new Player("Flower", "red", "leaf");
        WaitingRoom wr1 = new WaitingRoom("21rwe21", 1, player1);
        GameMap map1 = new GameMap("laboratorium");
        wr1.startGame(map1);
        Game game1 = wr1.getGame();

        app1.addGame(game1);
        assertTrue(app1.getGames().contains(game1));
    }

    @Test
    void addPlayer() {
        Application app1 = new Application("amongUs");
        Player player1 = new Player("Flower", "red", "leaf");

        app1.addPlayer(player1);
        assertTrue(app1.getPlayers().contains(player1));
    }

    @Test
    void addGameMap() {
        Application app1 = new Application("amongUs");
        GameMap map1 = new GameMap("laboratorium");

        app1.addGameMap(map1);
        assertTrue(app1.getGameMaps().contains(map1));
    }
}