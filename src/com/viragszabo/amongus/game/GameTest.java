package com.viragszabo.amongus.game;

import com.viragszabo.amongus.map.GameMap;
import com.viragszabo.amongus.map.NoDoorException;
import com.viragszabo.amongus.map.Room;
import com.viragszabo.amongus.map.RoomTemplate;
import com.viragszabo.amongus.role.CrewMate;
import com.viragszabo.amongus.role.Impostor;
import com.viragszabo.amongus.role.Role;
import com.viragszabo.amongus.task.RegularTask;
import com.viragszabo.amongus.task.UrgentTask;

import static org.junit.jupiter.api.Assertions.*;

class GameTest {
    //create the players of the application
    Player player1 = new Player("Flower", "red", "leaf");
    Player player2 = new Player("DrCooper", "black", "train");
    Player player3 = new Player("DrHofstadter", "yellow", "glasses");
    Player player4 = new Player("DrKoothrappali", "orange", "sunglasses");
    Player player5 = new Player("Stuart", "purple", "book");
    Player player6 = new Player("Denise", "white", "hair");

    Impostor getImpostor(Game game, int index) {
        for ( Role role : game.getAliveRoles() ) {
            if (role instanceof Impostor) {
                if ( --index == 0 ) {
                    return (Impostor) role;
                }
            }
        }
        return null;
    }

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

    Impostor getImpostor(Game game) {
        return getImpostor(game,1);
    }

    CrewMate getCrewMate(Game game) {
        return getCrewMate(game,1);
    }

    @org.junit.jupiter.api.Test
    void doImpostorsWon() throws NoDoorException {
        GameMap map1 = new GameMap("laboratorium");
        RoomTemplate rt1 = map1.getStartRoom();
        RoomTemplate rt2 = new RoomTemplate("register");
        RoomTemplate rt3 = new RoomTemplate("labor");
        map1.addRoom(rt2);
        map1.addRoom(rt3);
        //create doors
        rt1.addDoorTo(rt2);
        rt2.addDoorTo(rt3);
        //create the rooms
        Room room1 = new Room(rt1);
        Room room2 = new Room(rt2);
        Room room3 = new Room(rt3);
        //create a waitingRoom
        WaitingRoom wr1 = new WaitingRoom("21rwe21", 4, player1);
        wr1.addGroupPlayers(player2);
        wr1.addGroupPlayers(player3);
        wr1.addGroupPlayers(player4);
        //create tasks
        RegularTask task1 = new RegularTask("Wet floor", "Mop the floor.", 0.0);
        RegularTask task2 = new RegularTask("Register", "Check in.", 0.0);
        RegularTask task3 = new RegularTask("Documentation", "Update the research document.", 0.0);
        room1.addTasks(task1);
        room2.addTasks(task2);
        room3.addTasks(task3);
        //game is started
        wr1.startGame(map1);
        Game game1 = wr1.getGame();
        CrewMate victim = getCrewMate(game1, 3);
        CrewMate victim2 = getCrewMate(game1, 2);
        getCrewMate(game1, 1).goToRoom(room2);
        getCrewMate(game1, 2).goToRoom(room2);
        getCrewMate(game1, 2).doTask(task2);
        getImpostor(game1).sabotage(room3);
        getCrewMate(game1, 1).goToRoom(room3);
        getCrewMate(game1, 1).fixSabotage(room3);
        getImpostor(game1).kill(victim);
        getCrewMate(game1, 1).goToRoom(room2);
        getCrewMate(game1, 2).goToRoom(room1);
        getCrewMate(game1, 1).goToRoom(room1);
        getImpostor(game1).kill(victim2);
        getCrewMate(game1, 1).reportDead(victim);
        //voting
        Impostor imp = getImpostor(game1);
        CrewMate mate = getCrewMate(game1);
        for ( Role role : game1.getAliveRoles() ) {
            if ( role != mate ) {
                game1.vote(role,mate);
            }
        }
        game1.vote(mate,imp);
        assertTrue(game1.DoImpostorsWon());
    }

