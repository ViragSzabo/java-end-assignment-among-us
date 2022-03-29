# Start Document of The Java 3 End-Assignment
## Problem description

Among Us is an online multiplayer social deduction game for four to ten players. The game takes place in a space-themed setting, in which players each take on one of two roles, most being Crewmates and a predetermined number being Impostors (one to three players). The crewmates should finish all the tasks and figure out who is/are the impostor(s). The impostor(s) usually kills the other crewmates one by one. Our application is a model of this game.

## Summary

A player can enter a waiting room through a queue system which puts them in a random available public waiting room. Or they can directly enter a room by inputting a room code.

Each waiting room has a max capacity of players. After the room is being filled with the players, the game can start.

A map where the game happens has multiple rooms, and each room has a list of tasks.

After the game is started, the players are randomly assigned as Impostors depending on the number of players in the room. The rest of the players are going to be crewmates.

The Crewmates have a list of assigned tasks that they have to do by going to a room on the map.

The Impostors are given a set of empty tasks. Their task is to kill the Crewmates without being found. Impostors can sabotage a room to create an Urgent task, which has to be done in a set of time.

Both, Impostor and Crewmate can report a player's death which will open up a poll in which everyone can vote to kill a player who may be the killer. It is possible to give a white vote. However, if a draw occurs between the players, nobody is being kicked out, the game can continue.

After being killed, the player will become a ghost. Ghost can move freely on the map. Ghost crewmates can continue doing their tasks.

The game will end if one of these conditions is met:

- All the tasks have been completed by crewmates,
- The number of Impostors is equal to or greater than the number of crewmates,
- The failure of one urgent task.

## Tables

### Input

| **Cases** | **Types** | **Conditions** |
| --- | --- | --- | 
| The name of the application | String | not empty | 
| The list of all the games the player has ever played | List | Game | 
| A room can be created by a player and wait for the others to join before the room is full and the game is started | WaitingRoom | not empty | 
| Every player got a role before the game is actually started | List | Player, Role | 
| A player is alive until an impostor does not kill him/her character | boolean | false / true | 
| An impostor needs to wait a specific time until he/she can kill another crewmate | double | 0 < time < 0.30 |
| An impostor can go to a room from another which has no door between them by using the vent | boolean | false / true | 
| The name of the specific task that an impostor should be complete before they die | String | not empty |  |
| A task can be done by the crewmates | boolean | false / true | 
| The description of a task which includes what to do | String | not empty | 
| All the tasks are from the crewmates' list | List | Task | 
| The name of the specific room | String | not empty | 
| The rooms can be sabotaged by the impostors | boolean | false / True | 
| All the rooms are in the chosen game | List | String | 
| All the rooms that are on the map of the game | List | String | 
| The name of the map| String | not empty | 
| The code of the waiting room if it is private | String | not empty | 
| The int of the maximum players that can be in the waiting room | integer | 3 < 10 | 
| The waiting room can be private or public | boolean | false / true | 
| The players who are playing in the same game | List | Player | 
| The name of the player that can be re-written | String | not empty | 
| The color of the character that the player can choose outside of a game | String | not empty | 
| The custom hat can be reset outside of a game | String | not empty | 

### Output

| **Cases** | **Types** | 
| --- | --- | 
| The action what an impostor can do for winning the game against the crewmates | void | Player | 
| The action what an impostor can do for adding more tasks for the crewmates. They can make sure they are not able to catch up | void | Room | 
| The action that a crewmate can do for winning the game against the impostors | Task | --- | 

## Constructors

### The new simple application simulates the Among Us online multiplayer game. It has twelve classes and one interface:

