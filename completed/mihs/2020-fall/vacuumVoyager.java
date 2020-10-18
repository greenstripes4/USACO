import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner f = new Scanner(System.in);
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        int N = f.nextInt();
        int C = f.nextInt();
        int[][] E = new int[N][N];
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < N; j++) {
                E[i][j] = f.nextInt();
            }
        }
        E[0][0] = C;
        int[][] dp = new int[N+1][N+1];
        for(int i = 1; i <= N; i++) {
            for(int j = 1; j <= N; j++) {
                dp[i][j] = Math.max(dp[i-1][j],dp[i][j-1])+E[i-1][j-1];
            }
        }
        out.println(dp[N][N]);
        f.close();
        out.close();
    }
}
