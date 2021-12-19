import java.io.*;
import java.lang.reflect.Array;
import java.util.*;

public class Main {
    private static ArrayList<ArrayList<Integer>> adjacencyList;
    private static int[] dist;
    private static boolean dfs(int u, int p, int t) {
        if(dist[u] <= t) {
            return false;
        }
        if(u > 0 && adjacencyList.get(u).size() == 1) {
            return true;
        }
        for(int v: adjacencyList.get(u)) {
            if(v != p) {
                if(dfs(v, u, t+1)) {
                    return true;
                }
            }
        }
        return false;
    }
    public static void main(String[] args) throws IOException{
        //BufferedReader f = new BufferedReader(new FileReader("cowjump.in"));
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
            Queue<Integer> queue = new LinkedList<>();
            dist = new int[n];
            Arrays.fill(dist, -1);
            for(int i = 0; i < k; i++) {
                int x = Integer.parseInt(st.nextToken())-1;
                queue.offer(x);
                dist[x] = 0;
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
            int steps = 1;
            while(!queue.isEmpty()) {
                int size = queue.size();
                while(size-- > 0) {
                    int cur = queue.poll();
                    for(int next: adjacencyList.get(cur)) {
                        if(dist[next] < 0) {
                            queue.offer(next);
                            dist[next] = steps;
                        }
                    }
                }
                steps++;
            }
            out.println(dfs(0, -1, 0) ? "YES" : "NO");
        }
        f.close();
        out.close();
    }
}
