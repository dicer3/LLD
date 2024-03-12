package SnakeAndLadder;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class PlaySnakeAndLadder {
    public static void main(String[] args) throws Exception {
        Dice d1 = new Dice(2);
        Player p1 = new Player("Alberts",1);
        Player p2 = new Player("Pintoss",2);

        Queue<Player> allPlayers = new LinkedList<>();
        allPlayers.offer(p1);
        allPlayers.offer(p2);

        List<Jump> snakes = new ArrayList<>();
        snakes.add(new Jump(10,2));
        snakes.add(new Jump(99,12));
        snakes.add(new Jump(52,37));


        List<Jump> ladders = new ArrayList<>();
        ladders.add(new Jump(5,25));
        ladders.add(new Jump(12,89));
        ladders.add(new Jump(55,92));
        ladders.add(new Jump(22,79));


        Map<String,Integer> playersCurrentPosition = new HashMap<>();
        playersCurrentPosition.put("Alberts",0);
        playersCurrentPosition.put("Pintoss",0);

        Gameboard gb=new Gameboard(d1,allPlayers,snakes,ladders,playersCurrentPosition,100);
        gb.startGame();

    }
}
