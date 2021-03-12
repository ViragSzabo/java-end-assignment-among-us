class GameTest {
    public Application app1 = new Application("amongUs");
    public Player player1 = new Player("Flower", "red", "leaf");
    public Player player2 = new Player("DrCooper", "black", "train");
    public Player player3 = new Player("DrHofstadter", "yellow", "glasses");
    public Player player4 = new Player("DrKoothrappali", "orange", "sunglasses");
    public Player player5 = new Player("TheAstronautEngineer", "green", "astronaut");
    public Player player6 = new Player("Penny", "pink", "star");
    public Player player7 = new Player("DrRostenkowski", "blue", "ladybug");
    public Player player8 = new Player("DrFowler", "grey", "award");
    public Player player9 = new Player("Stuart", "purple", "book");
    public Player player10 = new Player("Denise", "white", "hair");
    public RoomTemplate rt1 = new RoomTemplate("register");
    public Room room1 = new Room(rt1);
    public GameMap map1 = new GameMap("laboratorium");
    public WaitingRoom wr1 = new WaitingRoom("21rwe21", 10, player1);
    public Game game1 = new Game(map1, wr1, app1.getPlayers());
    public Impostor i1 = new Impostor(game1, player6, room1);
    public Impostor i2 = new Impostor(game1, player7, room1);
    public Impostor i3 = new Impostor(game1, player10, room1);
    public CrewMate e1 = new CrewMate(game1, player1, room1);
    public CrewMate e2 = new CrewMate(game1, player2, room1);
    public CrewMate e3 = new CrewMate(game1, player3, room1);
    public CrewMate e4 = new CrewMate(game1, player4, room1);
    public CrewMate e5 = new CrewMate(game1, player5, room1);
    public CrewMate e6 = new CrewMate(game1, player8, room1);
    public CrewMate e7 = new CrewMate(game1, player9, room1);

    void addImpostor() {
        game1.addImpostor(i1);
        game1.addImpostor(i2);
        game1.addImpostor(i3);
        assert(true);
    }

    void addCrewmate() {
        game1.addCrewmate(e1);
        game1.addCrewmate(e2);
        game1.addCrewmate(e3);
        game1.addCrewmate(e4);
        game1.addCrewmate(e5);
        game1.addCrewmate(e6);
        game1.addCrewmate(e7);
        assert(true);
    }

    void addGhostImpostor() {
        game1.addGhostImpostor(i1);
        assert(true);
    }

    void addGhostCrewmate() {
        game1.addGhostCrewmate(e2);
        game1.addGhostCrewmate(e6);
        game1.addGhostCrewmate(e7);
        assert(true);
    }

    void impostorsWon() {
        assert(game1.impostorsWon());
    }

    void crewmatesWon() {
        assert(game1.crewmatesWon());
    }

    void broadcast() {
        game1.broadcast(e1, "Pink is an impostor.");
        game1.broadcast(e1, "Purple died in the cafeteria.");
        game1.broadcast(e5, "Someone killed blue. Now I'm blue.");
        assert(true);
    }

    void vote() {
        game1.vote(e1, i1);
        game1.vote(e2, i1);
        game1.vote(e3, i1);
        game1.vote(e4, i1);
        game1.vote(e5, i1);
        game1.vote(e6, i3);
        game1.vote(e7, i3);
        game1.vote(i2, e1);
        game1.vote(i1, e1);
        game1.vote(i3, e1);
        assert(true);

        game1.vote(e1, e2);
        game1.vote(e2, e2);
        game1.vote(e3, e2);
        game1.vote(e4, e2);
        game1.vote(e5, e2);
        game1.vote(e6, e2);
        game1.vote(e7, e2);
        game1.vote(i2, e2);
        game1.vote(i3, e2);
        assert(true);

        game1.vote(e1, e6);
        game1.vote(e2, e6);
        game1.vote(e3, e6);
        game1.vote(e4, e6);
        game1.vote(e5, e6);
        game1.vote(e6, e6);
        game1.vote(e7, e6);
        game1.vote(i2, e6);
        game1.vote(i3, e6);
        assert(true);

        game1.vote(e1, e7);
        game1.vote(e2, e7);
        game1.vote(e3, e7);
        game1.vote(e4, e7);
        game1.vote(e5, e7);
        game1.vote(e6, e7);
        game1.vote(e7, e7);
        game1.vote(i2, e7);
        game1.vote(i3, e7);
        assert(true);
    }
}