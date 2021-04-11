package com.viragszabo.amongus.game;

import com.viragszabo.amongus.map.GameMap;
import com.viragszabo.amongus.map.Room;
import com.viragszabo.amongus.map.RoomTemplate;
import com.viragszabo.amongus.role.CrewMate;
import com.viragszabo.amongus.role.Impostor;
import com.viragszabo.amongus.role.Role;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Collections;

public class Game {
    private GameMap gameMap;
    private WaitingRoom waitingRoom;
    //private ArrayList<com.viragszabo.amongus.role.Impostor> impostors;
    //private ArrayList<com.viragszabo.amongus.role.CrewMate> crewMates;
    //private ArrayList<com.viragszabo.amongus.role.Impostor> ghostImpostors;
    //private ArrayList<com.viragszabo.amongus.role.CrewMate> ghostCrewMates;
    //make everything just for this one
    private ArrayList<Role> aliveRoles;
    private HashMap<Role,Role> votes = new HashMap<>();
    private ArrayList<Room> rooms;

    public Game(GameMap gameMap, WaitingRoom waitingRoom, ArrayList<Player> players) {
        this.waitingRoom = waitingRoom;
        this.gameMap = gameMap;
        this.rooms = new ArrayList<>();
        Room startRoom = null;

        for ( RoomTemplate template : gameMap.getRooms() ) {
            Room room = new Room(template);
            this.rooms.add(room);
            if ( template==gameMap.getStartRoom() ) {
                startRoom = room;
            }
        }

        this.aliveRoles = new ArrayList<>();

        // Creating Roles on their own
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
                //impostors.add(impostor);
                aliveRoles.add(impostor);
                impostorCount--;
            } else {
                CrewMate crewmate = new CrewMate(this, player, startRoom);
                //crewMates.add(crewmate);
                aliveRoles.add(crewmate);
            }
        }

    }

    public GameMap getGameMap() {
        return gameMap;
    }

    public WaitingRoom getWaitingRoom() {
        return waitingRoom;
    }

    public ArrayList<Role> getAliveRoles() {
        return aliveRoles;
    }

    public ArrayList<Room> getRooms() {
        return rooms;
    }

    /*public ArrayList<com.viragszabo.amongus.role.Impostor> getImpostors() {
        return impostors;
    }

    public ArrayList<com.viragszabo.amongus.role.CrewMate> getCrewmates() {
        return crewMates;
    }*/

    /*
     * save a player who is an impostor to the correct list
     * @param impostor is the specific player

    public void addImpostor(com.viragszabo.amongus.role.Impostor impostor) {
        impostors.add(impostor);
    }

     * save a player who is a crewmate to the correct list
     * @param crewmate is the specific player

    /*public void addCrewmate(com.viragszabo.amongus.role.CrewMate crewmate) {
        crewMates.add(crewmate);
    }*/


    /**
     * The impostors win
     * when there is more impostor OR the same amount of crewmates and impostors are in the game
     */
    public boolean DoImpostorsWon() {
        boolean impostorsWon = false;
        int impostorCount = 0;
        int crewmateCount = 0;

        for(Role role : aliveRoles){
            if (!role.isGhost()) {
                if (role instanceof Impostor) {
                    impostorCount++;
                } else {
                    crewmateCount++;
                }
            }
        }
        if (crewmateCount <= impostorCount) {
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
    public boolean DoCrewmatesWon() {
        boolean crewmatesWon = true;
        for ( Room room : rooms ) {
            if ( !room.getTasks().isEmpty() ){
                crewmatesWon = false;
                break;
            }
        }
        if ( crewmatesWon ) {
            System.out.println("Crewmates won!");
        }
        return crewmatesWon;
    }

    /**
     * Players able to send messages
     * @param sender is the player who send the message
     * @param message is what the player write
     */
    public boolean broadcast(Role sender, String message) {
        boolean isSent = true;
        for ( Role role : aliveRoles) {
            if ( sender != role ) {
                role.receiveMessage(sender, message);
            }else{
                isSent = false;
            }
        }
        return isSent;
    }

    /**
     * The voting system of the game (guess who is the impostor)
     * @param voter is the player who votes
     * @param candidate is the player who gets voted out
     * @return a boolean (true / false)
     */
    public boolean vote(Role voter, Role candidate) {
        votes.put(voter,candidate);
        if ( votes.size() == aliveRoles.size() ) {
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
            sacrifice.isGhost();
            //aliveRoles.remove(sacrifice);
            return true;
        }
        return false;
    }
}
