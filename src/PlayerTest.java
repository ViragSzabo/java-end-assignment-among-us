class PlayerTest {
    Application app1 = new Application("amongUs");
    Player player1 = new Player("Flower", "red", "leaf");
    WaitingRoom wr1 = new WaitingRoom("21rwe21", 10, player1);
    GameMap map1 = new GameMap("laboratorium");
    Game game1 = new Game(map1, wr1, app1.getPlayers());

    void createRoom() {
        player1.createRoom("re32tr54", 10, player1);
        assert(true);
    }

    void joinRoom() {
        player1.joinRoom(wr1);
        assert(true);
    }
}