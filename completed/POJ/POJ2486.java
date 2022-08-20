import java.io.*;
import java.util.*;

public class Main {
    private static int K;
    private static int[] arr;
    private static ArrayList<ArrayList<Integer>> adjacencyList;
    private static int[][][] dp;
    private static void dfs(int u, int p) {
        for(int i = 0; i <= K; i++) {
            dp[u][i][0] = dp[u][i][1] = arr[u];
        }
        for(int v: adjacencyList.get(u)) {
            if(v != p) {
                dfs(v, u);
                for(int i = K; i > 0; i--) {
                    for(int j = 1; j <= i; j++) {
                        dp[u][i][0] = Math.max(dp[u][i][0], dp[u][i-j][1]+dp[v][j-1][0]);
                        if(j > 1) {
                            dp[u][i][0] = Math.max(dp[u][i][0], dp[u][i-j][0]+dp[v][j-2][1]);
                            dp[u][i][1] = Math.max(dp[u][i][1], dp[u][i-j][1]+dp[v][j-2][1]);
                        }
                    }
                }
            }
        }
    }
    public static void main(String[] args) throws IOException {
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        //PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("threesum.out")));
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        String input;
        while((input = f.readLine()) != null) {
            StringTokenizer st = new StringTokenizer(input);
            int N = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());
            st = new StringTokenizer(f.readLine());
            arr = new int[N];
            for(int i = 0; i < N; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }
            adjacencyList = new ArrayList<ArrayList<Integer>>(N);
            for(int i = 0; i < N; i++) {
                adjacencyList.add(new ArrayList<Integer>());
            }
            for(int i = 0; i < N-1; i++) {
                st = new StringTokenizer(f.readLine());
                int A = Integer.parseInt(st.nextToken())-1;
                int B = Integer.parseInt(st.nextToken())-1;
                adjacencyList.get(A).add(B);
                adjacencyList.get(B).add(A);
            }
            dp = new int[N][K+1][2];
            dfs(0, -1);
            out.println(Math.max(dp[0][K][0], dp[0][K][1]));
        }
        f.close();
        out.close();
    }
}