import java.util.ArrayList;

public class WaitingRoom {
    private String roomCode;
    private int maxPlayerCount;
    private boolean isPrivate;
    private ArrayList<Player> groupPlayers;
    private Game game;
    private Player creator;

    public WaitingRoom(String roomCode, int maxPlayerCount, Player creator) {
        this.roomCode = roomCode;
        this.maxPlayerCount = maxPlayerCount;
        this.isPrivate = true;
        this.groupPlayers = new ArrayList<>();
        this.creator = creator;
        this.groupPlayers.add(creator);
    }

    public String getRoomCode() {
        return roomCode;
    }

    public int getMaxPlayerCount() {
        return maxPlayerCount;
    }

    public boolean isPrivate() {
        return isPrivate;
    }

    public void setPrivate() {
        isPrivate = false;
    }

    public ArrayList<Player> getGroupPlayers() {
        return groupPlayers;
    }

    public void addGroupPlayers(Player player) {
        if ( !groupPlayers.contains(player) ) {
            groupPlayers.add(player);
        }
    }

    public Game getGame() {
        return game;
    }

    /**
     * ask for a game with maximum 10 and minimum 3 players
     * @param gameMap is give to the game
     * @return a new game
     */
    public Game startGame(GameMap gameMap) {
        if (groupPlayers.size() <= maxPlayerCount && groupPlayers.size() >= 3) {
            this.game = new Game(gameMap, this, groupPlayers);
        } else {
            System.out.println("Cannot start game: groupPlayers.size()="+groupPlayers.size());
        }
        return game;
    }
}
