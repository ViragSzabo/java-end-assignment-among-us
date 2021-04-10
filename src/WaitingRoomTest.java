import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class WaitingRoomTest {
    Application app1 = new Application("amongUs");
    GameMap map1 = new GameMap("laboratorium");
    Player player1 = new Player("Flower", "red", "leaf");
    Player player2 = new Player("DrCooper", "black", "train");
    Player player3 = new Player("DrHofstadter", "yellow", "glasses");
    Player player4 = new Player("DrKoothrappali", "orange", "sunglasses");
    WaitingRoom wr1 = new WaitingRoom("21rwe21", 4, player1);

    @Test
    void addGroupPlayers() {
        wr1.addGroupPlayers(player1);
        assertTrue(true);
        wr1.addGroupPlayers(player2);
        assertTrue(true);
        wr1.addGroupPlayers(player3);
        assertTrue(true);
        wr1.addGroupPlayers(player4);
        assertTrue(true);
    }

    @Test
    void startGame() {
        wr1.startGame(map1);
        assertTrue(true);
    }
}