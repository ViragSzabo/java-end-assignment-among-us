import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class CrewMateTest {

    @Test
    void doTask() {
        Application app1 = new Application("amongUs");
        Player player1 = new Player("Flower", "red", "leaf");
        Player player2 = new Player("DrCooper", "black", "train");
        Player player3 = new Player("DrHofstadter", "yellow", "glasses");
        WaitingRoom wr1 = new WaitingRoom("21rwe21", 3, player1);
        wr1.addGroupPlayers(player1);
        wr1.addGroupPlayers(player2);
        wr1.addGroupPlayers(player3);
        GameMap map1 = new GameMap("laboratorium");
        wr1.startGame(map1);
        Game game1 = wr1.getGame();
        RoomTemplate rt1 = map1.getStartRoom();
        Room room1 = new Room(rt1);
        CrewMate e1 = new CrewMate(game1, player1, room1);
        CrewMate e2 = new CrewMate(game1, player2, room1);
        Impostor i1 = new Impostor(game1, player3, room1);
        RegularTask task1 = new RegularTask("Wet floor", "Mop the floor.", 0.0);

        assertFalse(task1.getIsDone());
        e1.doTask(task1);
        assertTrue(task1.getIsDone());
    }

    @Test
    void fixSabotage() {
        Application app1 = new Application("amongUs");
        Player player1 = new Player("Flower", "red", "leaf");
        Player player2 = new Player("DrCooper", "black", "train");
        Player player3 = new Player("DrHofstadter", "yellow", "glasses");
        WaitingRoom wr1 = new WaitingRoom("21rwe21", 3, player1);
        wr1.addGroupPlayers(player1);
        wr1.addGroupPlayers(player2);
        wr1.addGroupPlayers(player3);
        GameMap map1 = new GameMap("laboratorium");
        wr1.startGame(map1);
        Game game1 = wr1.getGame();
        RoomTemplate rt1 = map1.getStartRoom();
        Room room1 = new Room(rt1);
        CrewMate e1 = new CrewMate(game1, player1, room1);
        CrewMate e2 = new CrewMate(game1, player2, room1);
        Impostor i1 = new Impostor(game1, player3, room1);
        RegularTask task1 = new RegularTask("Wet floor", "Mop the floor.", 0.0);

        i1.sabotage(room1);
        e1.fixSabotage(room1);
        assertTrue(!room1.isSabotaged());
    }

    @Test
    void goToRoom() throws NoDoorException {
        Application app1 = new Application("amongUs");
        Player player1 = new Player("Flower", "red", "leaf");
        Player player2 = new Player("DrCooper", "black", "train");
        Player player3 = new Player("DrHofstadter", "yellow", "glasses");
        WaitingRoom wr1 = new WaitingRoom("21rwe21", 3, player1);
        wr1.addGroupPlayers(player1);
        wr1.addGroupPlayers(player2);
        wr1.addGroupPlayers(player3);
        GameMap map1 = new GameMap("laboratorium");
        wr1.startGame(map1);
        Game game1 = wr1.getGame();
        RoomTemplate rt1 = map1.getStartRoom();
        Room room1 = new Room(rt1);
        RoomTemplate rt2 = new RoomTemplate("register");
        Room room2 = new Room(rt2);
        map1.addRoom(rt2);
        CrewMate e1 = new CrewMate(game1, player1, room1);
        CrewMate e2 = new CrewMate(game1, player2, room1);
        Impostor i1 = new Impostor(game1, player3, room1);
        RegularTask task1 = new RegularTask("Wet floor", "Mop the floor.", 0.0);

        rt2.addDoorTo(rt1);
        e1.goToRoom(room2);
        assertTrue(room1.hasDoorTo(room2));
    }
}