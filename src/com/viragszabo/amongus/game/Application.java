package com.viragszabo.amongus.game;

import com.viragszabo.amongus.map.GameMap;

import java.util.ArrayList;

public class Application {
    private String appName;
    private ArrayList<Game> games;
    private ArrayList<Player> players;
    private ArrayList<GameMap> gameMaps;

    public Application(String appName){
        this.appName = appName;
        this.games = new ArrayList<>();
        this.players = new ArrayList<>();
        this.gameMaps = new ArrayList<>();
    }

    public String getAppName() {
        return appName;
    }

    public ArrayList<Game> getGames() {
        return games;
    }

    public void addGame(Game game) {
        games.add(game);
    } // addGame

    public ArrayList<Player> getPlayers() { return players; }

    public void addPlayer(Player player) {
        players.add(player);
    } // addPlayer

    public ArrayList<GameMap> getGameMaps() {
        return gameMaps;
    }

    /**
     * add to a list the map
     * @param gameMap is the specific one
     */
    public void addGameMap(GameMap gameMap) { gameMaps.add(gameMap); }
}
