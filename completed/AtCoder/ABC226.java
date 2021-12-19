import java.io.*;
import java.util.*;

public class Main {
    private static ArrayList<ArrayList<Integer>> adjacencyList;
    private static int vertexes;
    private static int edges;
    private static boolean[] visited;
    private static void dfs(int u) {
        vertexes++;
        visited[u] = true;
        for(int v: adjacencyList.get(u)) {
            if(!visited[v]) {
                edges++;
            }
        }
        for(int v: adjacencyList.get(u)) {
            if(!visited[v]) {
                dfs(v);
            }
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        //BufferedReader f = new BufferedReader(new FileReader("moop.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        //PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("moop.out")));
        StringTokenizer st = new StringTokenizer(f.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        adjacencyList = new ArrayList<>(N);
        for(int i = 0; i < N; i++) {
            adjacencyList.add(new ArrayList<>());
        }
        for(int i = 0; i < M; i++) {
            st = new StringTokenizer(f.readLine());
            int u = Integer.parseInt(st.nextToken())-1;
            int v = Integer.parseInt(st.nextToken())-1;
            adjacencyList.get(u).add(v);
            adjacencyList.get(v).add(u);
        }
        visited = new boolean[N];
        long ans = 1;
        for(int i = 0; i < N; i++) {
            if(!visited[i]) {
                vertexes = 0;
                edges = 0;
                dfs(i);
                if(vertexes == edges) {
                    ans = (ans*2)%998244353;
                } else {
                    ans = 0;
                    break;
                }
            }
        }
        out.println(ans);
        f.close();
        out.close();
    }
}