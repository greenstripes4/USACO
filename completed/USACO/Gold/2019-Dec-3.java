import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader f = new BufferedReader(new FileReader("cowmbat.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("cowmbat.out")));
        //BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        //PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        StringTokenizer st = new StringTokenizer(f.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int[] S = new int[N];
        char[] temp = f.readLine().toCharArray();
        for(int i = 0; i < N; i++) {
            S[i] = temp[i]-'a';
        }
        int[][] adjacencyMatrix = new int[M][M];
        for(int i = 0; i < M; i++) {
            st = new StringTokenizer(f.readLine());
            for(int j = 0; j < M; j++) {
                adjacencyMatrix[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        for(int k = 0; k < M; k++) {
            for(int i = 0; i < M; i++) {
                for(int j = 0; j < M; j++) {
                    if(adjacencyMatrix[i][k]+adjacencyMatrix[k][j] < adjacencyMatrix[i][j]) {
                        adjacencyMatrix[i][j] = adjacencyMatrix[i][k]+adjacencyMatrix[k][j];
                    }
                }
            }
        }
        int[][] cost = new int[N-K+1][M];
        for(int i = 0; i < M; i++) {
            int sum = 0;
            for(int j = 0; j < K; j++) {
                sum += adjacencyMatrix[S[j]][i];
            }
            cost[0][i] = sum;
            for(int j = 1; j <= N-K; j++) {
                sum -= adjacencyMatrix[S[j-1]][i];
                sum += adjacencyMatrix[S[j+K-1]][i];
                cost[j][i] = sum;
            }
        }
        int[][] dp = new int[N][M+1];
        for(int i = 0; i < K-1; i++) {
            Arrays.fill(dp[i], Integer.MAX_VALUE/2);
        }
        dp[K-1][M] = Integer.MAX_VALUE/2;
        for(int i = 0; i < M; i++) {
            dp[K-1][i] = cost[0][i];
            dp[K-1][M] = Math.min(dp[K-1][M], dp[K-1][i]);
        }
        for(int i = K; i < N; i++) {
            dp[i][M] = Integer.MAX_VALUE/2;
            for(int j = 0; j < M; j++) {
                dp[i][j] = Math.min(dp[i-1][j]+adjacencyMatrix[S[i]][j], dp[i-K][M]+cost[i-K+1][j]);
                dp[i][M] = Math.min(dp[i][M], dp[i][j]);
            }
        }
        out.println(dp[N-1][M]);
        f.close();
        out.close();
    }
}