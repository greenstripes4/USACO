import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        StringTokenizer st = new StringTokenizer(f.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int T = Integer.parseInt(st.nextToken());
        ArrayList<ArrayList<int[]>> adjacencyList = new ArrayList<>();
        ArrayList<ArrayList<int[]>> edges = new ArrayList<>();
        for(int i = 0; i < n; i++) {
            adjacencyList.add(new ArrayList<>());
            edges.add(new ArrayList<>());
        }
        int[] indegree = new int[n];
        for(int i = 0; i < m; i++) {
            st = new StringTokenizer(f.readLine());
            int u = Integer.parseInt(st.nextToken())-1;
            int v = Integer.parseInt(st.nextToken())-1;
            int t = Integer.parseInt(st.nextToken());
            adjacencyList.get(v).add(new int[]{u, t});
            edges.get(u).add(new int[]{v, t});
            indegree[u]++;
        }
        Queue<Integer> queue = new LinkedList<>();
        for(int i = 0; i < n; i++) {
            if(indegree[i] == 0) {
                queue.offer(i);
            }
        }
        ArrayList<Integer> order = new ArrayList<>();
        while(!queue.isEmpty()) {
            int cur = queue.poll();
            order.add(cur);
            for(int[] v: adjacencyList.get(cur)) {
                if(--indegree[v[0]] == 0) {
                    queue.offer(v[0]);
                }
            }
        }
        int[][] dp = new int[n][n+1];
        int[][] backtrack = new int[n][n+1];
        for(int i = 0; i < n; i++) {
            Arrays.fill(dp[i], 1000000007);
        }
        dp[n-1][1] = 0;
        for(int i: order) {
            for(int j = 1; j <= n; j++) {
                for(int[] k: edges.get(i)) {
                    if(dp[k[0]][j-1]+k[1] < dp[i][j]) {
                        dp[i][j] = dp[k[0]][j-1]+k[1];
                        backtrack[i][j] = k[0]+1;
                    }
                }
                if(dp[i][j] > T) {
                    dp[i][j] = 1000000007;
                }
            }
        }
        int max = 0;
        for(int i = n; i >= 0; i--) {
            if(dp[0][i] <= T) {
                max = i;
                break;
            }
        }
        out.println(max);
        int[] res = new int[max];
        res[0] = 1;
        for(int i = 1; i < max-1; i++) {
            res[i] = backtrack[res[i-1]-1][max-i+1];
        }
        res[max-1] = n;
        out.print(res[0]);
        for(int i = 1; i < max; i++) {
            out.print(" " + res[i]);
        }
        out.println();
        f.close();
        out.close();
    }
}