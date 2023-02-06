import java.io.*;
import java.util.*;

public class Main {
    private static ArrayList<Integer>[] adjacencyList;
    private static ArrayList<Integer> cycle;
    private static boolean[] visited;
    private static int[] parent;
    private static boolean dfs(int root) {
        if(visited[root]) {
            cycle.add(root);
            int temp = parent[root];
            while(root != temp) {
                cycle.add(temp);
                temp = parent[temp];
            }
            cycle.add(root);
            return true;
        }
        visited[root] = true;
        for(int i: adjacencyList[root]) {
            if(i != parent[root]) {
                parent[i] = root;
                if(dfs(i)) {
                    return true;
                }
            }
        }
        return false;
    }
    public static void main(String[] args) throws IOException{
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        StringTokenizer st = new StringTokenizer(f.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        adjacencyList = new ArrayList[n+1];
        for(int i = 1; i <= n; i++) {
            adjacencyList[i] = new ArrayList<>();
        }
        for(int i = 0; i < m; i++) {
            st = new StringTokenizer(f.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            adjacencyList[a].add(b);
            adjacencyList[b].add(a);
        }
        cycle = new ArrayList<>();
        visited = new boolean[n+1];
        parent = new int[n+1];
        for(int i = 1; i <= n; i++) {
            if(parent[i] == 0) {
                if(dfs(i)) {
                    out.println(cycle.size());
                    out.print(cycle.get(0));
                    for(int j = 1; j < cycle.size(); j++) {
                        out.print(" " + cycle.get(j));
                    }
                    out.println();
                    break;
                }
            }
        }
        if(cycle.size() == 0) {
            out.println("IMPOSSIBLE");
        }
        f.close();
        out.close();
    }
}