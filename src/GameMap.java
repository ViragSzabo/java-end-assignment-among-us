import java.util.ArrayList;

public class GameMap {
    private String mapName;
    private ArrayList<RoomTemplate> rooms;
    private RoomTemplate startRoomTemplate;

    public GameMap(String mapName){
        this.mapName = mapName;
        this.rooms = new ArrayList<>();
        startRoomTemplate = new RoomTemplate("Cafeteria");
    }

    public String getMapName() {
        return mapName;
    }

    public ArrayList<RoomTemplate> getRooms() {
        return rooms;
    }

    public void addRooms(RoomTemplate room) { rooms.add(room); }

    public RoomTemplate getStartRoom(){
        return startRoomTemplate;
    }
}
