import java.io.*;
import java.util.*;

public class Main {
    private static int[][] M;
    private static boolean[] usedCols;
    private static int minSum;
    private static void solve(int row, int curSum) {
        if(row == M.length) {
            minSum = Math.min(minSum,curSum);
            return;
        }
        for(int i = 0; i < M.length; i++) {
            if(!usedCols[i]) {
                usedCols[i] = true;
                solve(row+1,curSum+M[row][i]);
                usedCols[i] = false;
            }
        }
    }
    public static void main(String[] args) throws IOException {
        //Scanner f = new Scanner(new File("uva.in"));
        //Scanner f = new Scanner(System.in);
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        int testcases = Integer.parseInt(f.readLine());
        for(int t = 0; t < testcases; t++) {
            int n = Integer.parseInt(f.readLine());
            M = new int[n][n];
            usedCols = new boolean[n];
            minSum = Integer.MAX_VALUE;
            for(int i = 0; i < n; i++) {
                StringTokenizer st = new StringTokenizer(f.readLine());
                for(int j = 0; j < n; j++) {
                    M[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            solve(0,0);
            out.println(minSum);
        }
        f.close();
        out.close();
    }
}
