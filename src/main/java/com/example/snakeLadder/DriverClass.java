package com.example.snakeLadder;

import com.example.snakeLadder.models.Ladder;
import com.example.snakeLadder.models.Player;
import com.example.snakeLadder.models.Snake;
import com.example.snakeLadder.services.SnakeBoardService;

import java.util.*;

public class DriverClass {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int noOfSnakes = scanner.nextInt();
        List<Snake> snakes = new ArrayList<>(noOfSnakes);
        for (int i = 0; i < noOfSnakes; i++) {
            snakes.add(new Snake(scanner.nextInt(), scanner.nextInt()));
        }
        int noOfLadders = scanner.nextInt();
        List<Ladder> ladders = new ArrayList<>(noOfLadders);
        for (int i = 0; i < noOfLadders; i++) {
            ladders.add(new Ladder(scanner.nextInt(), scanner.nextInt()));
        }
        int noOfPlayers = scanner.nextInt();
        Queue<Player> players = new LinkedList<>();
        for (int i = 0; i < noOfPlayers; i++) {
            players.add(new Player(scanner.next()));
        }
        int boardSize = scanner.nextInt();
        SnakeBoardService snakeBoardService=new SnakeBoardService();
        snakeBoardService.createSnakeLadderGame(boardSize,ladders,snakes);
        snakeBoardService.playGame(players);
        System.out.println(snakeBoardService.getWinner(players).getName());


    }
}
