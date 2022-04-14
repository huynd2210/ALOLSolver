package main;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

public class BoardSolver {
    public void addboard(Board gameBoard) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Size ");
        gameBoard.size = sc.nextInt(); // set size of Board (assume Board is square)
        gameBoard.board = new char[gameBoard.size][gameBoard.size];
        intitalizeBoard(gameBoard, sc);
        Inputchange(gameBoard);     // ask if user want to change input
    }

    private void intitalizeBoard(Board gameBoard, Scanner sc) {
        for (int i = 0; i < gameBoard.size;) {  //marked with '-' is empty
            System.out.println("Row " + ++i);
            String row = "";

            while (row.length() != gameBoard.size) { // check if input correct
                row = sc.next();
            }
            for (int j = 0; j < gameBoard.size; ++j) {
                gameBoard.board[i-1][j] = row.charAt(j);
            }
        }
        Logic gameLogic = new Logic();
        while (!gameLogic.isBoardCorrect(gameBoard)){
            System.out.println("incorrect Board input ");
            printBoard(gameBoard);
            System.out.println("Please change the incorrect input");
            newInput(gameBoard);
        }

    }

    private void Inputchange(Board gameBoard){
        System.out.println("Change board? (y/n)");
        Scanner sc = new Scanner(System.in);
        String in = sc.next();

        if (Objects.equals(in, "y")){
            newInput(gameBoard);
        }
    }

    private void newInput(Board gameBoard) {
        int i = 1;
        while (i <= gameBoard.size){
            Scanner sc = new Scanner(System.in);
            System.out.println("Row (0 to confirm change)");
            i = sc.nextInt();
            if (i < 1){
                break;
            }
            System.out.println("Input:");
            String row = "";

            while (row.length() != gameBoard.size) {
                row = sc.next();
            }
            for (int j = 0; j < gameBoard.size; ++j) {
                gameBoard.board[i-1][j] = row.charAt(j);
            }
        }
        printBoard(gameBoard);
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

    private List<Integer> findEmpty(Board gameboard){ // find empty place to fill
        for (int row = 0; row < gameboard.size; row++){
            for (int col = 0; col < gameboard.size; col++){
                if (gameboard.board[row][col] == '-'){ //marked with '-' is empty
                    return List.of(row, col);
                }
            }
        }
        return new ArrayList<>();
    }

    private boolean Boardchange(Board gameboard, String previous_board){
        return BoardtoString(gameboard).equals(previous_board);
    }

    public void backtrack(Board board, Logic logic){
//        while
    }

    public void Solve(Board gameboard) {
        Logic gameLogic= new Logic();

        while(!findEmpty(gameboard).isEmpty()){
            String previous_board = BoardtoString(gameboard);
            gameLogic.RowSolve(gameboard);
            gameLogic.ColSolve(gameboard);

            if (Boardchange(gameboard, previous_board)){
                System.out.println("No solution!");
                System.exit(0);
            }
        }
        printBoard(gameboard);
    }
}


