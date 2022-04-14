package main;
public class Board {

    public char[][] board;
    public int size;

    public Board(){

    }

    //Copy Constructor
    public Board(Board copy){
        this.size = copy.size;
        this.board = new char[this.size][this.size];
        for (int i = 0; i < copy.board.length; i++) {
            System.arraycopy(copy.board[i], 0, this.board[i], 0, copy.board[i].length);
        }

    }
}
