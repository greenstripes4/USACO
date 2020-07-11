import java.io.*;
import java.util.*;

public class Main{
    private static boolean dfs(char[][] board, int r, int c) {
        if(r < 0 || r >= board.length || c < 0 || c >= board[0].length || board[r][c] == 'b') {
            return false;
        }
        if(c == board[0].length-1) {
            return true;
        }
        board[r][c] = 'b';
        return dfs(board,r-1,c-1) || dfs(board,r-1,c) || dfs(board,r,c-1) || dfs(board,r,c+1) || dfs(board,r+1,c) || dfs(board,r+1,c+1);
    }
    public static void main(String[] args) throws IOException{
        //Scanner f = new Scanner(new File("uva.in"));
        //Scanner f = new Scanner(System.in);
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        int testcase = 1;
        while(true) {
            int N = Integer.parseInt(f.readLine());
            if(N == 0) {
                break;
            }
            char[][] board = new char[N][N];
            for(int i = 0; i < N; i++) {
                board[i] = f.readLine().toCharArray();
            }
            boolean whiteWins = false;
            for(int i = 0; i < N; i++) {
                if(board[i][0] == 'w') {
                    if(dfs(board,i,0)) {
                        whiteWins = true;
                    }
                }
            }
            if(whiteWins) {
                out.println(testcase + " W");
            } else {
                out.println(testcase + " B");
            }
            testcase++;
        }
        f.close();
        out.close();
    }
}
