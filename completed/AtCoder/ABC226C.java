import java.io.*;
import java.util.*;

public class Main {
    private static int[][] prerequisites;
    private static boolean[] visited;
    private static void dfs(int u) {
        visited[u] = true;
        for(int v: prerequisites[u]) {
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
        int N = Integer.parseInt(f.readLine());
        int[] time = new int[N];
        prerequisites = new int[N][];
        for(int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(f.readLine());
            int T = Integer.parseInt(st.nextToken());
            int K = Integer.parseInt(st.nextToken());
            time[i] = T;
            prerequisites[i] = new int[K];
            for(int j = 0; j < K; j++) {
                prerequisites[i][j] = Integer.parseInt(st.nextToken())-1;
            }
        }
        visited = new boolean[N];
        dfs(N-1);
        long ans = 0;
        for(int i = 0; i < N; i++) {
            if(visited[i]) {
                ans += time[i];
            }
        }
        out.println(ans);
        f.close();
        out.close();
    }
}