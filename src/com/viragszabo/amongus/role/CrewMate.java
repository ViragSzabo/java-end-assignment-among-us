package com.viragszabo.amongus.role;

import com.viragszabo.amongus.game.Game;
import com.viragszabo.amongus.game.Player;
import com.viragszabo.amongus.task.RegularTask;
import com.viragszabo.amongus.map.NoDoorException;
import com.viragszabo.amongus.map.Room;
import com.viragszabo.amongus.task.UrgentTask;

public class CrewMate extends Role
{
    private RegularTask regularTask;
    public CrewMate(Game game, Player player, Room room)
    {
        super(game, player, room);
    }

    public void doTask(RegularTask regularTask){ regularTask.setIsDone(); }

    public void progressOfTask(RegularTask task) {
        double progress = 0.0;
        while(progress < 1.0){
            progress += 0.1;
        }
        doTask(task);
        task.setProgress(progress);
    }

    public void stepByStepDoingTask(RegularTask task) {
        double progress = task.getProgress();
        if(task.getProgress() <= 1.0){
            task.setProgress(progress+0.2);
        }
        if(task.getProgress() >= 1.0){
            doTask(task);
        }
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

    public void fixingSabotagedRoomWithUrgentTask(Room roomToFix, UrgentTask urgent)
    {
        if(roomToFix.isSabotaged() && this.getBodyRoom() == roomToFix)
        {
            urgent.setIsDone();
            roomToFix.setSabotaged(false);

        }
    }

    public void doUrgentTask(UrgentTask urgent, Room sabotagedRoom){
        double progress = 0.0;
        while(progress < 1.0){
            progress += 0.1;
        }
        fixingSabotagedRoomWithUrgentTask(sabotagedRoom, urgent);
        urgent.setProgress(progress);
    }

    public void stepByStepDoUrgentTask(UrgentTask urgent, Room sabotagedRoom) {
        double progress = urgent.getProgress();

        if(urgent.getProgress() < 1.0 && sabotagedRoom.isSabotaged()){
            urgent.setProgress(progress+0.2);
        }
        if(urgent.getProgress() >= 1.0 && sabotagedRoom.isSabotaged()){
            fixingSabotagedRoomWithUrgentTask(sabotagedRoom, urgent);
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
