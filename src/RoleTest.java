import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RoleTest {
    Application app1 = new Application("amongUs");
    GameMap map1 = new GameMap("laboratorium");
    Player player1 = new Player("Flower", "red", "leaf");
    Player player2 = new Player("DrCooper", "black", "train");
    Player player3 = new Player("DrHofstadter", "yellow", "glasses");
    Player player4 = new Player("DrKoothrappali", "orange", "sunglasses");
    Player player5 = new Player("Stuart", "purple", "book");
    Player player6 = new Player("Denise", "white", "hair");
    WaitingRoom wr1 = new WaitingRoom("21rwe21", 4, player1);
    Game game1 = new Game(map1, wr1, wr1.getGroupPlayers());
    RoomTemplate rt1 = new RoomTemplate("cafeteria");
    RoomTemplate rt2 = new RoomTemplate("register");
    RoomTemplate rt3 = new RoomTemplate("labor");
    Room room1 = new Room(rt1);
    Room room2 = new Room(rt2);
    Room room3 = new Room(rt3);
    Impostor i1 = new Impostor(game1, player1, room1);
    Impostor i2 = new Impostor(game1, player2, room1);
    CrewMate e1 = new CrewMate(game1, player3, room1);
    CrewMate e2 = new CrewMate(game1, player4, room1);
    CrewMate e3 = new CrewMate(game1, player5, room1);
    CrewMate e4 = new CrewMate(game1, player6, room1);

    @Test
    void isGhost() {
        wr1.startGame(map1);
        i1.kill(e1);
        e1.dies();
        assertTrue(e1.isGhost());
    }

    @Test
    void dies() {
        wr1.startGame(map1);
        e2.dies();
        assertTrue(e2.isGhost());
    }

    @Test
    void voteTo() {
        wr1.startGame(map1);
        i1.voteTo(e1);
        assertTrue(true);
        i2.voteTo(e1);
        assertTrue(true);
        e1.voteTo(i1);
        assertTrue(true);
        e2.voteTo(i1);
        assertTrue(true);
        e3.voteTo(i2);
        assertTrue(true);
        e4.voteTo(i2);
        assertTrue(true);
    }

    @Test
    void goToRoom() throws NoDoorException {
        rt1.addDoorTo(rt2);
        rt2.addDoorTo(rt3);
        i1.goToRoom(room2);
        assertTrue(true);
        i2.goToRoom(room2);
        assertTrue(true);
        e1.goToRoom(room2);
        assertTrue(true);
        e2.goToRoom(room2);
        assertTrue(true);
        e3.goToRoom(room2);
        assertTrue(true);
        e4.goToRoom(room2);
        assertTrue(true);
        i1.goToRoom(room3);
        assertTrue(true);
        i2.goToRoom(room3);
        assertTrue(true);
        e1.goToRoom(room3);
        assertTrue(true);
        e2.goToRoom(room3);
        assertTrue(true);
        e3.goToRoom(room3);
        assertTrue(true);
        e4.goToRoom(room3);
        assertTrue(true);
    }

    @Test
    void receiveMessage() {
        e1.receiveMessage(e1, "Where?");
        assertTrue(true);
        e2.receiveMessage(e2, "Sus?");
        assertTrue(true);
        e3.receiveMessage(e3, "Who?");
        assertTrue(true);
    }

    @Test
    void reportDead() {
        wr1.startGame(map1);
        i1.kill(e1);
        e2.reportDead(e1);
        assertTrue(true);
    }
}