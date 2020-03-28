/*
ID: strongh2
LANG: JAVA
PROG: ariprog
TASK: ariprog
 */

import java.io.*;
import java.text.DecimalFormat;
import java.util.*;

public class Main{
    //static BufferedReader f;
    //PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("loan.out")));
    static BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
    static PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
    static char[][] board = new char[8][8];
    static char player;
    static boolean validMoveAvailable;
    public static boolean listAllPossibleMoves(char p, boolean print){
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < 8; i++){
            for(int j = 0; j < 8; j++){
                if(isValid(i,j,false)){
                    if(print){
                        sb.append("(");
                        sb.append(i+1);
                        sb.append(",");
                        sb.append(j+1);
                        sb.append(") ");
                    } else {
                        return true;
                    }
                }
            }
        }
        if(print){
            out.println(sb.length() == 0 ? "No legal move." : sb.subSequence(0,sb.length()-1));
        }
        return false;
    }
    public static boolean isValid(int r, int c, boolean change){
        if(board[r][c] != '-'){
            return false;
        }
        if(change) {
            board[r][c] = player;
        }
        int[][] dir = {{1,1},{1,0},{1,-1},{0,1},{0,-1},{-1,1},{-1,0},{-1,-1}};
        for(int[] i: dir){
            ArrayList<int[]> changes = new ArrayList<>();
            int tempR = r;
            int tempC = c;
            boolean foundColor = false;
            boolean foundOtherColor = false;
            while(true){
                tempR += i[0];
                tempC += i[1];
                if(tempR < 0 || tempR >= 8 || tempC < 0 || tempC >= 8){
                    break;
                }
                if(board[tempR][tempC] == player){
                    foundColor = true;
                    break;
                } else if(board[tempR][tempC] == (player == 'W' ? 'B':'W')){
                    foundOtherColor = true;
                    if(change){
                        changes.add(new int[]{tempR,tempC});
                    }
                } else {
                    break;
                }
            }
            if(foundColor && foundOtherColor){
                if(!change) {
                    return true;
                }
                for(int[] j: changes){
                    board[j[0]][j[1]] = player;
                }
            }
        }
        return false;
    }
    public static void main(String[] args) throws IOException {
        //f = new BufferedReader(new FileReader("uva.in"));
        int T = Integer.parseInt(f.readLine());
        for(int i = 0; i < T; i++){
            for(int j = 0; j < 8; j++){
                board[j] = f.readLine().toCharArray();
            }
            player = f.readLine().charAt(0);
            String command;
            while(!(command = f.readLine()).equals("Q")){
                if(command.equals("L")){
                    listAllPossibleMoves(player,true);
                } else {
                    validMoveAvailable = listAllPossibleMoves(player,false);
                    if(!validMoveAvailable){
                        player = player == 'W' ? 'B':'W';
                    }
                    isValid(Character.getNumericValue(command.charAt(1))-1,Character.getNumericValue(command.charAt(2))-1,true);
                    player = player == 'W' ? 'B':'W';
                    int white = 0;
                    int black = 0;
                    for(int j = 0; j < 8; j++){
                        for(int k = 0; k < 8; k++){
                            if(board[j][k] == 'W'){
                                white++;
                            } else if(board[j][k] == 'B') {
                                black++;
                            }
                        }
                    }
                    out.print("Black - ");
                    out.printf("%2d",black);
                    out.print(" White - ");
                    out.printf("%2d\n",white);
                }
            }
            for(int j = 0; j < 8; j++){
                for(int k = 0; k < 8; k++){
                    out.print(board[j][k]);
                }
                out.println();
            }
            if(i < T-1){
                out.println();
            }
        }
        out.close();
        f.close();
    }
}
