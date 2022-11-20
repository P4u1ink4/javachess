import java . util . Scanner ;
import java.util.HashMap;
import java.util.Map;
import java.util.List;
import java.util.ArrayList;
public class game implements chess{
    private String[][] chessboard = new String[10][10];
    private boolean if_end = false;
    private int iswhitemove = 1;
    private Map<String,Boolean> firstmove = new HashMap<String,Boolean>();
    private int nextpawn = 9;
    public List<String> pawns = new ArrayList<String>();

    public int getNextPawn(){ return nextpawn; }
    public void setPawns(List<String> pawns){ this.pawns = pawns;}
    public List<String> getPawns() { return pawns;}

    public void setMove(int iswhitemove) { if (iswhitemove==0){ this.iswhitemove=1;} else{this.iswhitemove=0;}}       
    public int getMove(){ return iswhitemove; }

    public void setEnd(boolean if_end) { this.if_end = if_end;}
    public boolean getEnd(){ return if_end; }

    public void setBoard(String[][] board){ this.chessboard = board; }
    public String[][] getBoard(){ return chessboard; }

    public void setFirstMove(Map<String,Boolean> firstmove){ this.firstmove = firstmove;}
    public Map<String,Boolean> getFirstMove(){ return firstmove;}

    public void start(){
        String[][] firstboard = new String[10][10];
        board board = new board();
        board.boardmake(firstboard);
        this.setBoard(firstboard);
        Map<String,Boolean> firstmovenow = new HashMap<String,Boolean>();
        firstmovenow = this.getFirstMove();
        firstmovenow.put("B1",false);
        firstmovenow.put("B2",false);
        firstmovenow.put("B3",false);
        firstmovenow.put("B4",false);
        firstmovenow.put("B5",false);
        firstmovenow.put("B6",false);
        firstmovenow.put("B7",false);
        firstmovenow.put("B8",false);
        firstmovenow.put("W1",false);
        firstmovenow.put("W2",false);
        firstmovenow.put("W3",false);
        firstmovenow.put("W4",false);
        firstmovenow.put("W5",false);
        firstmovenow.put("W6",false);
        firstmovenow.put("W7",false);
        firstmovenow.put("W8",false);
        this.setFirstMove(firstmovenow);

        pawns.add("B1");
        pawns.add("B2");
        pawns.add("B3");
        pawns.add("B4");
        pawns.add("B5");
        pawns.add("B6");
        pawns.add("B7");
        pawns.add("B8");
        pawns.add("W1");
        pawns.add("W2");
        pawns.add("W3");
        pawns.add("W4");
        pawns.add("W5");
        pawns.add("W6");
        pawns.add("W7");
        pawns.add("W8");
        pawns.add("WR1");
        pawns.add("WN1");
        pawns.add("WB1");
        pawns.add("WK1");
        pawns.add("WQ1");
        pawns.add("WB2");
        pawns.add("WN2");
        pawns.add("WR2");
        pawns.add("BR1");
        pawns.add("BN1");
        pawns.add("BB1");
        pawns.add("BK1");
        pawns.add("BQ1");
        pawns.add("BB2");
        pawns.add("BN2");
        pawns.add("BR2");
    }

    public void end(){
        endgame end = new endgame();
        this.setEnd(end.isend(this.getBoard(), this.iswhitemove, this.getPawns()));
    }

    public void move(String pawn, String place){
        moving turn = new moving();
        char value = pawn.charAt(0);
        char value2 = pawn.charAt(1);
        boolean change=false;
        String[][] changeboard = new String[10][10];
        changeboard = this.getBoard();
        if(this.getMove()==1 && value=='W' && this.possible(pawn, place)==true){
            if(value2=='R'){ change = turn.Rook(pawn, place, changeboard);}
            if(value2=='K'){change = turn.King(pawn, place, changeboard);}
            if(value2=='Q'){ change = turn.Queen(pawn, place, changeboard);}
            if(value2=='B'){ change = turn.Bishop(pawn, place, changeboard);}
            if(value2=='N'){ change = turn.Knight(pawn, place, changeboard);}
            if(value=='W' && value2!='R' && value2!='K' && value2!='Q' && value2!='B' && value2!='N'){ change = turn.Pawn(pawn, place, changeboard, this.firstmove(pawn));}
            if(change==true){
                if(value=='W' && value2!='R' && value2!='K' && value2!='Q' && value2!='B' && value2!='N'){ 
                    Map<String,Boolean> firstmovenow = new HashMap<String,Boolean>();
                    firstmovenow = this.getFirstMove();
                    if(firstmovenow.get(pawn)==false){
                        firstmovenow.remove(pawn);
                        firstmovenow.put(pawn,true);
                        this.setFirstMove(firstmovenow);
                    }
                }
                this.change(pawn,place,changeboard);
                this.setMove(this.getMove());
            }
            else{
                System.out.println("This move is impossible.");
                this.gettingdata();
            }
        }
        else if(this.getMove()==0 && value=='B' && this.possible(pawn, place)==true){
            if(value2=='R'){ change = turn.Rook(pawn, place, changeboard);}
            if(value2=='K'){change = turn.King(pawn, place, changeboard);}
            if(value2=='Q'){ change = turn.Queen(pawn, place, changeboard);}
            if(value2=='B'){ change = turn.Bishop(pawn, place, changeboard);}
            if(value2=='N'){ change = turn.Knight(pawn, place, changeboard);}
            if(value=='B' && value2!='R' && value2!='K' && value2!='Q' && value2!='B' && value2!='N'){ change = turn.Pawn(pawn, place, changeboard, this.firstmove(pawn));}
            if(change==true){
                if(value=='B' && value2!='R' && value2!='K' && value2!='Q' && value2!='B' && value2!='N'){ 
                    Map<String,Boolean> firstmovenow = new HashMap<String,Boolean>();
                    firstmovenow = this.getFirstMove();
                    if(firstmovenow.get(pawn)==false){
                        firstmovenow.remove(pawn);
                        firstmovenow.put(pawn,true);
                        this.setFirstMove(firstmovenow);
                    }
                }
                this.change(pawn,place,changeboard);
                this.setMove(this.getMove());
            }
            else{
                System.out.println("This move is impossible.");
                this.gettingdata();
            }
        }
        else if(this.possible(pawn, place)==true){
            System.out.println("Wrong gamer.");
            this.gettingdata();
        }
        else{
            System.out.println("Wrong input.");
        }
        }

