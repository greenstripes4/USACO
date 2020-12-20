import java.io.*;
import java.util.*;

public class Main{
    private static int maxRooks;
    private static boolean validBoard(char[][] board) {
        for(char[] i: board) {
            boolean hasRook = false;
            boolean hasWall = false;
            for(char j: i) {
                if(j == 'R') {
                    if(hasRook && !hasWall) {
                        return false;
                    }
                    hasRook = true;
                    hasWall = false;
                } else if(j == 'X') {
                    hasWall = true;
                }
            }
        }
        for(int i = 0; i < board.length; i++) {
            boolean hasRook = false;
            boolean hasWall = false;
            for(int j = 0; j < board.length; j++) {
                if(board[j][i] == 'R') {
                    if(hasRook && !hasWall) {
                        return false;
                    }
                    hasRook = true;
                    hasWall = false;
                } else if(board[j][i] == 'X') {
                    hasWall = true;
                }
            }
        }
        return true;
    }
    private static void solve(char[][] board, int rooks) {
        maxRooks = Math.max(maxRooks, rooks);
        for(int i = 0; i < board.length; i++) {
            for(int j = 0; j < board.length; j++) {
                if(board[i][j] == '.') {
                    board[i][j] = 'R';
                    if(validBoard(board)) {
                        solve(board, rooks+1);
                    }
                    board[i][j] = '.';
                }
            }
        }
    }
    public static void main(String[] args) throws IOException{
        //Scanner f = new Scanner(new File("uva.in"));
        //Scanner f = new Scanner(System.in);
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        String input;
        while(!(input = f.readLine()).equals("0")) {
            int n = Integer.parseInt(input);
            char[][] board = new char[n][];
            for(int i = 0; i < n; i++) {
                board[i] = f.readLine().toCharArray();
            }
            maxRooks = 0;
            solve(board, 0);
            out.println(maxRooks);
        }
        f.close();
        out.close();
    }
}
