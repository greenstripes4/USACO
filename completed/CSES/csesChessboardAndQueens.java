import java.io.*;
import java.util.*;

public class Main {
    private static char[][] board;
    private static int[] cols;
    private static int count;
    private static boolean isValid(int r) {
        if(board[r][cols[r]] == '*') {
            return false;
        }
        for(int i = 0; i < r; i++) {
            if(cols[r] == cols[i] || Math.abs(cols[r]-cols[i]) == r-i) {
                return false;
            }
        }
        return true;
    }
    private static void solve(int r) {
        if(r == 8) {
            count++;
            return;
        }
        for(int i = 0; i < 8; i++) {
            cols[r] = i;
            if(isValid(r)) {
                solve(r+1);
            }
        }
    }
    public static void main(String[] args) throws IOException{
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        board = new char[8][];
        for(int i = 0; i < 8; i++) {
            board[i] = f.readLine().toCharArray();
        }
        cols = new int[8];
        count = 0;
        solve(0);
        out.println(count);
        f.close();
        out.close();
    }
}