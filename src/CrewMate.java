public class CrewMate extends Role
{
    private RegularTask regularTask;
    private UrgentTask urgentTask;
    public CrewMate(Game game, Player player, Room room)
    {
        super(game, player, room);
    }

    public RegularTask doTask(RegularTask regularTask){ return regularTask; }

    /**
     * able to fix a room
     * @param roomToFix is the specific room which needs to be fixed
     */
    public void fixSabotage(Room roomToFix)
    {
        if(roomToFix.isSabotaged() && this.getBodyRoom() == roomToFix)
        {
            roomToFix.setSabotaged(false);
            urgentTask.setIsDone();
        }
    }

    /**
     * able go to room from a room
     * @param  room
     * @throws NoDoorException if the rooms are not next to each other
     */
    public void goToRoom(Room room) throws NoDoorException
    {
        try{
            if ( !this.isGhost() && !this.getBodyRoom().hasDoorTo(room) ) {
                this.getBodyRoom().hasDoorTo(room);
                throw new NoDoorException(this, room);
            }
        }
        catch(Exception NoDoorException){
            System.out.println("Cannot go there.");
        }
    }

}
