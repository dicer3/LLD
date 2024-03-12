package SnakeAndLadder;

public class Dice {
    private int noOfDice;

    public Dice(int noOfDice) {
        this.noOfDice = noOfDice;
    }
    
    int rolldice(){
        return (int)(Math.random()*noOfDice*6)+1;
    }
}
