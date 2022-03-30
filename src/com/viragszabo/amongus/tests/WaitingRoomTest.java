import com.viragszabo.amongus.game.Player;
import com.viragszabo.amongus.game.WaitingRoom;
import com.viragszabo.amongus.map.GameMap;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class WaitingRoomTest {
    GameMap map1 = new GameMap("laboratorium");
    Player player1 = new Player("Flower", "red", "leaf");
    Player player2 = new Player("DrCooper", "black", "train");
    Player player3 = new Player("DrHofstadter", "yellow", "glasses");
    Player player4 = new Player("DrKoothrappali", "orange", "sunglasses");
    WaitingRoom wr1 = new WaitingRoom("21rwe21", 4, player1);

    @Test
    void addGroupPlayers() {
        wr1.addGroupPlayers(player1);
        assertTrue(wr1.getGroupPlayers().contains(player1));
        wr1.addGroupPlayers(player2);
        assertTrue(wr1.getGroupPlayers().contains(player2));
        wr1.addGroupPlayers(player3);
        assertTrue(wr1.getGroupPlayers().contains(player3));
        wr1.addGroupPlayers(player4);
        assertTrue(wr1.getGroupPlayers().contains(player4));
    }

    @Test
    void startGame() {
        assertTrue(wr1.getGame() == null);
        wr1.startGame(map1);
        assertTrue(wr1.getGame() == null);
        wr1.addGroupPlayers(player1);
        wr1.addGroupPlayers(player2);
        wr1.addGroupPlayers(player3);
        wr1.addGroupPlayers(player4);
        wr1.startGame(map1);
        assertTrue(wr1.getGame() != null);
    }
}