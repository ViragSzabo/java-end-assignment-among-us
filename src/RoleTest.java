import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RoleTest {

    @Test
    void isGhost() {
        GameMap map1 = new GameMap("laboratorium");
        Player player1 = new Player("Flower", "red", "leaf");
        Player player3 = new Player("DrHofstadter", "yellow", "glasses");
        WaitingRoom wr1 = new WaitingRoom("21rwe21", 2, player1);
        wr1.startGame(map1);
        Game game1 = wr1.getGame();
        RoomTemplate rt1 = new RoomTemplate("cafeteria");
        Room room1 = new Room(rt1);
        Impostor i1 = new Impostor(game1, player1, room1);
        CrewMate e1 = new CrewMate(game1, player3, room1);

        wr1.startGame(map1);
        i1.kill(e1);
        e1.dies();
        assertTrue(e1.isGhost());
    }

    @Test
    void dies() {
        GameMap map1 = new GameMap("laboratorium");
        Player player1 = new Player("Flower", "red", "leaf");
        Player player4 = new Player("DrKoothrappali", "orange", "sunglasses");
        WaitingRoom wr1 = new WaitingRoom("21rwe21", 2, player1);
        wr1.startGame(map1);
        Game game1 = wr1.getGame();
        RoomTemplate rt1 = new RoomTemplate("cafeteria");
        Room room1 = new Room(rt1);
        CrewMate e2 = new CrewMate(game1, player4, room1);

        wr1.startGame(map1);
        e2.dies();
        assertTrue(e2.isGhost());
    }

    @Test
    void voteTo() {
        GameMap map1 = new GameMap("laboratorium");
        Player player1 = new Player("Flower", "red", "leaf");
        Player player2 = new Player("DrCooper", "black", "train");
        Player player3 = new Player("DrHofstadter", "yellow", "glasses");
        Player player4 = new Player("DrKoothrappali", "orange", "sunglasses");
        Player player5 = new Player("Stuart", "purple", "book");
        Player player6 = new Player("Denise", "white", "hair");
        WaitingRoom wr1 = new WaitingRoom("21rwe21", 4, player1);
        wr1.startGame(map1);
        Game game1 = wr1.getGame();
        RoomTemplate rt1 = new RoomTemplate("cafeteria");
        Room room1 = new Room(rt1);
        Impostor i1 = new Impostor(game1, player1, room1);
        Impostor i2 = new Impostor(game1, player2, room1);
        CrewMate e1 = new CrewMate(game1, player3, room1);
        CrewMate e2 = new CrewMate(game1, player4, room1);
        CrewMate e3 = new CrewMate(game1, player5, room1);
        CrewMate e4 = new CrewMate(game1, player6, room1);

        wr1.startGame(map1);
        i1.voteTo(e1);
        i2.voteTo(e1);
        e1.voteTo(i1);
        e2.voteTo(i1);
        e3.voteTo(i1);
        e4.voteTo(i1);
        assertTrue(i1.isGhost());
    }

    @Test
    void goToRoom() {
        GameMap map1 = new GameMap("laboratorium");
        Player player1 = new Player("Flower", "red", "leaf");
        Player player3 = new Player("DrHofstadter", "yellow", "glasses");
        WaitingRoom wr1 = new WaitingRoom("21rwe21", 4, player1);
        wr1.startGame(map1);
        Game game1 = wr1.getGame();
        RoomTemplate rt1 = new RoomTemplate("cafeteria");
        RoomTemplate rt2 = new RoomTemplate("register");
        RoomTemplate rt3 = new RoomTemplate("labor");
        Room room1 = new Room(rt1);
        Room room2 = new Room(rt2);
        Room room3 = new Room(rt3);
        Impostor i1 = new Impostor(game1, player1, room1);
        CrewMate e1 = new CrewMate(game1, player3, room1);

        rt1.addDoorTo(rt2);
        rt2.addDoorTo(rt3);

        rt3.hasDoorTo(rt2);
        rt1.addDoorTo(rt2);
        rt2.hasDoorTo(rt1);
        rt2.hasDoorTo(rt3);

        try {
            i1.goToRoom(room2);
            assertTrue(i1.getBodyRoom() == room2);
        } catch (NoDoorException e) {
            e.printStackTrace();
            fail("Failed to enter room2");
        }

        try {
            e1.goToRoom(room3);
            fail("Entered room3 without a door.");
        } catch (NoDoorException e) {
            assertTrue(e1.getBodyRoom() == room1); // still in room1
        }
    }

    @Test
    void receiveMessage() {
        GameMap map1 = new GameMap("laboratorium");
        Player player1 = new Player("Flower", "red", "leaf");
        Player player3 = new Player("DrHofstadter", "yellow", "glasses");
        Player player4 = new Player("DrKoothrappali", "orange", "sunglasses");
        Player player5 = new Player("Stuart", "purple", "book");
        WaitingRoom wr1 = new WaitingRoom("21rwe21", 4, player1);
        wr1.startGame(map1);
        Game game1 = wr1.getGame();
        RoomTemplate rt1 = new RoomTemplate("cafeteria");
        Room room1 = new Room(rt1);
        CrewMate e1 = new CrewMate(game1, player3, room1);
        CrewMate e2 = new CrewMate(game1, player4, room1);
        CrewMate e3 = new CrewMate(game1, player5, room1);

        game1.broadcast(e2, "Where?");
        e1.receiveMessage(e2, "Where?");
        assertTrue(true);
        game1.broadcast(e1, "Where?");
        e2.receiveMessage(e1, "Sus?");
        assertTrue(true);
        game1.broadcast(e3, "Where?");
        e2.receiveMessage(e3, "Who?");
        assertTrue(true); // nothing to check, it just writes to standard out
    }

    @Test
    void reportDead() {
        GameMap map1 = new GameMap("laboratorium");
        Player player1 = new Player("Flower", "red", "leaf");
        Player player3 = new Player("DrHofstadter", "yellow", "glasses");
        Player player4 = new Player("DrKoothrappali", "orange", "sunglasses");
        WaitingRoom wr1 = new WaitingRoom("21rwe21", 3, player1);
        wr1.startGame(map1);
        Game game1 = wr1.getGame();
        RoomTemplate rt1 = new RoomTemplate("cafeteria");
        Room room1 = new Room(rt1);
        Impostor i1 = new Impostor(game1, player1, room1);
        CrewMate e1 = new CrewMate(game1, player3, room1);
        CrewMate e2 = new CrewMate(game1, player4, room1);

        wr1.startGame(map1);
        i1.kill(e1);
        e2.reportDead(e1);
        assertTrue(e1.isGhost());
    }
}