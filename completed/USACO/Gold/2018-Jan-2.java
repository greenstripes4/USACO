import java.io.*;
import java.util.*;

public class Main {
    private static ArrayList<ArrayList<Integer>> adjacencyList;
    private static int[] distance;
    private static int ans;
    private static void dfs(int u, int p, int d) {
        if(distance[u] <= d) {
            ans++;
            return;
        }
        for(int v: adjacencyList.get(u)) {
            if(v != p) {
                dfs(v, u, d+1);
            }
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader f = new BufferedReader(new FileReader("atlarge.in"));
        //BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("atlarge.out")));
        StringTokenizer st = new StringTokenizer(f.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken())-1;
        adjacencyList = new ArrayList<>();
        for(int i = 0; i < N; i++) {
            adjacencyList.add(new ArrayList<>());
        }
        for(int i = 0; i < N-1; i++) {
            st = new StringTokenizer(f.readLine());
            int u = Integer.parseInt(st.nextToken())-1;
            int v = Integer.parseInt(st.nextToken())-1;
            adjacencyList.get(u).add(v);
            adjacencyList.get(v).add(u);
        }
        Queue<Integer> queue = new LinkedList<>();
        distance = new int[N];
        Arrays.fill(distance, -1);
        for(int i = 0; i < N; i++) {
            if(adjacencyList.get(i).size() == 1) {
                queue.offer(i);
                distance[i] = 0;
            }
        }
        while(!queue.isEmpty()) {
            int u = queue.poll();
            for(int v: adjacencyList.get(u)) {
                if(distance[v] == -1) {
                    queue.offer(v);
                    distance[v] = distance[u]+1;
                }
            }
        }
        ans = 0;
        dfs(K, -1, 0);
        out.println(ans);
        f.close();
        out.close();
    }
}
