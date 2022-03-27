package main;

import java.util.*;

import static main.BoardMethod.findEmpty;
import static main.Logic.*;

public class Main {
    public static void main(String[] args) {
        BoardMethod.addboard();

        BoardMethod.printBoard();

        while(findEmpty()){
            inconsecutiveRowSolver();
            inconsecutiveColSolver();
            RowCheck();
            ColCheck();

        }

        BoardMethod.printBoard();
}

}