    @org.junit.jupiter.api.Test
    void doCrewmatesWon() throws NoDoorException {
        GameMap map1 = new GameMap("laboratorium");

//        com.viragszabo.amongus.map.RoomTemplate rt1 = new com.viragszabo.amongus.map.RoomTemplate("cafeteria");
        RoomTemplate rt1 = map1.getStartRoom();
        RoomTemplate rt2 = new RoomTemplate("register");
        RoomTemplate rt3 = new RoomTemplate("labor");
        map1.addRoom(rt2);
        map1.addRoom(rt3);
        //create doors
        rt1.addDoorTo(rt2);
        rt2.addDoorTo(rt3);
        //create the rooms
        Room room1 = new Room(rt1);
        Room room2 = new Room(rt2);
        Room room3 = new Room(rt3);
        //create a waitingRoom
        WaitingRoom wr1 = new WaitingRoom("21rwe21", 6, player1);
        wr1.addGroupPlayers(player1);
        wr1.addGroupPlayers(player2);
        wr1.addGroupPlayers(player3);
        wr1.addGroupPlayers(player4);
        wr1.addGroupPlayers(player5);
        wr1.addGroupPlayers(player6);

        RegularTask task1 = new RegularTask("Wet floor", "Mop the floor.", 0.0);
        RegularTask task2 = new RegularTask("Register", "Check in.", 0.0);
        RegularTask task3 = new RegularTask("Documentation", "Update the research document.", 0.0);
        room1.addTasks(task1);
        room2.addTasks(task2);
        room3.addTasks(task3);
        //game is started
        wr1.startGame(map1);
        Game game1 = wr1.getGame();
        CrewMate victim = getCrewMate(game1, 4);
        getCrewMate(game1, 4).doTask(task1);
        getImpostor(game1, 1).goToRoom(room2);
        getCrewMate(game1, 2).goToRoom(room2);
        getCrewMate(game1, 3).goToRoom(room2);
        getCrewMate(game1, 3).doTask(task2);
        getImpostor(game1, 1).goToRoom(room1);
        getImpostor(game1, 1).kill(victim);
        getImpostor(game1, 1).goToRoom(room2);
        getCrewMate(game1, 2).goToRoom(room3);
        getCrewMate(game1, 2).doTask(task3);
        getImpostor(game1, 2).sabotage(room3);
        getCrewMate(game1,2).fixSabotage(room3);
        getCrewMate(game1, 2).goToRoom(room2);
        getCrewMate(game1, 1).reportDead(victim);
        //broadcast
        game1.broadcast(getCrewMate(game1, 4), "In the cafeteria, Flower is dead.");
        game1.broadcast(getImpostor(game1, 1), "Any suspicious?");
        game1.broadcast(getCrewMate(game1, 3), "In the register, DrCooper was dead too.");
        game1.broadcast(getCrewMate(game1, 4), "Did you see anyone near by?");
        game1.broadcast(getCrewMate(game1, 3), "Denise just came in the register room.");
        game1.broadcast(getCrewMate(game1, 4), "She could kill Penny in the labor.");
        game1.broadcast(getCrewMate(game1, 3), "Who could die first? There is just one impostor.");
        game1.broadcast(getCrewMate(game1, 4), "No, there are two of them.");
        game1.broadcast(getCrewMate(game1, 3), "For me, Denise is sus.");
        game1.broadcast(getImpostor(game1, 2), "Why? I just made the urgent com.viragszabo.amongus.task.Task, before I went out Penny came in and Bernadett.");
        game1.broadcast(getCrewMate(game1, 3), "I did not kill her.");
        //voting
        Impostor imp = getImpostor(game1);
        CrewMate mate = getCrewMate(game1);
        for ( Role role : game1.getAliveRoles() ) {
            if ( role != imp ) {
                game1.vote(role,imp);
            }
        }
        game1.vote(imp,mate);
        assertTrue(game1.DoCrewmatesWon());
    }

    @org.junit.jupiter.api.Test
    void broadcast() throws NoDoorException {
        GameMap map1 = new GameMap("laboratorium");
        RoomTemplate rt1 = map1.getStartRoom();
        Room room1 = new Room(rt1);
        WaitingRoom wr1 = new WaitingRoom("21rwe21", 6, player1);
        wr1.addGroupPlayers(player1);
        wr1.addGroupPlayers(player2);
        wr1.addGroupPlayers(player3);
        wr1.addGroupPlayers(player4);
        wr1.addGroupPlayers(player5);
        wr1.addGroupPlayers(player6);
        wr1.startGame(map1);
        Game game1 = wr1.getGame();
        game1.broadcast(getCrewMate(game1), "Any suspicious?"); // only system.out
    }

    @org.junit.jupiter.api.Test
    void vote() throws NoDoorException {
        GameMap map1 = new GameMap("laboratorium");
        RoomTemplate rt1 = map1.getStartRoom();
        RoomTemplate rt2 = new RoomTemplate("register");
        RoomTemplate rt3 = new RoomTemplate("labor");
        map1.addRoom(rt2);
        map1.addRoom(rt3);
        //create doors
        rt1.addDoorTo(rt2);
        rt2.addDoorTo(rt3);
        //create the rooms
        Room room1 = new Room(rt1);
        Room room2 = new Room(rt2);
        Room room3 = new Room(rt3);
        //create a waitingRoom
        WaitingRoom wr1 = new WaitingRoom("21rwe21", 6, player1);
        wr1.addGroupPlayers(player1);
        wr1.addGroupPlayers(player2);
        wr1.addGroupPlayers(player3);
        wr1.addGroupPlayers(player4);
        wr1.addGroupPlayers(player5);
        wr1.addGroupPlayers(player6);
        //create tasks
        RegularTask task1 = new RegularTask("Wet floor", "Mop the floor.", 0.0);
        RegularTask task2 = new RegularTask("Register", "Check in.", 0.0);
        RegularTask task3 = new RegularTask("Documentation", "Update the research document.", 0.0);
        UrgentTask urgent1 = new UrgentTask("Leaking", "Gas is leaking!", 0.0);
        room1.addTasks(task1);
        room2.addTasks(task2);
        room3.addTasks(task3);
        //game is started
        wr1.startGame(map1);
        Game game1 = wr1.getGame();
        getCrewMate(game1, 1).goToRoom(room2);
        getCrewMate(game1, 2).goToRoom(room2);
        getImpostor(game1).sabotage(room3);
        getCrewMate(game1, 2).goToRoom(room3);
        getCrewMate(game1, 2).fixSabotage(room3);
        getImpostor(game1).kill(getCrewMate(game1, 3));
        getCrewMate(game1, 1).goToRoom(room1);
        getCrewMate(game1, 1).reportDead(getCrewMate(game1, 3));
        //voting
        game1.vote(getCrewMate(game1, 1), getImpostor(game1));
        game1.vote(getCrewMate(game1, 2), getImpostor(game1));
        game1.vote(getImpostor(game1), getCrewMate(game1, 2));
        getImpostor(game1).isGhost();
    }
}