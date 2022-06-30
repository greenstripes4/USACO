import java.io.*;
import java.util.*;

public class Main {
    private static int n;
    private static int k;
    private static int[] r;
    private static char[] c;
    private static ArrayList<ArrayList<int[]>> adjacencyList;
    private static int[][] dp;
    private static void dfs(int u) {
        for(int i = 0; i <= r[u]; i++) {
            dp[u][i] = 0;
        }
        for(int[] edge: adjacencyList.get(u)) {
            if(dp[edge[0]][0] == -1) {
                dfs(edge[0]);
            }
            for(int i = r[u]+1; i <= k; i++) {
                int temp = dp[edge[0]][i-r[u]];
                if(temp != -1 && (dp[u][i] == -1 || temp+edge[1] < dp[u][i])) {
                    dp[u][i] = temp+edge[1];
                }
            }
        }
    }
    public static void main(String[] args) throws IOException {
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        //PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("milkvisits.out")));
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        StringTokenizer st = new StringTokenizer(f.readLine());
        n = Integer.parseInt(st.nextToken());
        int s = Integer.parseInt(st.nextToken())-1;
        k = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(f.readLine());
        r = new int[n+1];
        for(int i = 0; i < n; i++) {
            r[i] = Integer.parseInt(st.nextToken());
        }
        c = new char[n+1];
        System.arraycopy(f.readLine().toCharArray(), 0, c, 0, n);
        adjacencyList = new ArrayList<>(n+1);
        for(int i = 0; i < n; i++) {
            adjacencyList.add(new ArrayList<>());
            for(int j = 0; j < n; j++) {
                if(r[j] > r[i] && c[i] != c[j]) {
                    adjacencyList.get(i).add(new int[]{j, Math.abs(i-j)});
                }
            }
        }
        adjacencyList.add(new ArrayList<>());
        for(int i = 0; i < n; i++) {
            adjacencyList.get(n).add(new int[]{i, Math.abs(s-i)});
        }
        dp = new int[n+1][k+1];
        for(int[] i: dp) {
            Arrays.fill(i, -1);
        }
        dfs(n);
        out.println(dp[n][k]);
        f.close();
        out.close();
    }
}