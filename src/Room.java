import java.util.ArrayList;

public class Room {
    private RoomTemplate template;
    private boolean isSabotaged;

    private UrgentTask urgentTask;
    private ArrayList<RegularTask> regularTasks;

    public Room(RoomTemplate template){
        this.template = template;
        this.isSabotaged = false;
        this.urgentTask = null;
        this.regularTasks = new ArrayList<>();
    }

    public RoomTemplate getTemplate() { return template; }

    public UrgentTask getUrgentTask() { return urgentTask; }

    public boolean isSabotaged() {
        return isSabotaged;
    }

    public ArrayList<RegularTask> getTasks() {
        return regularTasks;
    }

    public void addTasks(RegularTask regularTask){
        regularTasks.add(regularTask);
    }

    /**
     * able to change the state of the room
     * @param sabotaged is true or false
     */
    public void setSabotaged(boolean sabotaged)
    {
        isSabotaged = sabotaged;
        if ( sabotaged ) {
            urgentTask = new UrgentTask("Leaking", "Gas is leaking!", 0.0);
        } else {
            urgentTask = null;
        }
    }

    /**
     * get back if the request room is next to this one
     * @param room is the specific room
     * @return a boolean (true or false)
     */
    public boolean hasDoorTo(Room room) {
        return this.getTemplate().hasDoorTo(room.getTemplate());
    }
}
