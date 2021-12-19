import java.io.*;
import java.lang.reflect.Array;
import java.util.*;

public class Main {
    private static ArrayList<ArrayList<Integer>> adjacencyList;
    private static int[] distance;
    private static boolean[] visited;
    private static void dfs(int u, int p, int d) {
        distance[u] = d;
        for(int v: adjacencyList.get(u)) {
            if(v != p) {
                dfs(v, u, d+1);
            }
        }
    }
    private static void dfs2(int u, int d) {
        if(distance[u] < d) {
            return;
        }
        visited[u] = true;
        for(int v: adjacencyList.get(u)) {
            if(!visited[v]) {
                dfs2(v, d+1);
            }
        }
    }
    public static void main(String[] args) throws IOException{
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        //PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("cowjump.out")));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        int t = Integer.parseInt(f.readLine());
        while(t-- > 0) {
            f.readLine();
            StringTokenizer st = new StringTokenizer(f.readLine());
            int n = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());
            st = new StringTokenizer(f.readLine());
            Integer[] x = new Integer[k];
            for(int i = 0; i < k; i++) {
                x[i] = Integer.parseInt(st.nextToken())-1;
            }
            adjacencyList = new ArrayList<>(n);
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
            distance = new int[n];
            dfs(0, -1, 0);
            Arrays.sort(x, new Comparator<Integer>() {
                @Override
                public int compare(Integer integer, Integer t1) {
                    return distance[integer]-distance[t1];
                }
            });
            visited = new boolean[n];
            int ans = 0;
            for(int i: x) {
                if(!visited[i]) {
                    ans++;
                    dfs2(i, 0);
                }
            }
            for(int i = 1; i < n; i++) {
                if(!visited[i] && adjacencyList.get(i).size() == 1) {
                    ans = -1;
                    break;
                }
            }
            out.println(ans);
        }
        f.close();
        out.close();
    }
}
