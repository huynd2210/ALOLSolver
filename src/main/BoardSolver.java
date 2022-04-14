package main;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

public class BoardSolver {
    public void addboard(Board gameboard) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Size ");
        gameboard.size = sc.nextInt(); // set size of Board (assume Board is square)
        gameboard.board = new char[gameboard.size][gameboard.size];
        intitalizeboard(gameboard, sc);
        printBoard(gameboard);
        Inputchange(gameboard);     // ask if user want to change input
    }

    private void intitalizeboard(Board gameboard, Scanner sc) {
        for (int i = 0; i < gameboard.size; ) {  //marked with '-' is empty
            System.out.println("Row " + ++i);
            String row = "";

            while (row.length() != gameboard.size) { // check if input correct
                row = sc.next();
            }
            for (int j = 0; j < gameboard.size; ++j) {
                gameboard.board[i - 1][j] = row.charAt(j);
            }
        }
    }

    private void Inputchange(Board gameboard) {
        System.out.println("Change board? (y/n)");
        Scanner sc = new Scanner(System.in);
        String in = sc.next();

        if (Objects.equals(in, "y")) {
            int i = 1;
            while (i <= gameboard.size) {
                System.out.println("Row (0 to confirm change)");
                i = sc.nextInt();
                if (i < 1) {
                    break;
                }
                System.out.println("Input:");
                String row = "";

                while (row.length() != gameboard.size) {
                    row = sc.next();
                }
                for (int j = 0; j < gameboard.size; ++j) {
                    gameboard.board[i - 1][j] = row.charAt(j);
                }
            }
            printBoard(gameboard);
        }
    }

    public void printBoard(Board gameboard) {
        System.out.println("Board +");
        System.out.println(BoardtoString(gameboard));
    }

    private String BoardtoString(Board gameboard) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < gameboard.size; i++) {
            for (int j = 0; j < gameboard.size; j++) {
                sb.append(gameboard.board[i][j]).append(" ");
            }
            sb.append('\n');
        }
        return sb.toString();
    }

    //Return empty spot on board as [i,j]. Return empty list [] if there are no empty place.
    private List<Integer> findEmpty(Board gameboard) { // find empty place to fill
        for (int row = 0; row < gameboard.size; row++) {
            for (int col = 0; col < gameboard.size; col++) {
                if (gameboard.board[row][col] == '-') { //marked with '-' is empty
                    return List.of(row, col);
                }
            }
        }
        return new ArrayList<>();
    }

    private boolean isBoardChange(Board gameboard, String previous_board) {
        return !BoardtoString(gameboard).equals(previous_board);
    }

    private void fillSpot(Board gameBoard, int i, int j, char input){
        gameBoard.board[i][j] = input;
    }

    private void backtrack(Board gameBoard, Logic gameLogic, Board lastState, char fill) {
        List<Integer> emptySpots = findEmpty(gameBoard);

        while (!emptySpots.isEmpty()) {
            Board gameBoardCopy = new Board(gameBoard); // copy for backtrack in case mistake was made
            fillSpot(gameBoard, emptySpots.get(0), emptySpots.get(1), fill);
            if (gameLogic.isBoardCorrect(gameBoard)) {
                int isDone = solveOneRoundWithTechnique(gameBoard, gameLogic);

                //if done
                if (isDone == 1){
                    if (gameLogic.isBoardCorrect(gameBoard)){
                        System.out.println("Done");
                        printBoard(gameBoard);
                        System.exit(0);
                    }else{
                        //filled all entry but not correct throws error
                        throw new IllegalStateException("Should not reach this state, please debug");
                    }
                }else if (isDone == 0){
                    backtrack(gameBoard, gameLogic, gameBoardCopy, );
                }else{
                    //not correct, backtrack (return)
                }

            }

        }

    }

    //Try to solve using techniques, if 1 (and board is correct) then solved, if 0 board cannot yet be solved with techniques
    //if -1 then board was not consistent
    public int solveOneRoundWithTechnique(Board gameboard, Logic gameLogic) {
        Logic gamelogic = new Logic();

        while (!findEmpty(gameboard).isEmpty()) {
            String previous_board = BoardtoString(gameboard);
            gamelogic.RowSolve(gameboard);
            gamelogic.ColSolve(gameboard);

            if (!gameLogic.isBoardCorrect(gameboard)){
                return -1;
            }

            if (!isBoardChange(gameboard, previous_board)) {
                return 0; //cannot yet solve
            }
        }
        return 1;
    }

    public void Solve(Board gameboard) {
        Logic gamelogic = new Logic();

        while (!findEmpty(gameboard).isEmpty()) {
            String previous_board = BoardtoString(gameboard);
            gamelogic.RowSolve(gameboard);
            gamelogic.ColSolve(gameboard);

            if (!isBoardChange(gameboard, previous_board)) {
                System.out.println("No solution!");
                printBoard(gameboard);
                System.exit(0);
            }
        }
        printBoard(gameboard);
    }
}


