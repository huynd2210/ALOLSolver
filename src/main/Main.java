package main;
//step 2: implement backtracking

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













