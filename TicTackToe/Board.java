package TicTackToe;

public class Board {
    private int size;
    private PlayingPiece[][] board;

    public Board(int size) {
        this.size = size;
        board = new PlayingPiece[size][size];

        for (int i = 0; i < size; i++){
            for (int j = 0; j < size; j++) {
                board[i][j] = new PlayingPiece(PieceType.K);
            }

        }

    }

    public boolean checkFreeSpaceInboard() {

        for (int i = 0; i < size; i++){
            for (int j = 0; j < size; j++){
               if(board[i][j].getPieceType() == PieceType.K){
                  return true;
               }
            }
        }

        return false;
    }

    public void printBoard() {
        for (int i = 0; i < size; i++){
            for (int j = 0; j < size; j++){
                if(board[i][j].getPieceType() == PieceType.K)
                    System.out.print(" ");
                else    
                    System.out.print(board[i][j].getPieceType());
            }
            System.out.println();
        }
    }

    public boolean addPiece(int inputRow, int inputColumn, PieceType playingPiece) {
        System.out.println("inputrow "+inputRow+" "+inputColumn+" "+size);
        if(inputRow < 0 || inputColumn <0 || inputColumn>=size || inputRow>=size){
            System.out.println("in this cond");
            return false;
        }
        if(board[inputRow][inputColumn].getPieceType() != PieceType.K){
            System.out.println("in this cond ...");
            return false;
        }

        board[inputRow][inputColumn].setPieceType(playingPiece);     
        return true;
    }

    public boolean checkWinner(int inputRow, int inputColumn,  PieceType playingPiece){
        boolean rowMatch = true;
        boolean columnMatch = true;
        boolean diagonalMatch = true;
        boolean antiDiagonalMatch = true;
        for(int j=0; j<size;j++){
           if(board[inputRow][j].getPieceType() == PieceType.K || board[inputRow][j].getPieceType() != playingPiece)
                rowMatch = false;
        }

        for(int i=0; i<size;i++){
            if(board[i][inputColumn].getPieceType() == PieceType.K || board[i][inputColumn].getPieceType() != playingPiece)
                columnMatch = false;
        }


        for(int j=0; j<size;j++){
            if(board[inputRow][j].getPieceType() == PieceType.K || board[inputRow][j].getPieceType() != playingPiece)
                 diagonalMatch = false;
         }

        int i,j;
        i=j=0;

        while(i<size && j<size){
            if(board[i][j].getPieceType() == PieceType.K || board[i][j].getPieceType() != playingPiece)
                 antiDiagonalMatch = false;
            i++;j++;
        }

        i=0;
        j=size-1;
        while(i<size && j>0){
            if(board[i][j].getPieceType() == PieceType.K || board[i][j].getPieceType() != playingPiece) {
                antiDiagonalMatch = false;
            }
             i++;j--;
        }
 
        System.out.println("rowMatch "+rowMatch+" "+columnMatch+" "+diagonalMatch+" "+antiDiagonalMatch);

        return rowMatch || columnMatch || diagonalMatch || antiDiagonalMatch;
    }

}