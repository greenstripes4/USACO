import java.io.*;
import java.util.*;

public class Main {
    private static final int MOD = 1000000007;
    private static int multiply(long a, long b) {
        return (int) (((a%MOD)*(b%MOD))%MOD);
    }
    private static int K;
    private static ArrayList<ArrayList<Integer>> adjacencyList;
    private static int dfs(int u, int p, int x) {
        int ans = 1;
        for(int v: adjacencyList.get(u)) {
            if(v != p) {
                ans = multiply(ans, multiply(x, dfs(v, u, K-2)));
                x--;
            }
        }
        return ans;
    }
    public static void main(String[] args) throws IOException {
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        //PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("milkvisits.out")));
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        StringTokenizer st = new StringTokenizer(f.readLine());
        int N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        adjacencyList = new ArrayList<>(N);
        for(int i = 0; i < N; i++) {
            adjacencyList.add(new ArrayList<>());
        }
        for(int i = 0; i < N-1; i++) {
            st = new StringTokenizer(f.readLine());
            int a = Integer.parseInt(st.nextToken())-1;
            int b = Integer.parseInt(st.nextToken())-1;
            adjacencyList.get(a).add(b);
            adjacencyList.get(b).add(a);
        }
        out.println(multiply(K, dfs(0, -1, K-1)));
        f.close();
        out.close();
    }
}
