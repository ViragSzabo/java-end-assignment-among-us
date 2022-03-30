import com.viragszabo.amongus.game.Application;
import com.viragszabo.amongus.game.Game;
import com.viragszabo.amongus.game.Player;
import com.viragszabo.amongus.game.WaitingRoom;
import com.viragszabo.amongus.map.GameMap;
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
        assertTrue(app1.getGames().contains(game1));
    }

    @Test
    void addPlayer() {
        app1.addPlayer(player1);
        assertTrue(app1.getPlayers().contains(player1));
    }

    @Test
    void addGameMap() {
        app1.addGameMap(map1);
        assertTrue(app1.getGameMaps().contains(map1));
    }
}