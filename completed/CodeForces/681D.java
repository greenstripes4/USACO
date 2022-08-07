import java.io.*;
import java.util.*;

public class Main {
    private static int n;
    private static ArrayList<ArrayList<Integer>> adjacencyList;
    private static int[] depth;
    private static void dfs1(int u) {
        for(int v: adjacencyList.get(u)) {
            depth[v] = depth[u]+1;
            dfs1(v);
        }
    }
    private static int[] a;
    private static boolean[] visited;
    private static int b;
    private static boolean dfs2(int u) {
        if(a[u] != b) {
            return false;
        }
        visited[u] = true;
        for(int v: adjacencyList.get(u)) {
            if(!visited[v] && !dfs2(v)) {
                return false;
            }
        }
        return true;
    }
    public static void main(String[] args) throws IOException {
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        //PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("milkvisits.out")));
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        StringTokenizer st = new StringTokenizer(f.readLine());
        n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        adjacencyList = new ArrayList<>(n+1);
        for(int i = 0; i <= n; i++) {
            adjacencyList.add(new ArrayList<>());
        }
        boolean[] flag = new boolean[n+1];
        for(int i = 0; i < m; i++) {
            st = new StringTokenizer(f.readLine());
            int p = Integer.parseInt(st.nextToken());
            int q = Integer.parseInt(st.nextToken());
            adjacencyList.get(p).add(q);
            flag[q] = true;
        }
        depth = new int[n+1];
        for(int i = 1; i <= n; i++) {
            if(!flag[i]) {
                dfs1(i);
            }
        }
        TreeSet<Integer> res = new TreeSet<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                if(depth[o1] == depth[o2]) {
                    return o1-o2;
                }
                return depth[o2]-depth[o1];
            }
        });
        st = new StringTokenizer(f.readLine());
        a = new int[n+1];
        for(int i = 1; i <= n; i++) {
            a[i] = Integer.parseInt(st.nextToken());
            res.add(a[i]);
        }
        visited = new boolean[n+1];
        boolean valid = true;
        for(int i: res) {
            b = i;
            if(!dfs2(i)) {
                valid = false;
                out.println(-1);
                break;
            }
        }
        if(valid) {
            out.println(res.size());
            for(int i: res) {
                out.println(i);
            }
        }
        f.close();
        out.close();
    }
}