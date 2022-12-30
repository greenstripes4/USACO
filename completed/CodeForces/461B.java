import java.io.*;
import java.util.*;

public class Main {
    private static ArrayList<ArrayList<Integer>> adjacencyList;
    private static int[] x;
    private static int[][] dp;
    private static final int MOD = 1000000007;
    private static int add(long a, long b) { return (int) (((a+MOD)%MOD+(b+MOD)%MOD)%MOD); }
    private static int subtract(long a, long b) {
        return add(a, -b);
    }
    private static int multiply(long a, long b) {
        return (int) (((a%MOD)*(b%MOD))%MOD);
    }
    private static int divide(long a, long b) {
        return multiply(a, modularInverse(b));
    }
    private static int modularInverse(long a) {
        return power(a, MOD-2);
    }
    private static int power(long a, long b) {
        long c = 1;
        while(b > 0) {
            if((b&1) > 0) {
                c = multiply(c, a);
            }
            a = multiply(a, a);
            b >>= 1;
        }
        return (int) c;
    }
    private static void dfs(int u, int p) {
        dp[u][0] = x[u] == 0 ? 1 : 0;
        int cnt = 1;
        for(int v: adjacencyList.get(u)) {
            if(v != p) {
                dfs(v, u);
                dp[u][0] = multiply(dp[u][0], add(dp[v][0], dp[v][1]));
                cnt = multiply(cnt, add(dp[v][0], dp[v][1]));
            }
        }
        if(x[u] == 1) {
            dp[u][1] = 1;
            for(int v: adjacencyList.get(u)) {
                if(v != p) {
                    dp[u][1] = multiply(dp[u][1], add(dp[v][0], dp[v][1]));
                }
            }
        } else {
            for(int v: adjacencyList.get(u)) {
                if(v != p) {
                    if(dp[v][1] > 0) {
                        dp[u][1] = add(dp[u][1], multiply(dp[v][1], divide(cnt, add(dp[v][0], dp[v][1]))));
                    }
                }
            }
        }
    }
    public static void main(String[] args) throws IOException {
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        //PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("milkvisits.out")));
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        int n = Integer.parseInt(f.readLine());
        adjacencyList = new ArrayList<>(n);
        for(int i = 0; i < n; i++) {
            adjacencyList.add(new ArrayList<>());
        }
        StringTokenizer st = new StringTokenizer(f.readLine());
        for(int i = 1; i < n; i++) {
            int j = Integer.parseInt(st.nextToken());
            adjacencyList.get(i).add(j);
            adjacencyList.get(j).add(i);
        }
        st = new StringTokenizer(f.readLine());
        x = new int[n];
        for(int i = 0; i < n; i++) {
            x[i] = Integer.parseInt(st.nextToken());
        }
        dp = new int[n][2];
        dfs(0, -1);
        out.println(dp[0][1]);
        f.close();
        out.close();
    }
}