import org.junit.jupiter.api.BeforeAll;

import java.util.function.BooleanSupplier;

import static org.junit.jupiter.api.Assertions.*;

class GameTest {
    Application app1 = new Application("amongUs");
    GameMap map1 = new GameMap("laboratorium");
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
        RoomTemplate rt1 = new RoomTemplate("cafeteria");
        RoomTemplate rt2 = new RoomTemplate("register");
        RoomTemplate rt3 = new RoomTemplate("labor");
        //create doors
        rt1.addDoorTo(rt2);
        rt2.addDoorTo(rt3);
        //create the rooms
        Room room1 = new Room(rt1);
        Room room2 = new Room(rt2);
        Room room3 = new Room(rt3);
        //create a waitingRoom
        WaitingRoom wr1 = new WaitingRoom("21rwe21", 4, player1);
        wr1.addGroupPlayers(player1);
        wr1.addGroupPlayers(player2);
        wr1.addGroupPlayers(player3);
        wr1.addGroupPlayers(player4);
        //create a game
        Game game1 = new Game(map1, wr1, wr1.getGroupPlayers());
        //create tasks
        RegularTask task1 = new RegularTask("Wet floor", "Mop the floor.", 0.0);
        RegularTask task2 = new RegularTask("Register", "Check in.", 0.0);
        RegularTask task3 = new RegularTask("Documentation", "Update the research document.", 0.0);
        room1.addTasks(task1);
        room2.addTasks(task2);
        room3.addTasks(task3);
        //game is started
        wr1.startGame(map1);
        getCrewMate(game1).goToRoom(room2);
        task1.getIsDone();
        getCrewMate(game1).goToRoom(room2);
        getImpostor(game1).sabotage(room3);
        getCrewMate(game1).fixSabotage(room3);
        getImpostor(game1).kill(getCrewMate(game1));
        getCrewMate(game1).goToRoom(room2);
        getCrewMate(game1).goToRoom(room3);
        getCrewMate(game1).reportDead(getCrewMate(game1));
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
        RoomTemplate rt1 = new RoomTemplate("cafeteria");
        RoomTemplate rt2 = new RoomTemplate("register");
        RoomTemplate rt3 = new RoomTemplate("labor");
        //create doors
        rt1.addDoorTo(rt2);
        rt2.addDoorTo(rt3);
        //create the rooms
        Room room1 = new Room(rt1);
        Room room2 = new Room(rt2);
        Room room3 = new Room(rt3);
        //create a waitingRoom
        WaitingRoom wr1 = new WaitingRoom("21rwe21", 6, player1);
        wr1.getGroupPlayers().add(player1);
        wr1.getGroupPlayers().add(player2);
        wr1.getGroupPlayers().add(player3);
        wr1.getGroupPlayers().add(player4);
        wr1.getGroupPlayers().add(player5);
        wr1.getGroupPlayers().add(player6);
        //create a game
        Game game1 = new Game(map1, wr1, wr1.getGroupPlayers());
        RegularTask task1 = new RegularTask("Wet floor", "Mop the floor.", 0.0);
        RegularTask task2 = new RegularTask("Register", "Check in.", 0.0);
        RegularTask task3 = new RegularTask("Documentation", "Update the research document.", 0.0);
        UrgentTask urgent1 = new UrgentTask("Leaking", "Gas is leaking!", 0.0);
        room1.addTasks(task1);
        room2.addTasks(task2);
        room3.addTasks(task3);
        //game is started
        wr1.startGame(map1);
        getCrewMate(game1, 4).doTask(task1);
        getImpostor(game1, 1).goToRoom(room2);
        getCrewMate(game1, 2).goToRoom(room2);
        getCrewMate(game1, 3).goToRoom(room2);
        getCrewMate(game1, 3).doTask(task2);
        getImpostor(game1, 1).kill(getCrewMate(game1, 4));
        getImpostor(game1, 1).goToRoom(room2);
        getCrewMate(game1, 2).goToRoom(room3);
        getCrewMate(game1, 2).doTask(task3);
        getImpostor(game1, 2).sabotage(room3);
        getCrewMate(game1,3).fixSabotage(room3);
        getCrewMate(game1, 2).goToRoom(room2);
        getCrewMate(game1, 3).goToRoom(room2);
        getImpostor(game1, 2).goToRoom(room2);
        getCrewMate(game1, 3).goToRoom(room2);
        getCrewMate(game1, 1).goToRoom(room1);
        getCrewMate(game1, 1).reportDead(getCrewMate(game1));
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
        game1.broadcast(getImpostor(game1, 2), "Why? I just made the urgent Task, before I went out Penny came in and Bernadett.");
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
        RoomTemplate rt1 = new RoomTemplate("cafeteria");
        Room room1 = new Room(rt1);
        Player player1 = new Player("TheAstronautEngineer", "green", "astronaut");
        WaitingRoom wr1 = new WaitingRoom("21rwe21", 1, player1);
        Game game1 = new Game(map1, wr1, wr1.getGroupPlayers());
        CrewMate e1 = new CrewMate(game1, player1, room1);
        game1.broadcast(e1, "Any suspicious?");
        assertTrue(true);
    }

    @org.junit.jupiter.api.Test
    void vote() throws NoDoorException {
        RoomTemplate rt1 = new RoomTemplate("cafeteria");
        RoomTemplate rt2 = new RoomTemplate("register");
        RoomTemplate rt3 = new RoomTemplate("labor");
        //create doors
        rt1.addDoorTo(rt2);
        rt2.addDoorTo(rt3);
        //create the rooms
        Room room1 = new Room(rt1);
        Room room2 = new Room(rt2);
        Room room3 = new Room(rt3);
        //create the players of the application
        Player player1 = new Player("Flower", "red", "leaf");
        Player player2 = new Player("DrCooper", "black", "train");
        Player player3 = new Player("DrHofstadter", "yellow", "glasses");
        Player player4 = new Player("DrKoothrappali", "orange", "sunglasses");
        //create a waitingRoom
        WaitingRoom wr1 = new WaitingRoom("21rwe21", 4, player1);
        //create a game
        Game game1 = new Game(map1, wr1, wr1.getGroupPlayers());
        //create roles
        CrewMate e1 = new CrewMate(game1, player1, room1);
        CrewMate e2 = new CrewMate(game1, player2, room1);
        CrewMate e3 = new CrewMate(game1, player3, room1);
        Impostor i1 = new Impostor(game1, player4, room1);
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
        e1.goToRoom(room2);
        task1.getIsDone();
        e2.goToRoom(room2);
        i1.sabotage(room3);
        e2.fixSabotage(room3);
        i1.kill(e2);
        e3.goToRoom(room2);
        e3.goToRoom(room3);
        e3.reportDead(e2);
        //voting
        game1.vote(e2, e3);
        assertTrue(true);
        game1.vote(e3, e2);
        assertTrue(true);
        game1.vote(i1, e2);
        assertTrue(true);
    }
}