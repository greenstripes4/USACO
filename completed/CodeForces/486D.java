import java.io.*;
import java.util.*;

public class Main {
    private static int[] a;
    private static int d;
    private static ArrayList<ArrayList<Integer>> adjacencyList;
    private static long[] dp;
    private static int r;
    private static void dfs(int u, int p) {
        dp[u] = 1;
        for(int v: adjacencyList.get(u)) {
            if(v != p && a[v] >= a[r] && a[v] <= a[r]+d) {
                if(a[v] == a[r] && v > r) {
                    continue;
                }
                dfs(v, u);
                dp[u] = (dp[u]*(dp[v]+1))%1000000007;
            }
        }
    }
    public static void main(String[] args) throws IOException {
        //BufferedReader f = new BufferedReader(new FileReader("milkvisits.in"));
        //PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("milkvisits.out")));
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        StringTokenizer st = new StringTokenizer(f.readLine());
        d = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(f.readLine());
        a = new int[n];
        for(int i = 0; i < n; i++) {
            a[i] = Integer.parseInt(st.nextToken());
        }
        adjacencyList = new ArrayList<>();
        for(int i = 0; i < n; i++) {
            adjacencyList.add(new ArrayList<>());
        }
        for(int i = 0; i < n-1; i++) {
            st = new StringTokenizer(f.readLine());
            int u = Integer.parseInt(st.nextToken())-1;
            int v = Integer.parseInt(st.nextToken())-1;
            adjacencyList.get(u).add(v);
            adjacencyList.get(v).add(u);
        }
        long ans = 0;
        for(int i = 0; i < n; i++) {
            dp = new long[n];
            r = i;
            dfs(i, -1);
            ans = (ans+dp[i])%1000000007;
        }
        out.println(ans);
        f.close();
        out.close();
    }
}