class RoleTest_1 {public Player player1 = new Player("Flower", "red", "leaf");
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
    public Application app1 = new Application("amongUs");
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

    void isGhost() {

        assert(i1.isGhost());
    }

    void dies() {
        assert(e7.isGhost());
    }

    void voteTo() {
        e1.voteTo(i2);
        assert(true);
    }

    void goToRoom() throws NoDoorException {
        e2.goToRoom(room1);
        assert(true);
    }

    void receiveMessage() {
        assert(true);
    }

    void reportDead() {
        e3.reportDead(e7);
        assert(true);
    }
}