package main;

public class Logic{
    private void inconsecutiveRowSolver(Board gameboard){
        for (int i = 0; i < gameboard.size; i++) {
            for (int j = 0; j < gameboard.size-2; j++) {

                switch (gameboard.board[i][j]){
                    case '-' :
                        if(gameboard.board[i][j+1] == '0' && gameboard.board[i][j+2] == '0'){
                            gameboard.board[i][j] = '1';
                        }
                        if (gameboard.board[i][j+1] == '1' && gameboard.board[i][j+2] == '1'){
                            gameboard.board[i][j] = '0';
                        }
                        break;
                    case '1':
                        if(gameboard.board[i][j+1] == '-' && gameboard.board[i][j+2] == '1'){
                            gameboard.board[i][j+1] = '0';
                        }
                        if (gameboard.board[i][j+1] == '1' && gameboard.board[i][j+2] == '-'){
                            gameboard.board[i][j+2] = '0';
                        }
                        break;
                    case '0':
                        if(gameboard.board[i][j+1] == '-' && gameboard.board[i][j+2] == '0'){
                            gameboard.board[i][j+1] = '1';
                        }
                        if (gameboard.board[i][j+1] == '0' && gameboard.board[i][j+2] == '-'){
                            gameboard.board[i][j+2] = '1';
                        }
                        break;
                }
            }
        }
    }

    private void inconsecutiveColSolver(Board gameboard){
        for (int i = 0; i < gameboard.size-2; i++) {
            for (int j = 0; j < gameboard.size; j++) {
                switch (gameboard.board[i][j]){
                    case '-' :
                        if(gameboard.board[i+1][j] == '0' && gameboard.board[i+2][j] == '0'){
                            gameboard.board[i][j] = '1';
                        }
                        if (gameboard.board[i+1][j] == '1' && gameboard.board[i+2][j] == '1'){
                            gameboard.board[i][j] = '0';
                        }
                        break;
                    case '1':
                        if(gameboard.board[i+1][j] == '-' && gameboard.board[i+2][j] == '1'){
                            gameboard.board[i+1][j] = '0';
                        }
                        if (gameboard.board[i+1][j] == '1' && gameboard.board[i+2][j] == '-'){
                            gameboard.board[i+2][j] = '0';
                        }
                        break;
                    case '0':
                        if(gameboard.board[i+1][j] == '-' && gameboard.board[i+2][j] == '0'){
                            gameboard.board[i+1][j] = '1';
                        }
                        if (gameboard.board[i+1][j] == '0' && gameboard.board[i+2][j] == '-'){
                            gameboard.board[i+2][j] = '1';
                        }
                        break;
                }
            }
        }
    }
            // merge with colfill (rename)
    private void RowFill(Board gameboard, int i, char missingelement){
        for (int j = 0; j < gameboard.size; j++) {
            if (gameboard.board[i][j] == '-'){
                gameboard.board[i][j] = missingelement;
            }
        }
    }

    public void RowSolve(Board gameboard){
        inconsecutiveRowSolver(gameboard);
        for (int i = 0; i < gameboard.size; i++){
            int count0 = 0;
            int count1 = 0;
            int missing = 0;
            for (int j = 0; j < gameboard.size; j++){
                if (gameboard.board[i][j] == '1'){
                    count1++;
                }else if (gameboard.board[i][j] == '0'){
                    count0++;
                }else{
                    missing++;
                }
            }
            if (missing !=0 && missing < gameboard.size/2){
                if(count1 == gameboard.size/2){
                    RowFill(gameboard, i,'0');
                }
                if (count0 == gameboard.size/2){
                    RowFill(gameboard, i,'1');
                }
            }

            if(missing > 2){
                if (count1 >2 || count0 >2){
                    Logic3Row(gameboard, i);
                }
                if (gameboard.size - count0 == 1 || gameboard.size - count1 == 1){
                    Logic4Row(gameboard, i);
                }
            }
        }
    }

    private void ColFill(Board gameboard, int j, char missingelement){
        for (int i = 0; i < gameboard.size; i++) {
            if (gameboard.board[i][j] == '-'){
                gameboard.board[i][j] = missingelement;
            }
        }
    }

