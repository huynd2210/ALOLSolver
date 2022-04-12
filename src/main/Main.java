package main;

//step 1: run basic algorithm until cannot solve further: (done)
//-> run basic algorithm until board doesnt change using String.equals()
//step 2: implement backtracking (in progress)

public class Main{

    public static void main(String[] args) {
        Board board1 = new Board();
        BoardSolver test = new BoardSolver();
        test.addboard(board1);

        long start = System.nanoTime();

        test.Solve(board1);

        long end = System.nanoTime();
        long execution = end - start;
        System.out.println("Execution time: " + execution + " nanoseconds");
    }

}













