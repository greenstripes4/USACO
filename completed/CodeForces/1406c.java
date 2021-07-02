import java.io.*;
import java.util.*;

public class Main {
    private static ArrayList<Integer>[] adjacencyList;
    private static int[] size;
    private static int[] maxSubtreeSize;
    private static int[] dp;
    private static void dfs(int u, int p) {
        size[u] = 1;
        maxSubtreeSize[u] = 0;
        for(int i: adjacencyList[u]) {
            if(i != p) {
                dfs(i, u);
                size[u] += size[i];
                maxSubtreeSize[u] = Math.max(maxSubtreeSize[u], size[i]);
            }
        }
        dp[u] = Math.max(maxSubtreeSize[u], adjacencyList.length-size[u]-1);
    }
    private static int findLeaf(int u, int p) {
        for(int i: adjacencyList[u]) {
            if(i != p) {
                return findLeaf(i, u);
            }
        }
        return u;
    }
    public static void main(String[] args) throws IOException {
        //Scanner f = new Scanner(new File("uva.in"));
        //Scanner f = new Scanner(System.in);
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        int t = Integer.parseInt(f.readLine());
        while(t-- > 0) {
            int n = Integer.parseInt(f.readLine());
            adjacencyList = new ArrayList[n+1];
            for(int i = 1; i <= n; i++) {
                adjacencyList[i] = new ArrayList<>();
            }
            for(int i = 0; i < n-1; i++) {
                StringTokenizer st = new StringTokenizer(f.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                adjacencyList[x].add(y);
                adjacencyList[y].add(x);
            }
            size = new int[n+1];
            maxSubtreeSize = new int[n+1];
            dp = new int[n+1];
            dfs(1, 0);
            int c1 = 0;
            int c2 = 0;
            int min = Integer.MAX_VALUE;
            for(int i = 1; i <= n; i++) {
                if(dp[i] < min) {
                    c1 = i;
                    c2 = 0;
                    min = dp[i];
                } else if(dp[i] == min) {
                    c2 = i;
                }
            }
            if(c2 == 0) {
                int v = adjacencyList[1].get(0);
                out.println("1 " + v);
                out.println("1 " + v);
            } else {
                int leaf = findLeaf(c2, c1);
                int v = adjacencyList[leaf].get(0);
                out.println(leaf + " " + v);
                out.println(leaf + " " + c1);
            }
        }
        f.close();
        out.close();
    }
}