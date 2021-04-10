import java.util.ArrayList;

public class RoomTemplate {

    private String roomName; // to RoomTemplate
    private ArrayList<RoomTemplate> doors;

    public RoomTemplate(String roomName) {
        this.roomName=roomName;
        this.doors = new ArrayList<>();
    }

    /**
     * ask for a string
     * @return the name of the RoomTemplate
     */
    public String getRoomName() {
        return roomName;
    }

    /**
     * look for a door and which room is next to another one
     * @param nextRoom has been found
     * able to go out of another room and get back on the same door
     */
    public void addDoorTo(RoomTemplate nextRoom) {
        if ( !doors.contains(nextRoom) ) {
            doors.add(nextRoom);
            nextRoom.addDoorTo(this);
        }
    }

    /**
     * ask for a boolean
     * @param room gets a door
     * @return get a true / false
     */
    public boolean hasDoorTo(RoomTemplate room) {
        return this.doors.contains(room);
    }

}