class GameMapTest_1 {
    public RoomTemplate rt1 = new RoomTemplate("register");
    public Room room1 = new Room(rt1);
    public RoomTemplate rt2 = new RoomTemplate("lab");
    public Room room2 = new Room(rt2);
    public GameMap map1 = new GameMap("laboratorium");

    void addRooms() {
        map1.addRooms(rt1);
        map1.addRooms(rt2);
        assert(true);
    }
}