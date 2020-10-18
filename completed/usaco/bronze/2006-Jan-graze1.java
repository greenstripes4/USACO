import java.io.*;
import java.util.*;

public class Main{
    private static int[][] dp;
    private static int f(int c, int p, int[] start, int D) {
        if(dp[c][p] == -2) {
            if(c == 0) {
                if(p != 0) {
                    dp[c][p] = -1;
                } else {
                    dp[c][p] = Math.abs(start[c]);
                }
            } else {
                int first = p-D < 0 ? -1 : dp[c-1][p-D] == -2 ? f(c-1, p-D, start, D) : dp[c-1][p-D];
                int second = p-D-1 < 0 ? -1 : dp[c-1][p-D-1] == -2 ? f(c-1, p-D-1, start, D) : dp[c-1][p-D-1];
                if (first < 0 && second < 0) {
                    dp[c][p] = -1;
                } else if (first < 0) {
                    dp[c][p] = Math.abs(start[c]-p)+second;
                } else if (second < 0) {
                    dp[c][p] = Math.abs(start[c]-p)+first;
                } else {
                    dp[c][p] = Math.abs(start[c]-p)+Math.min(first, second);
                }
            }
        }
        return dp[c][p];
    }
    public static void main(String[] args) throws IOException{
        //Scanner f = new Scanner(new File("uva.in"));
        //Scanner f = new Scanner(System.in);
        BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        //BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        StringTokenizer st = new StringTokenizer(f.readLine());
        int N = Integer.parseInt(st.nextToken());
        int L = Integer.parseInt(st.nextToken());
        int[] start = new int[N];
        for(int i = 0; i < N; i++) {
            start[i] = Integer.parseInt(f.readLine());
        }
        dp = new int[N][L+1];
        for(int i = 0; i < N; i++) {
            Arrays.fill(dp[i], -2);
        }
        out.println(f(N-1, L, start, L/(N-1)));
        f.close();
        out.close();
    }
}
