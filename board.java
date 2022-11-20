
public class board extends game {
    public String[][] boardmake(String[][] chessboard){
        chessboard[0][0] = "   ";
        chessboard[0][1] = "A  ";
        chessboard[0][2] = "B  ";
        chessboard[0][3] = "C  ";
        chessboard[0][4] = "D  ";
        chessboard[0][5] = "E  ";
        chessboard[0][6] = "F  ";
        chessboard[0][7] = "G  ";
        chessboard[0][8] = "H  ";
        chessboard[0][9] = "   ";
        
        chessboard[1][0] = "8 ";
        chessboard[1][1]="BR1";
        chessboard[1][2]="BN1";
        chessboard[1][3]="BB1";
        chessboard[1][4]="BQ1";
        chessboard[1][5]="BK1";
        chessboard[1][6]="BB2";
        chessboard[1][7]="BN2";
        chessboard[1][8]="BR2";
        chessboard[1][9] = " 8";

        chessboard[2][0] = "7 ";
        for(int i=1;i<9;i++){
            chessboard[2][i]="B"+Integer.toString(i)+" ";
        }
        chessboard[2][9] = " 7";

        for(int i=3;i<7;i++){
            chessboard[i][0] = Integer.toString(9-i) + " ";
            chessboard[i][9] = " " + Integer.toString(9-i);
            for(int j=1;j<9;j++){
                chessboard[i][j] = "-  ";
            }
        }

        chessboard[7][0] = "2 ";
        for(int i=1;i<9;i++){
            chessboard[7][i]="W"+Integer.toString(i)+" ";
        }
        chessboard[7][9] = " 2 ";
        chessboard[8][0] = "1 ";
        chessboard[8][1]="WR1";
        chessboard[8][2]="WN1";
        chessboard[8][3]="WB1";
        chessboard[8][4]="WQ1";
        chessboard[8][5]="WK1";
        chessboard[8][6]="WB2";
        chessboard[8][7]="WN2";
        chessboard[8][8]="WR2";
        chessboard[8][9] = " 1";

        chessboard[9][0] = "   ";
        chessboard[9][1] = "A  ";
        chessboard[9][2] = "B  ";
        chessboard[9][3] = "C  ";
        chessboard[9][4] = "D  ";
        chessboard[9][5] = "E  ";
        chessboard[9][6] = "F  ";
        chessboard[9][7] = "G  ";
        chessboard[9][8] = "H  ";
        chessboard[9][9] = "   ";
        
        return chessboard;
    }
}
