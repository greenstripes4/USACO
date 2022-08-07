import java.io.*;
import java.util.*;

public class Main {
    private static int T;
    private static ArrayList<ArrayList<Integer>> adjacencyList;
    private static int[] dp;
    private static void dfs(int u) {
        if(adjacencyList.get(u).size() == 0) {
            dp[u] = 1;
            return;
        }
        for(int v: adjacencyList.get(u)) {
            dfs(v);
        }
        Collections.sort(adjacencyList.get(u), new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return dp[o1]-dp[o2];
            }
        });
        int x = (adjacencyList.get(u).size()*T+99)/100;
        for(int i = 0; i < x; i++) {
            dp[u] += dp[adjacencyList.get(u).get(i)];
        }
    }
    public static void main(String[] args) throws IOException {
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        //PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("milkvisits.out")));
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        while(true) {
            StringTokenizer st = new StringTokenizer(f.readLine());
            int N = Integer.parseInt(st.nextToken());
            T = Integer.parseInt(st.nextToken());
            if(N == 0 && T == 0) {
                break;
            }
            adjacencyList = new ArrayList<>(N+1);
            for(int i = 0; i <= N; i++) {
                adjacencyList.add(new ArrayList<>());
            }
            st = new StringTokenizer(f.readLine());
            for(int i = 1; i <= N; i++) {
                int p = Integer.parseInt(st.nextToken());
                adjacencyList.get(p).add(i);
            }
            dp = new int[N+1];
            dfs(0);
            out.println(dp[0]);
        }
        f.close();
        out.close();
    }
}