1. The **Application** hold the list of all games, players, and maps.
2. The **Game** has a map, a waitingroom, a list of all the roles who are alive, a hash map for the votes and a list of all the rooms.
3. The **Waiting Room** has a unique code of the waiting room, an int which counts how many players are in the room, a boolean if it is a private group or not, and an ArrayList of all the players in the group, a game and a creator of the waitingroom.
4. The **GameMap** has a unique name and a list for all the rooms for its game. It has a starter room template.
5. The **RoomTemplate** has a name and a list for all the doors among the rooms. This is a class for seeing which room is available to which one for the crewmates who are still alive.
6. The **Room** has a list of all the tasks, a boolean if the impostor sabotages it or not and a specific template of the room, so it knows about its door(s).
7. The **Task** is an interface.
8. The **UrgentTask** has a name and a description. Also, it can show its progress and if it is done or not by a crewmate.
9. The **RegularTask** has a name and a description. Also, it can show its progress and if it is done or not by a crewmate.
10. The **Crewmate** can do a **Task** at a time.
11. The **Player** has a name, the color of the body, and a hat that can be changed before entering a waiting room. Player has a waitingroom which gets the current waitingroom the player is in.
12. The **Role** is an abstract class that shows if the player is dead or alive and has two Array lists of the Impostors and the Crewmates.
13. The **Impostor** and the **Crewmate** inherited from the Role. The Impostor is the one who kills the crewmates or sabotages a specific room. The crewmates can do their tasks for able to win the game.
14. The **NoDoorException** drops a message if the player can go into a room or not.
15. The **MapRoom** interface has a method about seeing if the room has a door to a room or not (hasDoorTo), and it returns a true or a false.

# UML diagram

<img src="AmongUs_UMLdiagram_New.png">

# Test plan
## Build-up the game
### Create the application, a new game and the map of the game

| **#** | **Class** | **ID** | **Method** | **Output** |
| --- | --- | --- | --- | --- |
| 1 | Application | AU | appName("Among Us") | AU is created |
| 2 | Game | G1 | addGames() | G1 is added to AU's list of games |
| 3 | Map | StarShip | addMaps() | M1 is added to AU's list of maps |

## Build-up the map
### Create the rooms of the map and add the tasks to the rooms

| **#** | **Class** | **ID** | **Method** | **Output** |
| --- | --- | --- | --- | --- |
| 1 | RoomTemplate | rt1 | new RoomTemplate('Cafeteria') | Cafeteria is created |
| 2 | RoomTemplate | rt2 | new RoomTemplate('Admin') | Admin is created |
| 3 | RoomTemplate | rt3 | new RoomTemplate('Security') | Security is created |
| 4 | RoomTemplate | rt4 | new RoomTemplate('Electronic') | Electronic is created |
| 5 | RoomTemplate | rt1 | addRoomTemplate('Cafeteria') | Cafeteria is added to RoomTemplate's list of rooms |
| 6 | RoomTemplate | rt2 | addRoomTemplate('Admin') | Admin is added to RoomTemplate's list of rooms |
| 7 | RoomTemplate | rt3 | addRoomTemplate('Security') | Security is added to RoomTemplate's list of rooms |
| 8 | RoomTemplate | rt4 | addRoomTemplate('Electronic') | Electronic is added to RoomTemplate's list of rooms |
| 9 | Room | r2 | new Room('Admin') | Admin is added to RoomTemplate's list of rooms |
| 10 | Room | r3 | new Room('Security') | Security is added to RoomTemplate's list of rooms |
| 11 | Room | r4 | new Room('Electronic') | Electronic is added to RoomTemplate's list of rooms |
| 12 | Room | r1 | addRooms() | Cafeteria is added to RoomTemplate's list of rooms |
| 13 | Room | r2 | addRooms() | Admin is added to RoomTemplate's list of rooms |
| 14 | Room | r3 | addRooms() | Security is added to RoomTemplate's list of rooms |
| 15 | Room | r4 | addRooms() | Electronic is added to RoomTemplate's list of rooms |
| 16 | Task | t1 | new Task('Floor') | Floor is created |
| 17 | Task | t2 | new Task('Card') | Card is created |
| 18 | Task | t3 | new Task('Light') | Light is created |
| 19 | Task | Floor | addTasks() | Floor is added to the Cafeteria's list of tasks |
| 20 | Task | Card | addTasks() | Card is added to the Cafeteria's list of tasks |
| 21 | Task | Light | addTasks() | Light is added to the Cafeteria's list of tasks |

## Build-up the players
### How the users can register to the application

