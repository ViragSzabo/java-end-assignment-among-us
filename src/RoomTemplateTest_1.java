class RoomTemplateTest_1 {
    public RoomTemplate rt1 = new RoomTemplate("register");
    public RoomTemplate rt2 = new RoomTemplate("lab");
    public Room room1 = new Room(rt1);
    public Room room2 = new Room(rt2);

    void addDoorTo() {

        rt1.addDoorTo(rt2);
        assert(true);
    }

    void hasDoorTo() {

        rt1.hasDoorTo(rt2);
        assert(true);
    }
}