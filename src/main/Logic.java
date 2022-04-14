package main;

public class Logic{
    private void inconsecutiveRowSolver(Board gameBoard){
        for (int i = 0; i < gameBoard.size; i++) {
            for (int j = 0; j < gameBoard.size-2; j++) {

                switch (gameBoard.board[i][j]){
                    case '-' :
                        if(gameBoard.board[i][j+1] == '0' && gameBoard.board[i][j+2] == '0'){
                            gameBoard.board[i][j] = '1';
                        }
                        if (gameBoard.board[i][j+1] == '1' && gameBoard.board[i][j+2] == '1'){
                            gameBoard.board[i][j] = '0';
                        }
                        break;
                    case '1':
                        if(gameBoard.board[i][j+1] == '-' && gameBoard.board[i][j+2] == '1'){
                            gameBoard.board[i][j+1] = '0';
                        }
                        if (gameBoard.board[i][j+1] == '1' && gameBoard.board[i][j+2] == '-'){
                            gameBoard.board[i][j+2] = '0';
                        }
                        break;
                    case '0':
                        if(gameBoard.board[i][j+1] == '-' && gameBoard.board[i][j+2] == '0'){
                            gameBoard.board[i][j+1] = '1';
                        }
                        if (gameBoard.board[i][j+1] == '0' && gameBoard.board[i][j+2] == '-'){
                            gameBoard.board[i][j+2] = '1';
                        }
                        break;
                }
            }
        }
    }

    private void inconsecutiveColSolver(Board gameBoard){
        for (int i = 0; i < gameBoard.size-2; i++) {
            for (int j = 0; j < gameBoard.size; j++) {
                switch (gameBoard.board[i][j]){
                    case '-' :
                        if(gameBoard.board[i+1][j] == '0' && gameBoard.board[i+2][j] == '0'){
                            gameBoard.board[i][j] = '1';
                        }
                        if (gameBoard.board[i+1][j] == '1' && gameBoard.board[i+2][j] == '1'){
                            gameBoard.board[i][j] = '0';
                        }
                        break;
                    case '1':
                        if(gameBoard.board[i+1][j] == '-' && gameBoard.board[i+2][j] == '1'){
                            gameBoard.board[i+1][j] = '0';
                        }
                        if (gameBoard.board[i+1][j] == '1' && gameBoard.board[i+2][j] == '-'){
                            gameBoard.board[i+2][j] = '0';
                        }
                        break;
                    case '0':
                        if(gameBoard.board[i+1][j] == '-' && gameBoard.board[i+2][j] == '0'){
                            gameBoard.board[i+1][j] = '1';
                        }
                        if (gameBoard.board[i+1][j] == '0' && gameBoard.board[i+2][j] == '-'){
                            gameBoard.board[i+2][j] = '1';
                        }
                        break;
                }
            }
        }
    }
            // merge with colfill (rename)
    private void RowFill(Board gameBoard, int i, char missingelement){
        for (int j = 0; j < gameBoard.size; j++) {
            if (gameBoard.board[i][j] == '-'){
                gameBoard.board[i][j] = missingelement;
            }
        }
    }

    public void RowSolve(Board gameBoard){
        inconsecutiveRowSolver(gameBoard);
        for (int i = 0; i < gameBoard.size; i++){
            int count0 = 0;
            int count1 = 0;
            int missing = 0;
            for (int j = 0; j < gameBoard.size; j++){
                if (gameBoard.board[i][j] == '1'){
                    count1++;
                }else if (gameBoard.board[i][j] == '0'){
                    count0++;
                }else{
                    missing++;
                }
            }
            if (missing !=0 && missing < gameBoard.size/2){
                if(count1 == gameBoard.size/2){
                    RowFill(gameBoard, i,'0');
                }
                if (count0 == gameBoard.size/2){
                    RowFill(gameBoard, i,'1');
                }
            }

            if(missing > 2){
                if (count1 >2 || count0 >2){
                    Logic3Row(gameBoard, i);
                }
                if (gameBoard.size - count0 == 1 || gameBoard.size - count1 == 1){
                    Logic4Row(gameBoard, i);
                }
            }
        }
    }

    private void ColFill(Board gameBoard, int j, char missingelement){
        for (int i = 0; i < gameBoard.size; i++) {
            if (gameBoard.board[i][j] == '-'){
                gameBoard.board[i][j] = missingelement;
            }
        }
    }

    public void ColSolve(Board gameBoard){
        inconsecutiveColSolver(gameBoard);
        for (int j = 0; j < gameBoard.size; j++){
            int count0 = 0;
            int count1 = 0;
            int missing = 0;
            for (int i = 0; i < gameBoard.size; i++){
                if (gameBoard.board[i][j] == '1'){
                    count1++;
                }else if (gameBoard.board[i][j] == '0'){
                    count0++;
                }else{
                    missing++;
                }
            }

            if (missing !=0 && missing < gameBoard.size/2){
                if(count1 == gameBoard.size/2){
                    ColFill(gameBoard, j,'0');
                }
                if (count0 == gameBoard.size/2){
                    ColFill(gameBoard, j,'1');
                }
            }

            if(missing > 2){
                if (count1 >2 || count0 >2){
                    Logic3Col(gameBoard, j);
                }
                if (gameBoard.size - count0 == 1 || gameBoard.size - count1 == 1){
                    Logic4Col(gameBoard, j);
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

    private void Logic3Col(Board gameBoard, int j) {
        for (int i = 0; i < gameBoard.size - 5; i++) {
            if (gameBoard.board[i + 1][j] == '-' && gameBoard.board[i + 2][j] == '-' && gameBoard.board[i + 3][j] == '-' && gameBoard.board[i + 4][j] == '-') {
                if (gameBoard.board[i][j] == '0' && gameBoard.board[i + 5][j] == '0') {
                    gameBoard.board[i + 1][j] = '1';
                    gameBoard.board[i + 4][j] = '1';
                }
                if (gameBoard.board[i][j] == '1' && gameBoard.board[i][j + 5] == '1') {
                    gameBoard.board[i + 1][j] = '0';
                    gameBoard.board[i + 4][j] = '0';
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

    //Check if board complies with rule (i.e correct)
    public boolean isBoardCorrect(Board gameBoard){
        int count0 = 0;
        int count1 = 0;

        for (int i = 0; i < gameBoard.size-2; i++) {
            for (int j = 0; j < gameBoard.size-2; j++) {
                if (gameBoard.board[i][j] != '-'){
                    if (gameBoard.board[i][j] == gameBoard.board[i+1][j] && gameBoard.board[i][j]== gameBoard.board[i+2][j]){
                        return false;
                    }
                    if (gameBoard.board[i][j] == gameBoard.board[i][j+1] && gameBoard.board[i][j]== gameBoard.board[i][j+2]){
                        return false;
                    }
                }
                if (gameBoard.board[i][j] == '1'){
                    count1++;
                }else if (gameBoard.board[i][j] == '0'){
                    count0++;
                }

                if (count0 > gameBoard.size/2 || count1 > gameBoard.size/2){
                    return false;
                }
            }
        }
        for (int i = gameBoard.size-2; i < gameBoard.size; i++) {
            for (int j = gameBoard.size-2; j < gameBoard.size; j++) {
                if (gameBoard.board[i][j] == '1'){
                    count1++;
                }else if (gameBoard.board[i][j] == '0'){
                    count0++;
                }

                if (count0 > gameBoard.size/2 || count1 > gameBoard.size/2){
                    return false;
                }
            }
        }
        return true;
    }
}

