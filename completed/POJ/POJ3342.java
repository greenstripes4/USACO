import java.io.*;
import java.util.*;

public class Main {
    private static ArrayList<ArrayList<Integer>> adjacencyList;
    private static int[][] dp;
    private static boolean[][] duplicate;
    private static void dfs(int u, int p) {
        dp[u][1] = 1;
        for(int v: adjacencyList.get(u)) {
            if(v != p) {
                dfs(v, u);
                dp[u][0] += Math.max(dp[v][0], dp[v][1]);
                if(!(dp[v][0] > dp[v][1] && !duplicate[v][0] || dp[v][1] > dp[v][0] && !duplicate[v][1])) {
                    duplicate[u][0] = true;
                }
                dp[u][1] += dp[v][0];
                if(duplicate[v][0]) {
                    duplicate[u][1] = true;
                }
            }
        }
    }
    public static void main(String[] args) throws IOException {
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        //PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("threesum.out")));
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        while(true) {
            int n = Integer.parseInt(f.readLine());
            if(n == 0) {
                break;
            }
            String root = f.readLine();
            String[][] edges = new String[n-1][2];
            HashSet<String> set = new HashSet<String>();
            set.add(root);
            for(int i = 0; i < n-1; i++) {
                StringTokenizer st = new StringTokenizer(f.readLine());
                edges[i][0] = st.nextToken();
                edges[i][1] = st.nextToken();
                set.add(edges[i][0]);
                set.add(edges[i][1]);
            }
            HashMap<String, Integer> map = new HashMap<String, Integer>();
            int idx = 0;
            for(String i: set) {
                map.put(i, idx++);
            }
            adjacencyList = new ArrayList<ArrayList<Integer>>(n);
            for(int i = 0; i < n; i++) {
                adjacencyList.add(new ArrayList<Integer>());
            }
            for(String[] i: edges) {
                int u = map.get(i[0]);
                int v = map.get(i[1]);
                adjacencyList.get(u).add(v);
                adjacencyList.get(v).add(u);
            }
            dp = new int[n][2];
            duplicate = new boolean[n][2];
            dfs(map.get(root), -1);
            if(dp[map.get(root)][0] > dp[map.get(root)][1]) {
                out.println(dp[map.get(root)][0] + " " + (duplicate[map.get(root)][0] ? "No" : "Yes"));
            } else if(dp[map.get(root)][1] > dp[map.get(root)][0]) {
                out.println(dp[map.get(root)][1] + " " + (duplicate[map.get(root)][1] ? "No" : "Yes"));
            } else {
                out.println(dp[map.get(root)][0] + " No");
            }
        }
        f.close();
        out.close();
    }
}