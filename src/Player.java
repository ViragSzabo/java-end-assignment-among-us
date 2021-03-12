public class Player {
    private String playerName;
    private String bodyColour;
    private String customHat;
    private WaitingRoom waitingRoom;
    private String costumeHat;
    private WaitingRoom currentWaitingRoom;

    public Player(String playerName, String bodyColour, String customHat) {
        this.playerName = playerName;
        this.bodyColour = bodyColour;
        this.customHat = customHat;
        this.costumeHat = costumeHat;
        this.currentWaitingRoom = null;
    }

    public String getPlayerName() {
        return playerName;
    }

    public String getBodyColour() {
        return bodyColour;
    }

    public String getCustomHat() {
        return customHat;
    }

    public WaitingRoom getWaitingRoom() { return currentWaitingRoom; }

    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }

    public void setBodyColour(String bodyColour) {
        this.bodyColour = bodyColour;
    }

    public void setCustomHat(String customHat) {
        this.customHat = customHat;
    }

    public void createRoom(String roomCode, int maxPlayer, Player creator)
    {
        WaitingRoom newRoom = new WaitingRoom(roomCode, maxPlayer, creator);
        this.currentWaitingRoom = newRoom;
    }

    public void joinRoom(WaitingRoom room){
        this.currentWaitingRoom = room;
    }
}
