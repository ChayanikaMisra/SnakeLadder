package com.example.snakeLadder.models;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SnakeLadderBoard {
    public boolean isGameCompleted;
    private final int size;
    private Map<Player, Integer> playerPositions;
    private List<Snake> snakes;
    private List<Ladder> ladders;

    public boolean isGameCompleted() {
        return isGameCompleted;
    }

    public void setGameCompleted(boolean gameCompleted) {
        isGameCompleted = gameCompleted;
    }

    public SnakeLadderBoard(int size) {
        this.size = size;
        this.snakes = new ArrayList<>();
        this.ladders = new ArrayList<>();
        this.playerPositions = new HashMap<>();
        this.isGameCompleted = false;
    }

    public int getSize() {
        return size;
    }

    public Map<Player, Integer> getPlayerPositions() {
        return playerPositions;
    }

    public void setPlayerPositions(Map<Player, Integer> playerPositions) {
        this.playerPositions = playerPositions;
    }

    public List<Snake> getSnakes() {
        return snakes;
    }

    public void setSnakes(List<Snake> snakes) {
        this.snakes = snakes;
    }

    public List<Ladder> getLadders() {
        return ladders;
    }

    public void setLadders(List<Ladder> ladders) {
        this.ladders = ladders;
    }
}
