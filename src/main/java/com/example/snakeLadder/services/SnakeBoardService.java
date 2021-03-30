package com.example.snakeLadder.services;

import com.example.snakeLadder.models.Ladder;
import com.example.snakeLadder.models.Player;
import com.example.snakeLadder.models.Snake;
import com.example.snakeLadder.models.SnakeLadderBoard;

import java.util.List;
import java.util.Map;
import java.util.Queue;

public class SnakeBoardService {
    private SnakeLadderBoard snakeLadderBoard;
    public void createSnakeLadderGame(int boardSize, List<Ladder> ladders, List<Snake> snakes)
    {
        this.snakeLadderBoard=new SnakeLadderBoard(boardSize);
        snakeLadderBoard.setLadders(ladders);
        snakeLadderBoard.setSnakes(snakes);
    }
    public void playGame(Queue<Player> players)
    {
        Map<Player,Integer> playerPositions= this.snakeLadderBoard.getPlayerPositions();
        while(!this.snakeLadderBoard.isGameCompleted)

            for(Player player:players) {

                int currPosition=getCurrentPosition(player,playerPositions);
                System.out.println("player: "+player.getName()+" move: "+currPosition);
                playerPositions.put(player, currPosition);
                this.snakeLadderBoard.setPlayerPositions(playerPositions);

                if(checkGameCompleted(currPosition,player))
                    break;

            }
    }
    public int getCurrentPosition(Player player,Map<Player,Integer> playerPositions){
        int currPosition = DiceService.roll();
        List<Snake> snakes=this.snakeLadderBoard.getSnakes();
        List<Ladder> ladders=this.snakeLadderBoard.getLadders();
        Integer prevPosition=playerPositions.get(player);
        int snakeBoardSize=this.snakeLadderBoard.getSize();
        if(currPosition>snakeBoardSize)
            currPosition=0;
        if(prevPosition!=null) {
            currPosition = prevPosition + currPosition;
            if (currPosition > snakeBoardSize)
                currPosition = prevPosition;
        }
        for(Snake snake:snakes)
        {
            if(snake.getStart()==currPosition)
                currPosition=snake.getEnd();
        }
        for(Ladder ladder:ladders)
        {
            if(ladder.getStart()==currPosition)
                currPosition=ladder.getEnd();
        }
        return currPosition;

    }
    public boolean checkGameCompleted(int position, Player player)
    {
        if(position==this.snakeLadderBoard.getSize()) {
            this.snakeLadderBoard.isGameCompleted = true;
            player.setStatus("Winner");
            return true;
        }
        return false;
    }
    public Player getWinner(Queue<Player> players)
    {

        for(Player player:players)
        {
            if(player.getStatus().equals("Winner"))
                return player;
        }
        return players.poll();
    }

}
