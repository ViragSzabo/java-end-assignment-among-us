import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PlayerTest {

    Player player0 = new Player("Boomerang", "grey", "pot");

    @Test
    void createRoom() {
        WaitingRoom wr2 = new WaitingRoom("21rwe21", 4, player0);
        assertTrue(true);
    }

    @Test
    void joinRoom() {
        Player player1 = new Player("Flower", "red", "leaf");
        Player player2 = new Player("DrCooper", "black", "train");
        Player player3 = new Player("DrHofstadter", "yellow", "glasses");
        Player player4 = new Player("DrKoothrappali", "orange", "sunglasses");
        WaitingRoom wr1 = new WaitingRoom("21rwe21", 4, player1);
        player1.joinRoom(wr1);
        assertTrue(true);
        player2.joinRoom(wr1);
        assertTrue(true);
        player3.joinRoom(wr1);
        assertTrue(true);
        player4.joinRoom(wr1);
        assertTrue(true);
    }
}