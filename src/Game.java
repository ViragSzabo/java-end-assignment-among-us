import java.util.ArrayList;
import java.util.HashMap;
import java.util.Collections;

public class Game {
    private GameMap gameMap;
    private WaitingRoom waitingRoom;
    private ArrayList<Impostor> impostors;
    private ArrayList<CrewMate> crewMates;
    private ArrayList<Impostor> ghostImpostors;
    private ArrayList<CrewMate> ghostCrewMates;
    private ArrayList<Role> allroles;
    private HashMap<Role,Role> votes;
    private ArrayList<Room> rooms;

    public Game(GameMap gameMap, WaitingRoom waitingRoom, ArrayList<Player> players) {
        this.waitingRoom = waitingRoom;

        this.gameMap = gameMap;
        this.rooms = new ArrayList<>();
        Room startRoom=null;
        for ( RoomTemplate template : gameMap.getRooms() ) {
            Room room = new Room(template);
            this.rooms.add(room);
            if ( template==gameMap.getStartRoom() ) {
                startRoom = room;
            }
        }

        this.impostors = new ArrayList<>();
        this.crewMates = new ArrayList<>();

        int impostorCount;
        if (players.size() < 5) {
            impostorCount = 1;
        } else if (players.size() < 7) {
            impostorCount = 2;
        } else {
            impostorCount = 3;
        }
        Collections.shuffle(players);
        for (Player player : players) {
            if (impostorCount > 0) {
                Impostor impostor = new Impostor(this, player, startRoom);
                impostors.add(impostor);
                allroles.add(impostor);
                impostorCount--;
            } else {
                CrewMate crewmate = new CrewMate(this, player, startRoom);
                crewMates.add(crewmate);
                allroles.add(crewmate);
            }
        }
    }

    public GameMap getGameMap() {
        return gameMap;
    }

    public WaitingRoom getWaitingRoom() {
        return waitingRoom;
    }

    public ArrayList<Impostor> getImpostors() {
        return impostors;
    }

    public ArrayList<CrewMate> getCrewmates() {
        return crewMates;
    }

    /**
     * save a player who is an impostor to the correct list
     * @param impostor is the specific player
     */
    public void addImpostor(Impostor impostor) {
        impostors.add(impostor);
    }

    /**
     * save a player who is a crewmate to the correct list
     * @param crewmate is the specific player
     */
    public void addCrewmate(CrewMate crewmate) {
        crewMates.add(crewmate);
    }

    /**
     * save a player who recently died
     * @param impostor is the specific player
     */
    public void addGhostImpostor(Impostor impostor) {
        if (impostor.isGhost()) {
            impostors.remove(impostor);
            ghostImpostors.add(impostor);
        }
    }

    /**
     * save a player who recently died
     * @param crewmate is the specific player
     */
    public void addGhostCrewmate(CrewMate crewmate) {
        if (crewmate.isGhost()) {
            crewMates.remove(crewmate);
            ghostCrewMates.add(crewmate);
        }
    }

    /**
     * The impostors win
     * when there is more impostor OR the same amount of crewmates and impostors are in the game
     */
    public boolean impostorsWon() {
        boolean impostorsWon = false;
        if (crewMates.size() <= impostors.size()) {
            System.out.println("Impostors won!");
            impostorsWon = true;
        }
        else{
            impostorsWon = false;
        }
        return impostorsWon;
    }

    /**
     * The crewmates win
     * when all the tasks are done by the crewmates
     * ghostCrewmates are able to do the tasks too
     */
    public boolean crewmatesWon() {
        boolean crewmatesWon = false;
        for ( Room room : rooms ) {
            if(!room.getTasks().isEmpty()){
                crewmatesWon = true;
            }
            else{
                crewmatesWon = false;
            }
        }
        System.out.println("Crewmates won!");
        return crewmatesWon;
    }

    /**
     * Players able to send messages
     * @param sender is the player who send the message
     * @param message is what the player write
     */
    public void broadcast(Role sender, String message) {
        for ( Role role : allroles ) {
            if ( sender != role ) {
                role.receiveMessage(sender, message);
            }
        }
    }

    /**
     * The voting system of the game (guess who is the impostor)
     * @param voter is the player who votes
     * @param candidate is the player who gets voted out
     * @return a boolean (true / false)
     */
    public boolean vote(Role voter, Role candidate) {
        votes.put(voter,candidate);
        if ( votes.size()==allroles.size() ) {
            HashMap<Role, Integer> voteCounts = new HashMap<>();
            for ( Role who : votes.values() ) {
                if ( voteCounts.containsKey(who) ) {
                    voteCounts.put(who, voteCounts.get(who)+1);
                } else {
                    voteCounts.put(who,1);
                }
            }
            votes.clear();
            int max=0;
            int sharedmax = 0;
            Role sacrifice = null;
            for ( Role person : voteCounts.keySet() ) {
                if ( voteCounts.get(person)>max ) {
                    max = voteCounts.get(person);
                    sacrifice = person;
                } else if ( voteCounts.get(person)==max ) {
                    sharedmax = max;
                }
            }
            if ( max == sharedmax ) {
                return false;
            }
            sacrifice.dies();
            if(sacrifice instanceof Impostor){
                ghostImpostors.add((Impostor) sacrifice);
            }
            else{
                ghostCrewMates.add((CrewMate) sacrifice);
            }
            return true;
        }
        return false;
    }
}
