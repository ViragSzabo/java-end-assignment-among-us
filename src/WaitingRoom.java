import java.util.ArrayList;

public class WaitingRoom {
    private String roomCode;
    private int maxPlayer;
    private boolean isPrivate;
    private ArrayList<Player> groupPlayers;
    private Game game;
    private Player creator;

    public WaitingRoom(String roomCode, int maxPlayer, Player creator) {
        this.roomCode = roomCode;
        this.maxPlayer = maxPlayer;
        this.isPrivate = true;
        this.groupPlayers = new ArrayList<>();
        this.creator = creator;
        this.groupPlayers.add(creator);
    }

    public String getRoomCode() {
        return roomCode;
    }

    public int getMaxPlayer() {
        return maxPlayer;
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
        groupPlayers.add(player);
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
        Game newGame = null;
        if (groupPlayers.size() <= maxPlayer && groupPlayers.size() >= 3) {
            newGame = new Game(gameMap, this, groupPlayers);
        }
        return newGame;
    }
}
