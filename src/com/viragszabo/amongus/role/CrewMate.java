package com.viragszabo.amongus.role;

import com.viragszabo.amongus.game.Game;
import com.viragszabo.amongus.game.Player;
import com.viragszabo.amongus.task.RegularTask;
import com.viragszabo.amongus.map.NoDoorException;
import com.viragszabo.amongus.map.Room;

public class CrewMate extends Role
{
    private RegularTask regularTask;
    public CrewMate(Game game, Player player, Room room)
    {
        super(game, player, room);
    }

    public void doTask(RegularTask regularTask){
        regularTask.setIsDone();
    }

    /**
     * able to fix a room
     * @param roomToFix is the specific room which needs to be fixed
     */
    public void fixSabotage(Room roomToFix)
    {
        if(roomToFix.isSabotaged() && this.getBodyRoom() == roomToFix)
        {
            roomToFix.setSabotaged(false);
        }
    }

    /**
     * able go to room from a room
     * @param  room
     * @throws NoDoorException if the rooms are not next to each other
     */
    public void goToRoom(Room room) throws NoDoorException
    {
        if ( !this.isGhost() && !this.getBodyRoom().hasDoorTo(room) ) {
            System.out.println("Cannot go there. ("+
                    this.getPlayer().getPlayerName()+": "+
                    this.getBodyRoom().getTemplate().getRoomName()+" > "+
                    room.getTemplate().getRoomName()+
            ")");
            throw new NoDoorException(this, room);
        }
        if ( !this.isGhost() ) {
            this.setBodyRoom(room);
        }
        this.setSoulRoom(room);
    }

}
