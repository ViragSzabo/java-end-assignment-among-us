import com.viragszabo.amongus.game.Application;
import com.viragszabo.amongus.game.Game;
import com.viragszabo.amongus.game.Player;
import com.viragszabo.amongus.game.WaitingRoom;
import com.viragszabo.amongus.map.GameMap;
import com.viragszabo.amongus.map.NoDoorException;
import com.viragszabo.amongus.map.Room;
import com.viragszabo.amongus.map.RoomTemplate;
import com.viragszabo.amongus.role.CrewMate;
import com.viragszabo.amongus.role.Impostor;
import com.viragszabo.amongus.role.Role;
import com.viragszabo.amongus.task.RegularTask;
import com.viragszabo.amongus.task.UrgentTask;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class CrewMateTest {
    Application app1 = new Application("amongUs");
    GameMap map1 = new GameMap("laboratorium");
    Player player1 = new Player("Flower", "red", "leaf");
    Player player2 = new Player("DrCooper", "black", "train");
    Player player3 = new Player("DrHofstadter", "yellow", "glasses");
    Player player4 = new Player("DrKoothrappali", "orange", "sunglasses");
    Player player5 = new Player("Stuart", "purple", "book");
    Player player6 = new Player("Denise", "white", "hair");
    WaitingRoom wr1 = new WaitingRoom("21rwe21", 3, player1);
    WaitingRoom wr2 = new WaitingRoom("21rwe21", 6, player1);

    CrewMate getCrewMate(Game game, int index) {
        for ( Role role : game.getAliveRoles() ) {
            if (role instanceof CrewMate) {
                if ( --index == 0 ) {
                    return (CrewMate) role;
                }
            }
        }
        return null;
    }

    CrewMate getCrewMate(Game game) { return getCrewMate(game,1); }

    @Test
    void doTask() {
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
    void progressOfTask() {
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
        e1.progressOfTask(task1);
        assertTrue(task1.getIsDone());
    }

    @Test
    void stepByStepDoingTask() {
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

        System.out.println("Start point:" + task1.getProgress());
        assertFalse(task1.getIsDone());
        e1.stepByStepDoingTask(task1);
        System.out.println("1st point:" + task1.getProgress());
        assertFalse(task1.getIsDone());
        e1.stepByStepDoingTask(task1);
        System.out.println("2nd point:" + task1.getProgress());
        assertFalse(task1.getIsDone());
        e1.stepByStepDoingTask(task1);
        System.out.println("3rd point:" + task1.getProgress());
        assertFalse(task1.getIsDone());
        e1.stepByStepDoingTask(task1);
        System.out.println("4th point:" + task1.getProgress());
        assertFalse(task1.getIsDone());
        e1.stepByStepDoingTask(task1);
        System.out.println("5th point:" + task1.getProgress());
        assertTrue(task1.getIsDone());
    }

    @Test
    void fixSabotage() {
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
        assertTrue(room1.isSabotaged());
        e1.fixSabotage(room1);
        assertTrue(!room1.isSabotaged());
    }

    @Test
    void fixingSabotagedRoomWithUrgentTask() {
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
        UrgentTask urgent1 = new UrgentTask("Leaking", "The gas is leaking", 0.0);

        i1.sabotage(room1);
        assertTrue(room1.isSabotaged());
        e1.fixingSabotagedRoomWithUrgentTask(room1, urgent1);
        assertTrue(!room1.isSabotaged());
    }

    @Test
    void doUrgentTask() {
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
        UrgentTask urgent1 = new UrgentTask("Leaking", "The gas is leaking", 0.0);

        assertFalse(urgent1.getIsDone());
        i1.sabotage(room1);
        e1.doUrgentTask(urgent1, room1);
        assertTrue(urgent1.getIsDone());
    }

    @Test
    void stepByStepDoUrgentTask() {
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
        UrgentTask urgent1 = new UrgentTask("Leaking", "The gas is leaking", 0.0);

        i1.sabotage(room1);
        System.out.println("Start point:" + urgent1.getProgress());
        e1.stepByStepDoUrgentTask(urgent1, room1);
        System.out.println("1st point:" + urgent1.getProgress());
        e1.stepByStepDoUrgentTask(urgent1, room1);
        System.out.println("2nd point:" + urgent1.getProgress());
        e1.stepByStepDoUrgentTask(urgent1, room1);
        System.out.println("3rd point:" + urgent1.getProgress());
        e1.stepByStepDoUrgentTask(urgent1, room1);
        System.out.println("4th point:" + urgent1.getProgress());
        e1.stepByStepDoUrgentTask(urgent1, room1);
        System.out.println("End point:" + urgent1.getProgress());
        assertTrue(urgent1.getIsDone());
    }

    @Test
    void goToRoom() throws NoDoorException {
        wr2.addGroupPlayers(player1);
        wr2.addGroupPlayers(player2);
        wr2.addGroupPlayers(player3);
        wr2.addGroupPlayers(player4);
        wr2.addGroupPlayers(player5);
        wr2.addGroupPlayers(player6);

        RoomTemplate rt1 = map1.getStartRoom();
        RoomTemplate rt2 = new RoomTemplate("register");
        RoomTemplate rt3 = new RoomTemplate("labor");
        map1.addRoom(rt2);
        map1.addRoom(rt3);
        rt1.addDoorTo(rt2);
        rt2.addDoorTo(rt3);

        Game game1 = wr2.startGame(map1);
        Room room2 = new Room(rt2);
        Room room3 = new Room(rt3);

        Role e0 = getCrewMate(game1,1);
        Role e1 = getCrewMate(game1,2);
        RegularTask task1 = new RegularTask("Wet floor", "Mop the floor.", 0.0);

        try {
            e0.goToRoom(room2);
            assertTrue(e0.getBodyRoom() == room2);
        } catch (NoDoorException e) {
            e.printStackTrace();
            fail("Failed to enter room2");
        }

        Room roomToStay = e1.getBodyRoom();
        try {
            e1.goToRoom(room3);
            fail("Entered room3 without a door.");
        } catch (NoDoorException e) {
            assertTrue(e1.getBodyRoom() == roomToStay ); // still in room1
        }
    }
}