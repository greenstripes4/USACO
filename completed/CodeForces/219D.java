import java.io.*;
import java.util.*;

public class Main {
    private static ArrayList<ArrayList<Integer>> adjacencyList;
    private static ArrayList<HashSet<Integer>> directed;
    private static int[] dp1;
    private static int[] dp2;
    private static void dfs1(int u, int p) {
        for(int v: adjacencyList.get(u)) {
            if(v != p) {
                if(!directed.get(u).contains(v)) {
                    dp1[u]++;
                }
                dfs1(v, u);
                dp1[u] += dp1[v];
            }
        }
    }
    private static void dfs2(int u, int p) {
        if(u == 0) {
            dp2[u] = dp1[u];
        } else {
            dp2[u] = dp2[p];
            if(directed.get(u).contains(p)) {
                dp2[u]--;
            } else {
                dp2[u]++;
            }
        }
        for(int v: adjacencyList.get(u)) {
            if(v != p) {
                dfs2(v, u);
            }
        }
    }
    public static void main(String[] args) throws IOException {
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        //PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("milkvisits.out")));
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        int n = Integer.parseInt(f.readLine());
        adjacencyList = new ArrayList<>();
        directed = new ArrayList<>();
        for(int i = 0; i < n; i++) {
            adjacencyList.add(new ArrayList<>());
            directed.add(new HashSet<>());
        }
        for(int i = 0; i < n-1; i++) {
            StringTokenizer st = new StringTokenizer(f.readLine());
            int s = Integer.parseInt(st.nextToken())-1;
            int t = Integer.parseInt(st.nextToken())-1;
            adjacencyList.get(s).add(t);
            adjacencyList.get(t).add(s);
            directed.get(s).add(t);
        }
        dp1 = new int[n];
        dfs1(0, -1);
        dp2 = new int[n];
        dfs2(0, -1);
        int min = Integer.MAX_VALUE;
        for(int i: dp2) {
            min = Math.min(min, i);
        }
        out.println(min);
        for(int i = 0; i < n; i++) {
            if(dp2[i] == min) {
                out.print((i+1) + " ");
            }
        }
        f.close();
        out.close();
    }
}