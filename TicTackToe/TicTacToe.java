package TicTackToe;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class TicTacToe {
    Queue<Player> nextTurn;
    Board board;


    public void intializeGame(){
        nextTurn = new LinkedList<>();

        PlayingPieceX crossPiece = new PlayingPieceX();
        PlayingPieceO zeroPiece = new PlayingPieceO();

        Player player1 = new Player("Player1", crossPiece);
        Player player2 = new Player("Player2", zeroPiece);

        nextTurn.add(player1);
        nextTurn.add(player2);

        //initializeBoard
        board = new Board(3);
    }

    public void startGame(){
        while(true){
            Player currPlayer = nextTurn.poll();
            board.printBoard();
            System.out.println("Player turn :"+currPlayer.getName()+" Enter row Column piece"+currPlayer.getPlayingPiece().getPieceType());
            Scanner inputScanner = new Scanner(System.in);
            String s = inputScanner.nextLine();
            String[] values = s.split(",");

            int inputRow = Integer.valueOf(values[0]);
            int inputColumn = Integer.valueOf(values[1]);

            boolean addedSuccessfully = board.addPiece(inputRow, inputColumn, currPlayer.getPlayingPiece().getPieceType());
            if(!addedSuccessfully){
                System.out.println("invalid row and column");
                nextTurn.offer(currPlayer);
                continue;
            }

            if(board.checkWinner(inputRow, inputColumn, currPlayer.getPlayingPiece().getPieceType())){
                System.out.println("winner is "+currPlayer.getName());
                break;
            } else if(!board.checkFreeSpaceInboard()){
                System.out.println("tie ");
                break;
            } else {
                nextTurn.offer(currPlayer);
            }

        }
    } 
}
