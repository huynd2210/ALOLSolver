package main;

import java.util.Objects;
import java.util.Scanner;

public class BoardMethod {
    public void addboard(Board gameboard) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Size ");
        gameboard.size = sc.nextInt(); // set size of Board (assume Board is square)
        gameboard.board = new char[gameboard.size][gameboard.size];
                                            // initialize board
        for (int i = 0; i < gameboard.size;) {  //marked with '-' is empty
            System.out.println("Row " + ++i);
            String row = "";

            while (row.length() != gameboard.size) { // check if input correct
                row = sc.next();
            }
            for (int j = 0; j < gameboard.size; ++j) {
                gameboard.board[i-1][j] = row.charAt(j);
            }
        }
        printBoard(gameboard);
        Inputchange(gameboard);     // ask if user want to change input
    }
    private void Inputchange(Board gameboard){
        System.out.println("Change board? (y/n)");
        Scanner sc = new Scanner(System.in);
        String in = sc.next();

        if (Objects.equals(in, "y")){
            int i = 1;
            while (i <= gameboard.size){
                System.out.println("Row (0 to confirm change)");
                i = sc.nextInt();
                if (i < 1){
                    break;
                }
                System.out.println("Input:");
                String row = "";

                while (row.length() != gameboard.size) {
                    row = sc.next();
                }
                for (int j = 0; j < gameboard.size; ++j) {
                    gameboard.board[i-1][j] = row.charAt(j);
                }
            }
            printBoard(gameboard);
        }
    }

    public void printBoard(Board gameboard) {
        System.out.println("Board +");
        System.out.println(BoardtoString(gameboard));
    }
    private String BoardtoString(Board gameboard){
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < gameboard.size; i++) {
            for (int j = 0; j < gameboard.size; j++) {
                sb.append(gameboard.board[i][j]).append(" ");
            }
            sb.append('\n');
        }
        return sb.toString();
    }

    private boolean findEmpty(Board gameboard){ // find empty place to fill
        for (int row = 0; row < gameboard.size; row++){
            for (int col = 0; col < gameboard.size; col++){
                if (gameboard.board[row][col] == '-'){ //marked with '-' is empty
                    return true;
                }
            }
        }
        return false;
    }

    private boolean Boardchange(Board gameboard1, Board gameboard2){
        return BoardtoString(gameboard1).equals(BoardtoString(gameboard2));
    }

    public void Solve(Board gameboard, Logic gamelogic) {
        while(findEmpty(gameboard)){
            gamelogic.RowSolve(gameboard);
            gamelogic.ColSolve(gameboard);
        }
        printBoard(gameboard);
    }
}


