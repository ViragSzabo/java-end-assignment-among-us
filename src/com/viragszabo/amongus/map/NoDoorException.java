package com.viragszabo.amongus.map;

import com.viragszabo.amongus.role.CrewMate;

public class NoDoorException extends Exception {

    CrewMate role;
    Room room;

    public NoDoorException(CrewMate role, Room room) {
        this.role = role;
        this.room = room;
    }

    public String toString() {
        return "com.viragszabo.amongus.game.Player " +role.getPlayer().getPlayerName() + " cannot go from " + role.getBodyRoom().getTemplate().getRoomName() + " to " + room.getTemplate().getRoomName() + " because there is no door.";
    }
}