    public boolean firstmove(String pawn){
        Map<String,Boolean> firstmovenow = new HashMap<String,Boolean>();
        firstmovenow = this.getFirstMove();
        return firstmovenow.get(pawn);
    }

    public void change(String pawn, String place, String[][] changeboard){
        char value = pawn.charAt(0);
        char value2 = pawn.charAt(1);
        char value3 = place.charAt(1);
        Scanner s2 = new Scanner(System.in);
        List<String> pawnsnext = new ArrayList<String>();
        pawnsnext=this.getPawns();
        if(this.getEnd() == true ){ s2.close(); }
        String in;
        String firstpawn = pawn;
        if(value=='B' && value2!='R' && value2!='K' && value2!='Q' && value2!='B' && value2!='N'){
            if(value3=='1'){
                System.out.println("If you want to change you pawn, write rook, knight, bishop, queen or pawn, despite for what you want to change it.");
                while(true){
                    in = s2.nextLine();
                    if(in.equals("rook")){
                        pawnsnext.remove(pawn);
                        pawn = "BR" + Integer.toString(this.getNextPawn());
                        pawns.add(pawn);
                        break;
                    }
                    if(in.equals("knight")){
                        pawnsnext.remove(pawn);
                        pawn = "BN" + Integer.toString(this.getNextPawn());
                        pawns.add(pawn);
                        break;
                    }
                    if(in.equals("bishop")){
                        pawnsnext.remove(pawn);
                        pawn = "BB" + Integer.toString(this.getNextPawn());
                        pawns.add(pawn);
                        break;
                    }
                    if(in.equals("queen")){
                        pawnsnext.remove(pawn);
                        pawn = "BQ" + Integer.toString(this.getNextPawn());
                        pawns.add(pawn);
                        break;
                    }
                    if(in.equals("pawn")){
                        pawnsnext.remove(pawn);
                        pawn = "B" + Integer.toString(this.getNextPawn());
                        pawns.add(pawn);
                        break;
                    }
                    else{
                        System.out.println("Input correct name.");
                    }
                }
            }
        }
        if(value=='W' && value2!='R' && value2!='K' && value2!='Q' && value2!='B' && value2!='N'){
            if(value3=='8'){
                System.out.println("If you want to change your pawn, write rook, knight, bishop, queen or pawn, despite for what you want to change it.");
                while(true){
                    in = s2.nextLine();
                    if(in.equals("rook")){
                        pawnsnext.remove(pawn);
                        pawn = "WR" + Integer.toString(this.getNextPawn());
                        pawns.add(pawn);
                        break;
                    }
                    if(in.equals("knight")){
                        pawnsnext.remove(pawn);
                        pawn = "WN" + Integer.toString(this.getNextPawn());
                        pawns.add(pawn);
                        break;
                    }
                    if(in.equals("bishop")){
                        pawnsnext.remove(pawn);
                        pawn = "WB" + Integer.toString(this.getNextPawn());
                        pawns.add(pawn);
                        break;
                    }
                    if(in.equals("queen")){
                        pawnsnext.remove(pawn);
                        pawn = "WQ" + Integer.toString(this.getNextPawn());
                        pawns.add(pawn);
                        break;
                    }
                    if(in.equals("pawn")){
                        pawnsnext.remove(pawn);
                        pawn = "W" + Integer.toString(this.getNextPawn());
                        pawns.add(pawn);
                        break;
                    }
                    else{
                        System.out.println("Input correct name.");
                    }
                }
                
            }
        }
        for(int i=0;i<10;i++){
            for(int j=0;j<10;j++){
                if(firstpawn.length()==3){
                    if(changeboard[i][j].equals(firstpawn)){
                        changeboard[i][j]="-  ";
                    }
                }
                else{
                    if(changeboard[i][j].substring(0, 2).equals(firstpawn)){
                        changeboard[i][j]="-  ";
                    }
                }
                
            }
        }
        for(int i=1;i<9;i++){
            for(int j=1;j<9;j++){
                if(place.charAt(1)=='8'-i+1){
                    if(place.charAt(0)=='A'+j-1){
                        if(!changeboard[i][j].equals("-  ")){
                            String todelete = changeboard[i][j];
                            if(changeboard[i][j].charAt(1)=='K'){ 
                                this.setEnd(true);
                                this.setMove(this.getMove());
                                System.out.println("CHECKMATE, WINS: " + this.winner());
                                System.exit(0);
                            }
                            if(changeboard[i][j].substring(2).equals(" ")){
                                todelete = changeboard[i][j].substring(0, 2);
                            }
                            pawnsnext.remove(todelete);
                        }
                        if(pawn.length()==2){
                            changeboard[i][j]=pawn + " ";
                        }
                        else{
                            changeboard[i][j]=pawn;
                        }
                        break;
                    }
                }
            }
        }
        this.setPawns(pawnsnext);
        this.setBoard(changeboard);
    }

