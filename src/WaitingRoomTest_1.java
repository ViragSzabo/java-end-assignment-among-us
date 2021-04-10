class WaitingRoomTest_1 {
    Application app1 = new Application("amongUs");
    Player player1 = new Player("Flower", "red", "leaf");
    WaitingRoom wr1 = new WaitingRoom("21rwe21", 10, player1);
    GameMap map1 = new GameMap("laboratorium");
    Game game1 = new Game(map1, wr1, app1.getPlayers());

    void isPrivate() {
        assert(wr1.isPrivate());
    }

    void setPrivate() {
        assert(!wr1.isPrivate());
    }

    void addGroupPlayers() {
        wr1.addGroupPlayers(player1);
        assert(true);
    }

    void startGame() {
        wr1.startGame(map1);
        assert(true);
    }
}