    public void ColSolve(Board gameboard){
        inconsecutiveColSolver(gameboard);
        for (int j = 0; j < gameboard.size; j++){
            int count0 = 0;
            int count1 = 0;
            int missing = 0;
            for (int i = 0; i < gameboard.size; i++){
                if (gameboard.board[i][j] == '1'){
                    count1++;
                }else if (gameboard.board[i][j] == '0'){
                    count0++;
                }else{
                    missing++;
                }
            }

            if (missing !=0 && missing < gameboard.size/2){
                if(count1 == gameboard.size/2){
                    ColFill(gameboard, j,'0');
                }
                if (count0 == gameboard.size/2){
                    ColFill(gameboard, j,'1');
                }
            }

            if(missing > 2){
                if (count1 >2 || count0 >2){
                    Logic3Col(gameboard, j);
                }
                if (gameboard.size - count0 == 1 || gameboard.size - count1 == 1){
                    Logic4Col(gameboard, j);
                }
            }
        }
    }
        // improve logic 3 4 (in progress)
    private void Logic3Row(Board gameboard, int i) {
        for (int j = 0; j < gameboard.size - 5; j++) {
            if (gameboard.board[i][j + 1] == '-' && gameboard.board[i][j + 2] == '-' && gameboard.board[i][j + 3] == '-' && gameboard.board[i][j + 4] == '-') {
                if (gameboard.board[i][j] == '0' && gameboard.board[i][j + 5] == '0') {
                    gameboard.board[i][j + 1] = '1';
                    gameboard.board[i][j + 4] = '1';
                }
                if (gameboard.board[i][j] == '1' && gameboard.board[i][j + 5] == '1') {
                    gameboard.board[i][j + 1] = '0';
                    gameboard.board[i][j + 4] = '0';
                }
            }
        }
    }

    private void Logic4Row(Board gameboard, int i) {
        for (int j = 0; j < gameboard.size - 5; j++) {
            if (gameboard.board[i][j + 3] == '-' && gameboard.board[i][j + 4] == '-' && gameboard.board[i][j + 5] == '-') {
                if (gameboard.board[i][j] == '0' && gameboard.board[i][j + 1] == '0' && gameboard.board[i][j + 2] == '1') {
                    gameboard.board[i][j + 5] = '1';
                }
                if (gameboard.board[i][j] == '1' && gameboard.board[i][j + 1] == '1' && gameboard.board[i][j + 2] == '0') {
                    gameboard.board[i][j + 5] = '0';
                }
            }
        }
    }

    private void Logic3Col(Board gameboard, int j) {
        for (int i = 0; i < gameboard.size - 5; i++) {
            if (gameboard.board[i + 1][j] == '-' && gameboard.board[i + 2][j] == '-' && gameboard.board[i + 3][j] == '-' && gameboard.board[i + 4][j] == '-') {
                if (gameboard.board[i][j] == '0' && gameboard.board[i + 5][j] == '0') {
                    gameboard.board[i + 1][j] = '1';
                    gameboard.board[i + 4][j] = '1';
                }
                if (gameboard.board[i][j] == '1' && gameboard.board[i][j + 5] == '1') {
                    gameboard.board[i + 1][j] = '0';
                    gameboard.board[i + 4][j] = '0';
                }
            }
        }
    }

    private void Logic4Col(Board gameboard, int j) {
        for (int i = 0; i < gameboard.size - 5; i++) {
            if (gameboard.board[i + 3][j] == '-' && gameboard.board[i + 4][j] == '-' && gameboard.board[i + 5][j] == '-') {
                if (gameboard.board[i][j] == '0' && gameboard.board[i + 1][j] == '0' && gameboard.board[i][j + 2] == '1') {
                    gameboard.board[i + 5][j] = '1';
                }
                if (gameboard.board[i][j] == '1' && gameboard.board[i + 1][j] == '1' && gameboard.board[i + 2][j] == '0') {
                    gameboard.board[i + 5][j] = '0';
                }
            }
        }
    }

}

