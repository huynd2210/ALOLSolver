package main;

import java.util.Scanner;
public class BoardMethod {
    public static void addboard() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Size ");
        Board.size = sc.nextInt(); // set size of Board (Board is square)
        Board.board = new char[Board.size][Board.size];
                                            // initialize board
        for (int i = 0; i < Board.size;) {  //marked with - is empty
            System.out.println("Row " + ++i);
            String row = "";

            while (row.length() != Board.size) { // check if input correct
                row = sc.next();
            }
            for (int j = 0; j < Board.size; ++j) {
                Board.board[i-1][j] = row.charAt(j);
            }
        }
    }

    public static void printBoard() {
        System.out.println("\n + Board +");
        for (int i = 0; i < Board.size; i++) {
            for (int j = 0; j < Board.size; j++) {
                System.out.print(Board.board[i][j] + " ");
            }
            System.out.print('\n');
        }
    }

}


