import java.util.List;
import java.util.ArrayList;
public class endgame extends game{
    private String winner = "";
    moving move = new moving();
    public void setWinner(String name){
        this.winner = name;
    }
    public String winner(){
        return winner;
    }
    public Boolean isend(String[][] chessboard, int turn,List<String> pawns){
        String place = "";
        int a=0,b=0,c=0,d=0;
        for(int i=0;i<10;i++){
            for(int j=0;j<10;j++){
                if(chessboard[i][j].equals("WK1")){
                    a=i;
                    b=j;
                }
                if(chessboard[i][j].equals("BK1")){
                    c=i;
                    d=j;
                }
            }
        }
        if(turn==1){
            List<Integer> possiblea = new ArrayList<Integer>();
            List<Integer> possibleb = new ArrayList<Integer>();
            List<Boolean> possible = new ArrayList<Boolean>();
            List <String> places2 = new ArrayList<String>();
            String[][] momentboard = new String[10][10];
            momentboard = chessboard.clone();
            Boolean change=false;
            Boolean chess=false;
            if(a==1 && b!=1 && b!=8){
                possiblea.add(a);
                possiblea.add(a+1);
                possibleb.add(b);
                possibleb.add(b-1);
                possibleb.add(b+1);

            }
            else if(a==8 && b!=1 && b!=8){
                possiblea.add(a);
                possiblea.add(a-1);
                possibleb.add(b);
                possibleb.add(b-1);
                possibleb.add(b+1);
            }
            else if(b==8 && a!=1 && a!=8){
                possiblea.add(a);
                possiblea.add(a-1);
                possiblea.add(a+1);
                possibleb.add(b);
                possibleb.add(b-1);
            }
            else if(b==1 && a!=1 && a!=8){
                possiblea.add(a);
                possiblea.add(a-1);
                possiblea.add(a+1);
                possibleb.add(b);
                possibleb.add(b+1);
            }
            else if(b==1 && a==1){
                possiblea.add(a);
                possiblea.add(a+1);
                possibleb.add(b);
                possibleb.add(b+1);
            }
            else if(b==8 && a==1){
                possiblea.add(a);
                possiblea.add(a+1);
                possibleb.add(b);
                possibleb.add(b-1);
            }
            else if(a==8 && b==8){
                possiblea.add(a);
                possiblea.add(a-1);
                possibleb.add(b);
                possibleb.add(b-1);
            }
            else if(a==8 && b==1){
                possiblea.add(a);
                possiblea.add(a-1);
                possibleb.add(b);
                possibleb.add(b+1);
            }
            else{
                possiblea.add(a);
                possiblea.add(a+1);
                possiblea.add(a-1);
                possibleb.add(b);
                possibleb.add(b+1);
                possibleb.add(b-1);
            }

            
            for(int i : possiblea){
                for(int j: possibleb){
                    chess = false;
                    Boolean ifpossible=false;
                    Boolean check=false;
                    place = chessboard[0][j].substring(0,1) + chessboard[i][0].substring(0,1);
                    ifpossible = chessboard[i][j].equals("-  ");
                    String firstpawn = chessboard[i][j];
                    if(chessboard[i][j].charAt(0)=='B') { ifpossible = true; }
                    if(i==a && j==b){ ifpossible=true; }
                    if(ifpossible==true){
                        momentboard[a][b] = "-  ";
                        momentboard[i][j] = "WK1";
                        for(String pawn: pawns){
                            char value = pawn.charAt(0);
                            char value2 = pawn.charAt(1);
                            change=false;
                            if(value=='B'){
                                if(value2=='R'){ change = move.Rook(pawn, place, momentboard);}
                                if(value2=='K'){ change = move.King(pawn, place, momentboard);}
                                if(value2=='Q'){ change = move.Queen(pawn, place, momentboard);}
                                if(value2=='B'){ change = move.Bishop(pawn, place, momentboard);}
                                if(value2=='N'){ change = move.Knight(pawn, place, momentboard);}
                                if(value2!='R' && value2!='K' && value2!='Q' && value2!='B' && value2!='N'){ change = move.Pawn(pawn, place, momentboard, true);}
                                if(change==true){chess=true;}
                            }
                            if(chess==true && a==i && b==j){
                                String pawnplace=" ";
                                for(int x=0;x<10;x++){
                                    for(int y=0;y<10;y++){
                                        if(chessboard[x][y].equals(pawn)){
                                            pawnplace = chessboard[0][y].substring(0,1) + chessboard[x][0].substring(0,1);
                                        }
                                    }
                                }
                                places2 = move.WayToKing(pawn, "WK1", chessboard);
                                check=true;
                                for(String place2: places2){
                                    for(String pawn2: pawns){
                                        char value3 = pawn2.charAt(0);
                                        char value4 = pawn2.charAt(1);
                                        if(value3=='W'){
                                            if(value4=='R'){ change = move.Rook(pawn2, place2, momentboard);}
                                            if(value4=='K' && place2.equals(pawnplace)){ change = move.King(pawn2, place2, momentboard);}
                                            if(value4=='Q'){ change = move.Queen(pawn2, place2, momentboard);}
                                            if(value4=='B'){ change = move.Bishop(pawn2, place2, momentboard);}
                                            if(value4=='N'){ change = move.Knight(pawn2, place2, momentboard);}
                                            if(value4!='R' && value4!='K' && value4!='Q' && value4!='B' && value4!='N'){ change = move.Pawn(pawn2, place2, momentboard, true);}
                                            if(change==true){chess=false;}
                                        }
                                    }
                                }
                            }
                        }
                        if(check==true){System.out.println("CHECK");}
                        momentboard[a][b] = "WK1";
                        momentboard[i][j] = firstpawn;
                        if(i==a && j==b){ 
                            if(chess==false){
                                return false;
                            }
                        }
                        if(chess==false){ possible.add(false);}
                        else{ possible.add(true);}
                    }
                }
            }
            if(possible.contains(true) && !possible.contains(false)){ return true; }
            else{ return false; }
        }
        else if(turn==0){
            List<Integer> possiblea = new ArrayList<Integer>();
            List<Integer> possibleb = new ArrayList<Integer>();
            List<Boolean> possible = new ArrayList<Boolean>();
            List <String> places2 = new ArrayList<String>();
            String[][] momentboard = new String[10][10];
            momentboard = chessboard.clone();
            a=c;
            b=d;
            Boolean change=false;
            Boolean chess=false;
            if(a==1 && b!=1 && b!=8){
                possiblea.add(a);
                possiblea.add(a+1);
                possibleb.add(b);
                possibleb.add(b-1);
                possibleb.add(b+1);

            }
            else if(a==8 && b!=1 && b!=8){
                possiblea.add(a);
                possiblea.add(a-1);
                possibleb.add(b);
                possibleb.add(b-1);
                possibleb.add(b+1);
            }
            else if(b==8 && a!=1 && a!=8){
                possiblea.add(a);
                possiblea.add(a-1);
                possiblea.add(a+1);
                possibleb.add(b);
                possibleb.add(b-1);
            }
            else if(b==1 && a!=1 && a!=8){
                possiblea.add(a);
                possiblea.add(a-1);
                possiblea.add(a+1);
                possibleb.add(b);
                possibleb.add(b+1);
            }
            else if(b==1 && a==1){
                possiblea.add(a);
                possiblea.add(a+1);
                possibleb.add(b);
                possibleb.add(b+1);
            }
            else if(b==8 && a==1){
                possiblea.add(a);
                possiblea.add(a+1);
                possibleb.add(b);
                possibleb.add(b-1);
            }
            else if(a==8 && b==8){
                possiblea.add(a);
                possiblea.add(a-1);
                possibleb.add(b);
                possibleb.add(b-1);
            }
            else if(a==8 && b==1){
                possiblea.add(a);
                possiblea.add(a-1);
                possibleb.add(b);
                possibleb.add(b+1);
            }
            else{
                possiblea.add(a);
                possiblea.add(a+1);
                possiblea.add(a-1);
                possibleb.add(b);
                possibleb.add(b+1);
                possibleb.add(b-1);
            }

            for(int i : possiblea){
                for(int j: possibleb){
                    chess = false;
                    Boolean ifpossible=false;
                    Boolean check=false;
                    place = chessboard[0][j].substring(0,1) + chessboard[i][0].substring(0,1);
                    ifpossible = chessboard[i][j].equals("-  ");
                    String firstpawn = chessboard[i][j];
                    if(chessboard[i][j].charAt(0)=='W') { ifpossible = true; }
                    if(i==a && j==b){ ifpossible=true; }
                    if(ifpossible==true){
                        momentboard[a][b] = "-  ";
                        momentboard[i][j] = "BK1";
                        for(String pawn: pawns){
                            char value = pawn.charAt(0);
                            char value2 = pawn.charAt(1);
                            change = false;
                            if(value=='W'){
                                if(value2=='R'){ change = move.Rook(pawn, place, momentboard );}
                                if(value2=='K'){ change = move.King(pawn, place, momentboard );}
                                if(value2=='Q'){ change = move.Queen(pawn, place, momentboard );}
                                if(value2=='B'){ change = move.Bishop(pawn, place, momentboard );}
                                if(value2=='N'){ change = move.Knight(pawn, place, momentboard );}
                                if(value2!='R' && value2!='K' && value2!='Q' && value2!='B' && value2!='N'){ change = move.Pawn(pawn, place, momentboard, true);}
                                if(change==true){chess=true;}
                            }
                            if(change==true && a==i && b==j){
                                String pawnplace=" ";
                                for(int x=0;x<10;x++){
                                    for(int y=0;y<10;y++){
                                        if(chessboard[x][y].equals(pawn)){
                                            pawnplace = chessboard[0][y].substring(0,1) + chessboard[x][0].substring(0,1);
                                        }
                                    }
                                }
                                places2 = move.WayToKing(pawn, "BK1", chessboard);
                                check=true;
                                for(String place2: places2){
                                    for(String pawn2: pawns){
                                        char value3 = pawn2.charAt(0);
                                        char value4 = pawn2.charAt(1);
                                        if(value3=='B'){
                                            if(value4=='R'){ change = move.Rook(pawn2, place2, momentboard);}
                                            if(value4=='K' && place2.equals(pawnplace)){ change = move.King(pawn2, place2, momentboard);}
                                            if(value4=='Q'){ change = move.Queen(pawn2, place2, momentboard);}
                                            if(value4=='B'){ change = move.Bishop(pawn2, place2, momentboard);}
                                            if(value4=='N'){ change = move.Knight(pawn2, place2, momentboard);}
                                            if(value4!='R' && value4!='K' && value4!='Q' && value4!='B' && value4!='N'){ change = move.Pawn(pawn2, place2, momentboard, true);}
                                            if(change==true){chess=false;}
                                        }
                                    }
                                }
                            }
                        }
                        if(check==true){System.out.println("CHECK");}
                        momentboard[a][b] = "BK1";
                        momentboard[i][j] = firstpawn;
                        if(i==a && j==b){ 
                            if(chess==false){
                                return false;
                            }
                        }
                        if(chess==false){ possible.add(false);}
                        else{ possible.add(true);}
                    }
                }
            }
            if(possible.contains(true) && !possible.contains(false)){ return true; }
            else{ return false; }
        }
        else{return false;}
    }
}
