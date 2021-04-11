package com.viragszabo.amongus.role;

import com.viragszabo.amongus.game.Application;
import com.viragszabo.amongus.game.Game;
import com.viragszabo.amongus.game.Player;
import com.viragszabo.amongus.game.WaitingRoom;
import com.viragszabo.amongus.map.GameMap;
import com.viragszabo.amongus.map.Room;
import com.viragszabo.amongus.map.RoomTemplate;
import com.viragszabo.amongus.task.RegularTask;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class ImpostorTest {

    @Test
    void kill() {
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

        assertTrue(!e1.isGhost());
        i1.kill(e1);
        assertTrue(e1.isGhost());
    }

    @Test
    void sabotage() {
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

        assertTrue(!room1.isSabotaged());
        i1.sabotage(room1);
        assertTrue(room1.isSabotaged());
    }
}