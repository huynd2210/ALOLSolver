package main;

public class Logic {
    public static void inconsecutiveRowSolver(){
        for (int i = 0; i < Board.size; i++) {
            for (int j = 0; j < Board.size-2; j++) {
                switch (Board.board[i][j]){
                    case '-' :
                        if(Board.board[i][j+1] == '0' && Board.board[i][j+2] == '0'){
                            Board.board[i][j] = '1';
                        }
                        if (Board.board[i][j+1] == '1' && Board.board[i][j+2] == '1'){
                            Board.board[i][j] = '0';
                        }
                        break;
                    case '1':
                        if(Board.board[i][j+1] == '-' && Board.board[i][j+2] == '1'){
                            Board.board[i][j+1] = '0';
                        }
                        if (Board.board[i][j+1] == '1' && Board.board[i][j+2] == '-'){
                            Board.board[i][j+2] = '0';
                        }
                        break;
                    case '0':
                        if(Board.board[i][j+1] == '-' && Board.board[i][j+2] == '0'){
                            Board.board[i][j+1] = '1';
                        }
                        if (Board.board[i][j+1] == '0' && Board.board[i][j+2] == '-'){
                            Board.board[i][j+2] = '1';
                        }
                        break;
                }
            }
        }
    }

    public static void inconsecutiveColSolver(){
        for (int i = 0; i < Board.size-2; i++) {
            for (int j = 0; j < Board.size; j++) {
                switch (Board.board[i][j]){
                    case '-' :
                        if(Board.board[i+1][j] == '0' && Board.board[i+2][j] == '0'){
                            Board.board[i][j] = '1';
                        }
                        if (Board.board[i+1][j] == '1' && Board.board[i+2][j] == '1'){
                            Board.board[i][j] = '0';
                        }
                        break;
                    case '1':
                        if(Board.board[i+1][j] == '-' && Board.board[i+2][j] == '1'){
                            Board.board[i+1][j] = '0';
                        }
                        if (Board.board[i+1][j] == '1' && Board.board[i+2][j] == '-'){
                            Board.board[i+2][j] = '0';
                        }
                        break;
                    case '0':
                        if(Board.board[i+1][j] == '-' && Board.board[i+2][j] == '0'){
                            Board.board[i+1][j] = '1';
                        }
                        if (Board.board[i+1][j] == '0' && Board.board[i+2][j] == '-'){
                            Board.board[i+2][j] = '1';
                        }
                        break;
                }
            }
        }
    }

    public static void RowFill(int i, char missingelement){
        for (int j = 0; j < Board.size; j++) {
            if (Board.board[i][j] == '-'){
                Board.board[i][j] = missingelement;
            }
        }
    }

    public static void RowCheck(){
        for (int i = 0; i < Board.size; i++){
            int count0 = 0;
            int count1 = 0;
            int missing = 0;
            for (int j = 0; j < Board.size; j++){
                if (Board.board[i][j] == '1'){
                    count1++;
                }else if (Board.board[i][j] == '0'){
                    count0++;
                }else{
                    missing++;
                }
            }
            if (missing !=0 && missing < Board.size/2 && count1 == Board.size/2){
                RowFill(i,'0');
            }else if (missing !=0 && missing < Board.size/2 && count0 == Board.size/2){
                RowFill(i,'1');
            }

        }
    }


    public static void ColFill(int j, char missingelement){
        for (int i = 0; i < Board.size; i++) {
            if (Board.board[i][j] == '-'){
                Board.board[i][j] = missingelement;
            }
        }
    }

    public static void ColCheck(){
        for (int j = 0; j < Board.size; j++){
            int count0 = 0;
            int count1 = 0;
            int missing = 0;
            for (int i = 0; i < Board.size; i++){
                if (Board.board[i][j] == '1'){
                    count1++;
                }else if (Board.board[i][j] == '0'){
                    count0++;
                }else{
                    missing++;
                }
            }
            if (missing !=0 && missing < Board.size/2 && count1 == Board.size/2){
                ColFill(j,'0');
            }else if (missing !=0 && missing < Board.size/2 && count0 == Board.size/2){
                ColFill(j,'1');
            }

        }
    }
}

