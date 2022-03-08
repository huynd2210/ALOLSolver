package main;

import java.util.Scanner;

public class Board {

    static char[][] board;
    static int size =0;

    public Board(){}

    public static void addboard() {
        Scanner sc= new Scanner(System.in);
        System.out.print("Size ");
        size= sc.nextInt();
        board = new char[size][size];
        for (int i=0; i < size; i++) {
            System.out.println("Row " + i);
            String row ="";
            while (row.length() !=size){
                row = sc.next();
            }
            for (int j = 0; j < size; ++j) {
                board[i][j] = row.charAt(j);
            }
        }
    }

    public static void printBoard() {
        System.out.println("\n + Board +");
        for (int i =0; i < size; i++){
            for (int j = 0; j < size; j++) {
                System.out.print(board[i][j]);
            }
            System.out.print('\n');
        }
    }

    public static void setto0(int row, int colum) {
        board[row][colum] = '1';
    }
    public static void setto1(int row, int colum) {
        board[row][colum] = '0';
    }

    // test
//    public static void main(String[] args) {
//        Board test= new Board();
//        addboard();
//        printBoard();
//        setto0(1,1);
//        printBoard();
//    }

}
