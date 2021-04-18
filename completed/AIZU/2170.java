import java.io.*;
import java.util.*;

public class Main {
    private static ArrayList<Integer>[] adjacencyList;
    private static int[] parent;
    private static int root(int u) {
        while(u != parent[u]) {
            u = parent[u];
        }
        return u;
    }
    private static void dfs(int r, int p) {
        parent[r] = p;
        for(int i: adjacencyList[r]) {
            dfs(i, r);
        }
    }
    public static void main(String[] args) throws IOException{
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        String input;
        while(!(input = f.readLine()).equals("0 0")) {
            StringTokenizer st = new StringTokenizer(input);
            int N = Integer.parseInt(st.nextToken());
            int Q = Integer.parseInt(st.nextToken());
            adjacencyList = new ArrayList[N];
            parent = new int[N];
            for(int i = 0; i < N; i++) {
                adjacencyList[i] = new ArrayList<>();
                parent[i] = i;
            }
            for(int i = 1; i < N; i++) {
                int p = Integer.parseInt(f.readLine())-1;
                adjacencyList[p].add(i);
            }
            dfs(0, 0);
            int ans = 0;
            for(int i = 0; i < Q; i++) {
                st = new StringTokenizer(f.readLine());
                if(st.nextToken().equals("M")) {
                    int v = Integer.parseInt(st.nextToken())-1;
                    parent[v] = v;
                } else {
                    int v = Integer.parseInt(st.nextToken())-1;
                    ans += root(v)+1;
                }
            }
            out.println(ans);
        }
        f.close();
        out.close();
    }
}