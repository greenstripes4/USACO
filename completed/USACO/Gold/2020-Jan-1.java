import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader f = new BufferedReader(new FileReader("time.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("time.out")));
        //BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        //PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        StringTokenizer st = new StringTokenizer(f.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(f.readLine());
        int[] m = new int[N];
        for(int i = 0; i < N; i++) {
            m[i] = Integer.parseInt(st.nextToken());
        }
        ArrayList<ArrayList<Integer>> adjacencyList = new ArrayList<>();
        for(int i = 0; i < N; i++) {
            adjacencyList.add(new ArrayList<>());
        }
        for(int i = 0; i < M; i++) {
            st = new StringTokenizer(f.readLine());
            int a = Integer.parseInt(st.nextToken())-1;
            int b = Integer.parseInt(st.nextToken())-1;
            adjacencyList.get(b).add(a);
        }
        int[][] dp = new int[1001][N];
        for(int[] i: dp) {
            Arrays.fill(i, -1);
        }
        dp[0][0] = 0;
        for(int i = 1; i <= 1000; i++) {
            for(int j = 0; j < N; j++) {
                for(int k: adjacencyList.get(j)) {
                    if(dp[i-1][k] >= 0) {
                        dp[i][j] = Math.max(dp[i][j], dp[i-1][k]+m[j]);
                    }
                }
            }
        }
        int ans = 0;
        for(int i = 1; i <= 1000; i++) {
            ans = Math.max(ans, dp[i][0]-C*i*i);
        }
        out.println(ans);
        f.close();
        out.close();
    }
}