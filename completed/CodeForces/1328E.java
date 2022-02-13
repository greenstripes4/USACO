import java.io.*;
import java.util.*;

public class Main {
    private static ArrayList<ArrayList<Integer>> adjacencyList;
    private static int[] timeIn;
    private static int[] timeOut;
    private static int[] parent;
    private static int[] depth;
    private static int time;
    private static void dfs(int u) {
        timeIn[u] = time++;
        for(int v: adjacencyList.get(u)) {
            if(v != parent[u]) {
                parent[v] = u;
                depth[v] = depth[u]+1;
                dfs(v);
            }
        }
        timeOut[u] = time++;
    }
    public static void main(String[] args) throws IOException {
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        //PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("cowjump.out")));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        StringTokenizer st = new StringTokenizer(f.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
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
        timeIn = new int[n];
        timeOut = new int[n];
        parent = new int[n];
        depth = new int[n];
        time = 0;
        dfs(0);
        for(int i = 0; i < m; i++) {
            st = new StringTokenizer(f.readLine());
            int k = Integer.parseInt(st.nextToken());
            ArrayList<Integer> path = new ArrayList<>(k);
            for(int j = 0; j < k; j++) {
                path.add(parent[Integer.parseInt(st.nextToken())-1]);
            }
            Collections.sort(path, new Comparator<Integer>() {
                @Override
                public int compare(Integer integer, Integer t1) {
                    return depth[t1]-depth[integer];
                }
            });
            boolean flag = false;
            for(int j = 1; j < k; j++) {
                int u = path.get(j-1);
                int a = path.get(j);
                if(timeIn[a] > timeIn[u] || timeOut[a] < timeOut[u]) {
                    flag = true;
                    break;
                }
            }
            out.println(flag ? "NO" : "YES");
        }
        f.close();
        out.close();
    }
}
