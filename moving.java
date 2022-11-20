import java.util.ArrayList;
import java.util.List;
public class moving extends game {
    public boolean King(String pawn, String place, String[][] chessboard){
        int a=0,b=0,c=0,d=0;
        for(int i=0;i<10;i++){
            for(int j=0;j<10;j++){
                if(pawn.length()==3){
                    if(chessboard[i][j].equals(pawn)){
                        a=i;
                        b=j;
                        break;
                    }
                }
                else{
                    if(chessboard[i][j].substring(0, 2).equals(pawn)){
                        a=i;
                        b=j;
                        break;
                    }
                }
                
            }
        }
        for(int i=1;i<9;i++){
            for(int j=1;j<9;j++){
                if(place.charAt(1)=='8'-i+1){
                    if(place.charAt(0)=='A'+j-1){
                        c=i;
                        d=j;
                        break;
                    }
                }
            }
        }
        if(a==c && b==d){ return false; }
        if(Math.abs(a-c)==1 && Math.abs(b-d)==0){
            if(chessboard[c][d]=="-  "){ return true; }  
            if(chessboard[c][d]!="-  "){
                char value = pawn.charAt(0);
                char value2 = chessboard[c][d].charAt(0);
                if(value!=value2 ){ 
                    return true; }
                else{ return false; }
            }              
        }
        if(Math.abs(a-c)==0 && Math.abs(b-d)==1){
            if(chessboard[c][d]=="-  "){ return true; }  
            if(chessboard[c][d]!="-  "){
                char value = pawn.charAt(0);
                char value2 = chessboard[c][d].charAt(0);
                if(value!=value2 ){ 
                    return true; }
                else{ return false; }
            }              
        }
        if(Math.abs(a-c)==1 && Math.abs(b-d)==1){
            if(chessboard[c][d]=="-  "){ return true; }  
            if(chessboard[c][d]!="-  "){
                char value = pawn.charAt(0);
                char value2 = chessboard[c][d].charAt(0);
                if(value!=value2 ){ 
                    return true; }
                else{ return false; }
            }              
        }

        return false;
    }
    public boolean Queen(String pawn, String place, String[][] chessboard){
        int a=0,b=0,c=0,d=0;
        for(int i=0;i<10;i++){
            for(int j=0;j<10;j++){
                if(pawn.length()==3){
                    if(chessboard[i][j].equals(pawn)){
                        a=i;
                        b=j;
                        break;
                    }
                }
                else{
                    if(chessboard[i][j].substring(0, 2).equals(pawn)){
                        a=i;
                        b=j;
                        break;
                    }
                }
                
            }
        }
        for(int i=1;i<9;i++){
            for(int j=1;j<9;j++){
                if(place.charAt(1)=='8'-i+1){
                    if(place.charAt(0)=='A'+j-1){
                        c=i;
                        d=j;
                        break;
                    }
                }
            }
        }
        if(a==c && b==d){ return false; }
        if(Math.abs(a-c)==Math.abs(b-d)){
            if(c>a && d>b){
                for(int i=1;i<c-a;i++){
                    if(chessboard[c-i][d-i]!="-  "){ return false; }
                }
            }
            if(c>a && b>d){
                for(int i=1;i<c-a;i++){
                    if(chessboard[c-i][d+i]!="-  "){ return false; }
                }
            }
            if(a>c && d>b){
                for(int i=1;i<a-c;i++){
                    if(chessboard[c+i][d-i]!="-  "){ return false; }
                }
            }
            if(a>c && b>d){
                for(int i=1;i<a-c;i++){
                    if(chessboard[c+i][d+i]!="-  "){ return false; }
                }
            }
            if(chessboard[c][d]=="-  "){ return true; }  
            if(chessboard[c][d]!="-  "){
                char value = pawn.charAt(0);
                char value2 = chessboard[c][d].charAt(0);
                if(value!=value2 ){ 
                    return true; }
                else{ return false; }
            }              
        }
        if(Math.abs(a-c)==0){
            if(b>d){
                for(int i=d+1;i<b;i++){
                    if(chessboard[c][i]!="-  "){ return false; }
                }
            }
            else{
                for(int i=b+1;i<d;i++){
                    if(chessboard[c][i]!="-  "){ return false; }
                }
            }
            if(chessboard[c][d]=="-  "){ return true; }  
            if(chessboard[c][d]!="-  "){
                char value = pawn.charAt(0);
                char value2 = chessboard[c][d].charAt(0);
                if(value!=value2 ){ 
                    return true; }
                else{ return false; }
            }              
        }
        if(Math.abs(b-d)==0){
            if(a>c){
                for(int i=c+1;i<a;i++){
                    if(chessboard[i][d]!="-  "){ return false; }
                }
            }
            else{
                for(int i=a+1;i<c;i++){
                    if(chessboard[i][d]!="-  "){ return false; }
                }
            }
            if(chessboard[c][d]=="-  "){ return true; }  
            if(chessboard[c][d]!="-  "){
                char value = pawn.charAt(0);
                char value2 = chessboard[c][d].charAt(0);
                if(value!=value2 ){ 
                    return true; }
                else{ return false; }
            }              
        }

        return false;
    }
    public boolean Rook(String pawn, String place, String[][] chessboard){
        int a=0,b=0,c=0,d=0;
        for(int i=0;i<10;i++){
            for(int j=0;j<10;j++){
                if(pawn.length()==3){
                    if(chessboard[i][j].equals(pawn)){
                        a=i;
                        b=j;
                        break;
                    }
                }
                else{
                    if(chessboard[i][j].substring(0, 2).equals(pawn)){
                        a=i;
                        b=j;
                        break;
                    }
                }
                
            }
        }
        for(int i=1;i<9;i++){
            for(int j=1;j<9;j++){
                if(place.charAt(1)=='8'-i+1){
                    if(place.charAt(0)=='A'+j-1){
                        c=i;
                        d=j;
                        break;
                    }
                }
            }
        }
        if(a==c && b==d){ return false; }
        if(Math.abs(a-c)==0){
            if(b>d){
                for(int i=d+1;i<b;i++){
                    if(chessboard[c][i]!="-  "){ return false; }
                }
            }
            else{
                for(int i=b+1;i<d;i++){
                    if(chessboard[c][i]!="-  "){ return false; }
                }
            }
            if(chessboard[c][d]=="-  "){ return true; }  
            if(chessboard[c][d]!="-  "){
                char value = pawn.charAt(0);
                char value2 = chessboard[c][d].charAt(0);
                if(value!=value2 ){ 
                    return true; }
                else{ return false; }
            }              
        }
        if(Math.abs(b-d)==0){
            if(a>c){
                for(int i=c+1;i<a;i++){
                    if(chessboard[i][d]!="-  "){ return false; }
                }
            }
            else{
                for(int i=a+1;i<c;i++){
                    if(chessboard[i][d]!="-  "){ return false; }
                }
            }
            if(chessboard[c][d]=="-  "){ return true; }  
            if(chessboard[c][d]!="-  "){
                char value = pawn.charAt(0);
                char value2 = chessboard[c][d].charAt(0);
                if(value!=value2 ){ 
                    return true; }
                else{ return false; }
            }              
        }
        return false;
    }
    public boolean Bishop(String pawn, String place, String[][] chessboard){
        int a=0,b=0,c=0,d=0;
        for(int i=0;i<10;i++){
            for(int j=0;j<10;j++){
                if(pawn.length()==3){
                    if(chessboard[i][j].equals(pawn)){
                        a=i;
                        b=j;
                        break;
                    }
                }
                else{
                    if(chessboard[i][j].substring(0, 2).equals(pawn)){
                        a=i;
                        b=j;
                        break;
                    }
                }
                
            }
        }
        for(int i=1;i<9;i++){
            for(int j=1;j<9;j++){
                if(place.charAt(1)=='8'-i+1){
                    if(place.charAt(0)=='A'+j-1){
                        c=i;
                        d=j;
                        break;
                    }
                }
            }
        }
        if(a==c && b==d){ return false; }
        if(Math.abs(a-c)==Math.abs(b-d)){
            if(c>a && d>b){
                for(int i=1;i<c-a;i++){
                    if(chessboard[c-i][d-i]!="-  "){ return false; }
                }
            }
            if(c>a && b>d){
                for(int i=1;i<c-a;i++){
                    if(chessboard[c-i][d+i]!="-  "){ return false; }
                }
            }
            if(a>c && d>b){
                for(int i=1;i<a-c;i++){
                    if(chessboard[c+i][d-i]!="-  "){ return false; }
                }
            }
            if(a>c && b>d){
                for(int i=1;i<a-c;i++){
                    if(chessboard[c+i][d+i]!="-  "){ return false; }
                }
            }
            if(chessboard[c][d]=="-  "){ return true; }  
            if(chessboard[c][d]!="-  "){
                char value = pawn.charAt(0);
                char value2 = chessboard[c][d].charAt(0);
                if(value!=value2 ){ 
                    return true; }
                else{ return false; }
            }              
        }
        return false;
    }
    public boolean Knight(String pawn, String place, String[][] chessboard){
        int a=0,b=0,c=0,d=0;
        for(int i=0;i<10;i++){
            for(int j=0;j<10;j++){
                if(pawn.length()==3){
                    if(chessboard[i][j].equals(pawn)){
                        a=i;
                        b=j;
                        break;
                    }
                }
                else{
                    if(chessboard[i][j].substring(0, 2).equals(pawn)){
                        a=i;
                        b=j;
                        break;
                    }
                }
                
            }
        }
        for(int i=1;i<9;i++){
            for(int j=1;j<9;j++){
                if(place.charAt(1)=='8'-i+1){
                    if(place.charAt(0)=='A'+j-1){
                        c=i;
                        d=j;
                        break;
                    }
                }
            }
        }
        if(a==c && b==d){ return false; }
        if(Math.abs(a-c)==1 && Math.abs(b-d)==2){
            if(chessboard[c][d]=="-  "){ return true; }  
            if(chessboard[c][d]!="-  "){
                char value = pawn.charAt(0);
                char value2 = chessboard[c][d].charAt(0);
                if(value!=value2 ){ 
                    return true; }
                else{ return false; }
            }              
        }
        if(Math.abs(a-c)==2 && Math.abs(b-d)==1){
            if(chessboard[c][d]=="-  "){ return true; }
            if(chessboard[c][d]!="-  "){
                char value = pawn.charAt(0);
                char value2 = chessboard[c][d].charAt(0);
                if(value!=value2 ){ 
                    return true; }
                else{ return false; }
            } 
        }
        return false;
    }
    public boolean Pawn(String pawn, String place, String[][] chessboard, boolean wasfirst){
        int a=0,b=0,c=0,d=0;
        int equ;
        for(int i=0;i<10;i++){
            for(int j=0;j<10;j++){
                if(pawn.length()==3){
                    if(chessboard[i][j].equals(pawn)){
                        a=i;
                        b=j;
                        break;
                    }
                }
                else{
                    if(chessboard[i][j].substring(0, 2).equals(pawn)){
                        a=i;
                        b=j;
                        break;
                    }
                }
                
            }
        }
        for(int i=1;i<9;i++){
            for(int j=1;j<9;j++){
                if(place.charAt(1)=='8'-i+1){
                    if(place.charAt(0)=='A'+j-1){
                        c=i;
                        d=j;
                        break;
                    }
                }
            }
        }
        
        if(a==c && b==d){ return false; }
        if(wasfirst==false){
            char value = pawn.charAt(0);
            char value2 = chessboard[c][d].charAt(0);
            if(value=='W'){ equ=a-c; }
            else{ equ=c-a; }

            if(equ==2 && b==d && chessboard[c][d]=="-  "){ return true; }
            else if(equ==1 && b==d && chessboard[c][d]=="-  "){ return true; }
            else if(equ==1 && Math.abs(b-d)==1 && value!=value2) { return true; }
            else{ return false; }
        }
        else{
            char value = pawn.charAt(0);
            char value2 = chessboard[c][d].charAt(0);
            if(value=='W'){ equ=a-c; }
            else{ equ=c-a; }
            if(equ==1 && b==d && chessboard[c][d]=="-  "){ return true; }
            else if(equ==1 && Math.abs(b-d)==1 && value!=value2) { return true; }
            else{ return false; }
        }
    }
    public List<String> WayToKing(String pawn, String king, String[][] chessboard){
        List<String> way = new ArrayList<>();
        int a=0,b=0,c=0,d=0;
        for(int i=0;i<10;i++){
            for(int j=0;j<10;j++){
                if(pawn.length()==3){
                    if(chessboard[i][j].equals(pawn)){
                        a=i;
                        b=j;
                        break;
                    }
                }
                else{
                    if(chessboard[i][j].substring(0, 2).equals(pawn)){
                        a=i;
                        b=j;
                        break;
                    }
                }
                
            }
        }
        for(int i=0;i<10;i++){
            for(int j=0;j<10;j++){
                if(chessboard[i][j].equals(king)){
                    c=i;
                    d=j;
                    break;
                }
            }
        }
        String firstposition = chessboard[0][b].substring(0,1) + chessboard[a][0].substring(0,1);
        char value = pawn.charAt(1);
        if(value=='R'){ 
            if(c==a){
                if(d>b){
                    for(int i=b;i<d;i++){
                        way.add(chessboard[0][i].substring(0,1) + chessboard[a][0].substring(0,1));
                    }
                }
                else{
                    for(int i=d;i<b;i++){
                        way.add(chessboard[0][i].substring(0,1) + chessboard[a][0].substring(0,1));
                    }
                }
            }
            else if(b==d){
                if(c>a){
                    for(int i=a;i<c;i++){
                        way.add(chessboard[0][b].substring(0,1) + chessboard[i][0].substring(0,1));
                    }
                }
                else{
                    for(int i=c;i<a;i++){
                        way.add(chessboard[0][b].substring(0,1) + chessboard[i][0].substring(0,1));
                    }
                }
            }
        }
        if(value=='K'){ 
            way.add(firstposition);
        }
        if(value=='Q'){
            if(c==a){
                if(d>b){
                    for(int i=b;i<d;i++){
                        way.add(chessboard[0][i].substring(0,1) + chessboard[a][0].substring(0,1));
                    }
                }
                else{
                    for(int i=d;i<b;i++){
                        way.add(chessboard[0][i].substring(0,1) + chessboard[a][0].substring(0,1));
                    }
                }
            }
            else if(b==d){
                if(c>a){
                    for(int i=a;i<c;i++){
                        way.add(chessboard[0][b].substring(0,1) + chessboard[i][0].substring(0,1));
                    }
                }
                else{
                    for(int i=c;i<a;i++){
                        way.add(chessboard[0][b].substring(0,1) + chessboard[i][0].substring(0,1));
                    }
                }
            }
            else if(c>a && d>b){
                for(int i=a;i<c;i++){
                    for(int j=d;j<b;j++){
                        way.add(chessboard[0][j].substring(0,1) + chessboard[i][0].substring(0,1));
                    }
                }
            }
            else if(c>a && b>d){
                for(int i=a;i<c;i++){
                    for(int j=b;j<d;j++){
                        way.add(chessboard[0][j].substring(0,1) + chessboard[i][0].substring(0,1));
                    }
                }
            }
            else if(a>c && b>d){
                for(int i=c;i<a;i++){
                    for(int j=d;j<b;j++){
                        way.add(chessboard[0][j].substring(0,1) + chessboard[i][0].substring(0,1));
                    }
                }
            }
            else if(a>c && d>b){
                for(int i=c;i<a;i++){
                    for(int j=b;j<d;j++){
                        way.add(chessboard[0][j].substring(0,1) + chessboard[i][0].substring(0,1));
                    }
                }
            }
         }
        if(value=='B'){
            if(c>a && d>b){
                for(int i=a;i<c;i++){
                    for(int j=d;j<b;j++){
                        way.add(chessboard[0][j].substring(0,1) + chessboard[i][0].substring(0,1));
                    }
                }
            }
            else if(c>a && b>d){
                for(int i=a;i<c;i++){
                    for(int j=b;j<d;j++){
                        way.add(chessboard[0][j].substring(0,1) + chessboard[i][0].substring(0,1));
                    }
                }
            }
            else if(a>c && b>d){
                for(int i=c;i<a;i++){
                    for(int j=d;j<b;j++){
                        way.add(chessboard[0][j].substring(0,1) + chessboard[i][0].substring(0,1));
                    }
                }
            }
            else if(a>c && d>b){
                for(int i=c;i<a;i++){
                    for(int j=b;j<d;j++){
                        way.add(chessboard[0][j].substring(0,1) + chessboard[i][0].substring(0,1));
                    }
                }
            }
         }
        if(value=='N'){
            way.add(firstposition);
         }
        if(value!='R' && value!='K' && value!='Q' && value!='B' && value!='N'){
            way.add(firstposition);
         }
        return way;
    }
}
