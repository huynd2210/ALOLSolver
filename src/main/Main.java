package main;

//step 1: run basic algorithm until cannot solve further:
//-> run basic algorithm until board doesnt change using String.equals()
//step 2: implement backtracking

import static main.BoardMethod.*;

public class Main{

    public static void main(String[] args) {
        Board board1 = new Board();
        Logic logic = new Logic();
        BoardMethod test = new BoardMethod();
        test.addboard(board1);

        long start = System.nanoTime();

        test.Solve(board1, logic);

        long end = System.nanoTime();
        long execution = end - start;
        System.out.println("Execution time: " + execution + " nanoseconds");
    }

}













