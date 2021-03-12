class RoomTest {
    public RoomTemplate rt1 = new RoomTemplate("register");
    public RoomTemplate rt2 = new RoomTemplate("lab");
    public Room room1 = new Room(rt1);
    public Room room2 = new Room(rt2);
    public RegularTask regularTask1 = new RegularTask("mop", "water is on the floor", 0.0);
    public RegularTask regularTask2 = new RegularTask("fix", "cannot register in", 0.0);

    void addTasks() {
        room1.addTasks(regularTask2);
        room2.addTasks(regularTask1);
        assert(true);
    }

    void hasDoorTo() {
        room1.hasDoorTo(room2);
        assert(true);
    }
}