    public Boolean possible(String pawn, String place){
        Boolean goodpawn=false;
        Boolean goodplace=false;
        if(pawns.contains(pawn)){
            goodpawn = true;
        }
        if(place.equals("A1") || place.equals("A2") || place.equals("A3") || place.equals("A4") || place.equals("A5") || place.equals("A6") || place.equals("A7") || place.equals("A8") || place.equals("B1") || place.equals("B2") || place.equals("B3") || place.equals("B4") || place.equals("B5") || place.equals("B6") || place.equals("B7") || place.equals("B8") || place.equals("C1") || place.equals("C2") || place.equals("C3") || place.equals("C4") || place.equals("C5") || place.equals("C6") || place.equals("C7") || place.equals("C8") || place.equals("D1") || place.equals("D2") || place.equals("D3") || place.equals("D4") || place.equals("D5") || place.equals("D6") || place.equals("D7") || place.equals("D8") || place.equals("E1") || place.equals("E2") || place.equals("E3") || place.equals("E4") || place.equals("E5") || place.equals("E6") || place.equals("E7") || place.equals("E8") || place.equals("F1") || place.equals("F2") || place.equals("F3") || place.equals("F4") || place.equals("F5") || place.equals("F6") || place.equals("F7") || place.equals("F8") || place.equals("G1") || place.equals("G2") || place.equals("G3") || place.equals("G4") || place.equals("G5") || place.equals("G6") || place.equals("G7") || place.equals("G8") || place.equals("H1") || place.equals("H2") || place.equals("H3") || place.equals("H4") || place.equals("H5") || place.equals("H6") || place.equals("H7") || place.equals("H8")){
            goodplace = true;
        }
        if(goodpawn==true && goodplace==true){ return true; }
        else{ return false; }
    }

    public String winner(){
        if(this.getMove()==1){ return "BLACK";}
        else { return "WHITE";}
    }

    public void gettingdata(){
        Scanner s = new Scanner(System.in);
        String in;
        if(this.getEnd()==true){s.close();}
        else{
            while(true){
                in = s.nextLine();
                    if(in.contains(" ")){
                        String[] move = in.split(" ");
                        if(move.length==2){
                            if(this.possible(move[0], move[1])==true){ 
                                this.move(move[0],move[1]);
                                break;
                            }
                            else{ 
                                System.out.println("Wrong input.");
                            }
                        }
                        else{
                            System.out.println("Wrong input.");
                        }
                    }
                    else{
                        System.out.println("Wrong input.");
                    }
            }
        }
        if(this.getEnd()==true){s.close();}
        }
   
    public static void main(String[] args) {
        game GAME = new game();
        GAME.start();
        String[][] momentboard = new String[10][10];
        while (true) {
            momentboard = GAME.getBoard();
            if(GAME.getEnd() == false){
                for(int i=0;i<10;i++){
                    for(int j=0;j<10;j++){
                        System.out.printf(momentboard[i][j]+" ");
                    }
                    System.out.println();
                }
                if (GAME.getMove()==1){
                    System.out.println("WHITE MOVE, input pawn and place fe. NW A6");
                }
                else{
                    System.out.println("BLACK MOVE, input pawn and place fe. NW A6");
                }
                GAME.gettingdata();
            }
            else{
                System.out.println("CHECKMATE, WINS: " + GAME.winner());
                System.exit(0);
            }  
            GAME.end();
        }
    }
}
