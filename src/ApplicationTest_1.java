class ApplicationTest_1 {
    Application app1 = new Application("amongUs");
    Player player1 = new Player("Flower", "red", "leaf");
    WaitingRoom wr1 = new WaitingRoom("21rwe21", 10, player1);
    GameMap map1 = new GameMap("laboratorium");
    Game game1 = new Game(map1, wr1, app1.getPlayers());

    public void testAddPlayer(){

        app1.addPlayer(player1);
        assert(true);
    }

    public void testAddGameMap(){

        app1.addGameMap(map1);
        assert(true);
    }

    public void testAddGame(){

        app1.addGame(game1);
        assert(true);
    }
}