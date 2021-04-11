package com.viragszabo.amongus.role;

import com.viragszabo.amongus.game.Game;
import com.viragszabo.amongus.game.Player;
import com.viragszabo.amongus.map.NoDoorException;
import com.viragszabo.amongus.map.Room;

public abstract class Role {
    private Game game;
    private Player player;
    private Room bodyRoom;
    private Room soulRoom;
    private boolean isGhost;

    public Role(Game game, Player player, Room room)
    {
        this.game = game;
        this.player = player;
        this.bodyRoom = room;
        this.soulRoom = room;
        this.isGhost = false;
    }

    public Game getGame() {
        return game;
    }

    public Player getPlayer() {
        return player;
    }

    public Room getBodyRoom() {
        return bodyRoom;
    }

    public Room getSoulRoom() {
        return soulRoom;
    }

    public void setBodyRoom(Room bodyRoom)
    {
        this.bodyRoom = bodyRoom;
    }

    public void setSoulRoom(Room soulRoom)
    {
        this.soulRoom = soulRoom;
    }

    public boolean isGhost() {
        return isGhost;
    }

    public void dies() {
        isGhost = true;
    }

    public void voteTo(Role role)
    {
        game.vote(this,role);
    }

    /**
     * player can able change position
     * @param goToRoom is a room where the player wants to go
     * @throws NoDoorException if the player can go there
     */
    public void goToRoom(Room goToRoom) throws NoDoorException
    {
        this.setSoulRoom(goToRoom);
        if(!isGhost)
        {
            this.setBodyRoom(goToRoom);
        }
    }

    public void receiveMessage(Role from, String message) {
        System.out.println(message + " from " + from);
    }

    public void reportDead(Role dead)
    {
        this.game.broadcast(this,dead.getPlayer().getPlayerName()+" is dead.");
    }

}