| **#** | **Class** | **ID** | **Method** | **Output** |
| --- | --- | --- | --- | --- |
| 1 | Player | P1 | playerName("Leonard"), bodyColour("yellow"), costumeHat("toilette paper") | P1 is added to the list of the AU's list of the players |
| 2 | Player | P2 | playerName("Sheldon"), bodyColour("red"), costumeHat("cowboyhat") | P2 is added to the list of the AU's list of the players |
| 3 | Player | P3 | playerName("Howard"), bodyColour("blue"), costumeHat("astronaute") | P3 is added to the list of the AU's list of the players |
| 4 | Player | P4 | playerName("Penny"), bodyColour("green"), costumeHat("knife") | P4 is added to the list of the AU's list of the players |
| 5 | Player | P5 | playerName("Amy"), bodyColour("brown"), costumeHat("glasses") | P5 is added to the list of the AU's list of the players |
| 6 | Player | P6 | playerName("Bernadett"), bodyColour("pink"), costumeHat("chocolate") | P6 is added to the list of the AU's list of the players |

## Build-up the waiting room
### How to create a private room

| **#** | **Class** | **ID** | **Method** | **Output** |
| --- | --- | --- | --- | --- |
| 1 | WaitingRoom | W1 | roomCode("PDFKRG"), maxPlayer(6), isPrivate(true), game(G1) | W1 is created |
| 2 | Player | P2 | createRoom(W1) | P2 has created a private WaitingRoom with limit of 6 players |

## Waiting for other players
### How to join to a private waiting room using the code of the room

| **#** | **Class** | **ID** | **Method** | **Output** |
| --- | --- | --- | --- | --- |
| 3 | Player | P1 | joinRoom(W1) | P1 has joined the room with the roomCode |
| 4 | Player | P3 | joinRoom(W1) | P3 has joined the room with the roomCode |
| 5 | Player | P4 | joinRoom(W1) | P4 has joined the room with the roomCode |
| 6 | Player | P5 | joinRoom(W1) | P5 has joined the room with the roomCode |
| 7 | Player | P6 | joinRoom(W1) | P6 has joined the room with the roomCode |

## Generate the roles
### After getting the maximum number of the waitin room

| **#** | **Class** | **ID** | **Method** | **Output** |
| --- | --- | --- | --- | --- |
| 1 | Player | P2 | void startGame(G1) | P2 has started the game |
| 2 | Role | R1 | addImpostors(P1) | P1 is an impostor |
| 3 | Role | R2 | addImpostors(P2) | P2 is an impostor |
| 4 | Role | R3 | addCrewmates(P3) | P3 is a crewmate |
| 5 | Role | R4| addCrewmates(P4) | P4 is a crewmate |
| 6 | Role | R5 | addCrewmates(P5) | P5 is a crewmate |
| 7 | Role | R6 | addCrewmates(P6) | P6 is a crewmate |

## Start playing the game
### How to kill, report and do a task

| **#** | **Class** | **ID** | **Method** | **Output** |
| --- | --- | --- | --- | --- |
| 1 | Impostor | I1 | kill(P3) | P3 is dead |
| 2 | Player | P6 | isDoingTask(Floor) | isDone(true) |
| 3 | Impostor | I2 | kill(P4) | P4 is dead |
| 4 | Player | P5 | report(P4) | P4 body has been reported |

## The voting system
### How to vote someone out of the game by the players

| **#** | **Class** | **ID** | **Method** | **Output** |
| --- | --- | --- | --- | --- |
| 2 | Player | P5 | voteOut(P2) | One vote for P2 |
| 3 | Player | P1 | voteOut(P5) | One vote for P5 |
| 4 | Player | P2 | voteOut(P5) | Two votes for P5 |
| 5 | Player | P3 | voteOut(P5) | Three votes for P5 |
| 6 | Player | P4 | voteOut(P5) | Four votes for P5 |
| 7 | Player | P6 | voteOut(P2) | Two votes for P2 |
| 8 | Crewmate | R5 | isGhost(true) | R5 has become a ghost |

## End of the game
### How a game can end

| **#** | **Class** | **ID** | **Method** | **Output** |
| --- | --- | --- | --- | --- |
| 1 | Game | G1 | endGame() | G1 is finished. Impostors won |
| 2 | Game | G1 | endGame() | G1 is finished. Crewmates won |

# Student
## Software developer, tester, writer and editor

Virag Szabo (4727444)
