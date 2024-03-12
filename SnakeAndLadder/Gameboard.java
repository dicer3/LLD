package SnakeAndLadder;

import java.util.List;
import java.util.Map;
import java.util.Queue;

public class Gameboard {
    private Dice dice;
    private Queue<Player> nextTurn;
    private List<Jump> snakes;
    private List<Jump> ladders;
    private Map<String, Integer> playersCurrentPosition;
    private int boardSize;



    public Gameboard(Dice dice, Queue<Player> nextTurn, List<Jump> snakes, List<Jump> ladders,
            Map<String, Integer> playersCurrentPosition, int boardSize) {
        this.dice = dice;
        this.nextTurn = nextTurn;
        this.snakes = snakes;
        this.ladders = ladders;
        this.playersCurrentPosition = playersCurrentPosition;
        this.boardSize = boardSize;
    }



    void startGame(){
        while(true){
            Player currPlayer = nextTurn.poll();
            System.out.println("turn "+currPlayer.getPlayer());
            int turn = dice.rolldice();
            int currPlayerPosition = playersCurrentPosition.get(currPlayer.getPlayer());
            if(currPlayerPosition+turn>boardSize){
                System.out.println("turn "+currPlayer.getPlayer()+" out of board size "+currPlayer.getPlayer());
                nextTurn.offer(currPlayer);
                continue;
            }
            int nextCellAfterDiceThrow = currPlayerPosition + turn;
            System.out.println(currPlayer.getPlayer()+"rolled dice "+turn+" and player reached to "+nextCellAfterDiceThrow);
            if(nextCellAfterDiceThrow == boardSize){
                System.out.println("Player "+currPlayer.getPlayer()+" won the game");
                break;
            }
            boolean snikeBitted=false;
            boolean ladderClimbed=false;
            //int updatedCell = nextCellAfterDiceThrow;
            for(int i=0;i< snakes.size(); i++){
                if(nextCellAfterDiceThrow == snakes.get(i).startPoint){
                    snikeBitted = true;
                    nextCellAfterDiceThrow = snakes.get(i).endpoint;
                }
            }
            if(snikeBitted){
                System.out.println(currPlayer.getPlayer()+"got bitten by snake player reached "+nextCellAfterDiceThrow);
            }

            for(int i=0;i< ladders.size(); i++){
                if(nextCellAfterDiceThrow == ladders.get(i).startPoint){
                    ladderClimbed = true;
                    nextCellAfterDiceThrow = ladders.get(i).endpoint;
                }
            }

            if(ladderClimbed){
                System.out.println(currPlayer.getPlayer()+"climbed ladder "+nextCellAfterDiceThrow);
            }

            if(nextCellAfterDiceThrow == boardSize){
                System.out.println("Player "+currPlayer.getPlayer()+" won the game");
                break; 
            } else {
                nextTurn.offer(currPlayer);
                playersCurrentPosition.put(currPlayer.getPlayer(),nextCellAfterDiceThrow);
            }
        }
    }

    

}
