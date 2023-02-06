import java.io.*;
import java.util.*;

public class Main {
    private static ArrayList<ArrayList<int[]>> adjacencyList;
    private static boolean[] visited;
    private static int[] size;
    private static int[] max;
    private static int total;
    private static int centroid;
    private static ArrayList<Integer> depth;
    private static void findCentroid(int u, int p) {
        size[u] = 1;
        max[u] = 0;
        for(int[] v: adjacencyList.get(u)) {
            if(v[0] != p && !visited[v[0]]) {
                findCentroid(v[0], u);
                size[u] += size[v[0]];
                max[u] = Math.max(max[u], size[v[0]]);
            }
        }
        max[u] = Math.max(max[u], total-size[u]);
        if(max[u] < max[centroid]) {
            centroid = u;
        }
    }
    private static void getDepth(int u, int p, int d) {
        depth.add(d);
        for(int[] v: adjacencyList.get(u)) {
            if(v[0] != p && !visited[v[0]]) {
                getDepth(v[0], u, d+v[1]);
            }
        }
    }
    private static long count(int u, int k) {
        depth = new ArrayList<Integer>();
        getDepth(u, 0, 0);
        Collections.sort(depth);
        int left = 0;
        int right = depth.size()-1;
        long ans = 0;
        while(left < right) {
            int s = depth.get(left)+depth.get(right);
            if(s == k) {
                ans++;
                left++;
                right--;
            } else if(s < k) {
                left++;
            } else {
                right--;
            }
        }
        return ans;
    }
    private static long dfs(int u, int k) {
        visited[u] = true;
        long ans = count(u, k);
        for(int[] v: adjacencyList.get(u)) {
            if(!visited[v[0]]) {
                ans -= count(v[0], k-v[1]);
                total = size[v[0]];
                centroid = 0;
                findCentroid(v[0], 0);
                ans += dfs(centroid, k);
            }
        }
        return ans;
    }
    public static void main(String[] args) throws IOException {
        //BufferedReader f = new BufferedReader(new FileReader("deleg.in"));
        //PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("deleg.out")));
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        while(true) {
            int N = Integer.parseInt(f.readLine());
            if(N == 0) {
                break;
            }
            adjacencyList = new ArrayList<ArrayList<int[]>>(N+1);
            for(int i = 0; i <= N; i++) {
                adjacencyList.add(new ArrayList<int[]>());
            }
            for(int i = 1; i <= N; i++) {
                StringTokenizer st = new StringTokenizer(f.readLine());
                int edges = st.countTokens()/2;
                for(int j = 0; j < edges; j++) {
                    int v = Integer.parseInt(st.nextToken());
                    int w = Integer.parseInt(st.nextToken());
                    adjacencyList.get(i).add(new int[]{v, w});
                    adjacencyList.get(v).add(new int[]{i, w});
                }
            }
            while(true) {
                int x = Integer.parseInt(f.readLine());
                if(x == 0) {
                    break;
                }
                visited = new boolean[N+1];
                size = new int[N+1];
                max = new int[N+1];
                Arrays.fill(max, Integer.MAX_VALUE);
                total = N;
                centroid = 0;
                out.println(dfs(1, x) > 0 ? "AYE" : "NAY");
            }
            out.println(".");
        }
        f.close();
        out.close();
    }
}