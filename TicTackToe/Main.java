package TicTackToe;

public class Main {
    public static void main(String[] args) {
        TicTacToe tictacObj = new TicTacToe();
        tictacObj.intializeGame();
        System.out.println("starting game ");
        tictacObj.startGame();
    }
}
