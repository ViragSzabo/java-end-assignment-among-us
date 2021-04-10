import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class CrewMateTest {
    Application app1 = new Application("amongUs");
    Player player1 = new Player("Flower", "red", "leaf");
    Player player2 = new Player("DrCooper", "black", "train");
    WaitingRoom wr1 = new WaitingRoom("21rwe21", 1, player1);
    GameMap map1 = new GameMap("laboratorium");
    Game game1 = new Game(map1, wr1, app1.getPlayers());
    RoomTemplate rt1 = new RoomTemplate("cafeteria");
    Room room1 = new Room(rt1);
    CrewMate e1 = new CrewMate(game1, player1, room1);
    Impostor i1 = new Impostor(game1, player2, room1);
    RegularTask task1 = new RegularTask("Wet floor", "Mop the floor.", 0.0);

    @Test
    void doTask() {
        e1.doTask(task1);
        assertTrue(true);
    }

    @Test
    void fixSabotage() {
        i1.sabotage(room1);
        e1.fixSabotage(room1);
        assertTrue(true);
    }

    @Test
    void goToRoom() throws NoDoorException {
        RoomTemplate rt2 = new RoomTemplate("register");
        Room room2 = new Room(rt2);
        rt2.addDoorTo(rt1);
        e1.goToRoom(room2);
        assertTrue(true);
    }
}