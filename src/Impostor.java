public class Impostor extends Role{

    private double killTime;
    public Impostor(Game game, Player player, Room room) {
        super(game, player, room);
    }

    /**
     * able to kill a player
     * @param role which is going to die
     * and become a ghost
     */
    public void kill(Role role)
    {
        if ( role.getBodyRoom()==this.getBodyRoom() && !role.isGhost() ) {
            role.dies();
            role.isGhost();
        }
    }

    /**
     * able to sabotage and change the state of a room
     * @param room is the specific room
     * which is sabotaged by the impostor
     */
    public void sabotage(Room room)
    {
        room.setSabotaged(true);
    }
}