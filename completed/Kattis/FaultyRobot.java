import java.io.*;
import java.util.*;

public class Main {
    private static int[] locked;
    private static ArrayList<ArrayList<Integer>> open;
    private static boolean[] visited;
    private static int[] end;
    private static boolean[] res;
    private static void dfs(int u) {
        visited[u] = true;
        if(locked[u] < 0) {
            end[u] = u;
            return;
        }
        if(visited[locked[u]]) {
            if(end[locked[u]] == -2) {
                end[u] = -1;
                return;
            }
            end[u] = end[locked[u]];
            return;
        }
        dfs(locked[u]);
        end[u] = end[locked[u]];
    }
    private static void dfs2(int u) {
        if(visited[u]) {
            return;
        }
        visited[u] = true;
        for(int v: open.get(u)) {
            if(end[v] >= 0) {
                res[end[v]] = true;
            }
        }
        if(locked[u] < 0) {
            res[u] = true;
            return;
        }
        dfs2(locked[u]);
    }
    public static void main(String[] args) throws IOException{
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        StringTokenizer st = new StringTokenizer(f.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        locked = new int[n];
        open = new ArrayList<>(n);
        for(int i = 0; i < n; i++) {
            locked[i] = -1;
            open.add(new ArrayList<>());
        }
        for(int i = 0; i < m; i++) {
            st = new StringTokenizer(f.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            if(u < 0) {
                locked[-u-1] = v-1;
            } else {
                open.get(u-1).add(v-1);
            }
        }
        visited = new boolean[n];
        end = new int[n];
        Arrays.fill(end, -2);
        for(int i = 0; i < n; i++) {
            if(!visited[i]) {
                dfs(i);
            }
        }
        visited = new boolean[n];
        res = new boolean[n];
        dfs2(0);
        int ans = 0;
        for(boolean i: res) {
            if(i) {
                ans++;
            }
        }
        out.println(ans);
        f.close();
        out.close();
    }
}