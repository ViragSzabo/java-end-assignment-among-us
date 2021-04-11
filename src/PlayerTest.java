import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PlayerTest {

    @Test
    void createRoom() {
        Player player0 = new Player("Boomerang", "grey", "pot");
        WaitingRoom wr2 = new WaitingRoom("21rwe21", 1, player0);
        assertTrue(wr2.isPrivate());
    }

    @Test
    void joinRoom() {
        Player player1 = new Player("Flower", "red", "leaf");
        Player player2 = new Player("DrCooper", "black", "train");
        Player player3 = new Player("DrHofstadter", "yellow", "glasses");
        Player player4 = new Player("DrKoothrappali", "orange", "sunglasses");
        WaitingRoom wr1 = new WaitingRoom("21rwe21", 4, player1);

        player1.joinRoom(wr1);
        wr1.addGroupPlayers(player1);
        assertTrue(wr1.getGroupPlayers().contains(player1));
        player2.joinRoom(wr1);
        wr1.addGroupPlayers(player2);
        assertTrue(wr1.getGroupPlayers().contains(player2));
        player3.joinRoom(wr1);
        wr1.addGroupPlayers(player3);
        assertTrue(wr1.getGroupPlayers().contains(player3));
        player4.joinRoom(wr1);
        wr1.addGroupPlayers(player4);
        assertTrue(wr1.getGroupPlayers().contains(player4));
    }
}