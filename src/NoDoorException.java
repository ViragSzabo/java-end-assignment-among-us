class NoDoorException extends Exception {

    CrewMate role;
    Room room;

    public NoDoorException(CrewMate role, Room room) {
        this.role = role;
        this.room = room;
    }

    public String toString() {
        return "Player " +role.getPlayer().getPlayerName() + " cannot go from " + role.getBodyRoom().getTemplate().getRoomName() + " to " + room.getTemplate().getRoomName() + " because there is no door.";
    }
}