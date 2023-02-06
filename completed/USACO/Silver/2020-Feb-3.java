import java.io.*;
import java.util.*;

public class Main {
    private static int[] val;
    private static ArrayList<ArrayList<Integer>> adjacencyList;
    private static void dfs(int u, int p) {
        if(p >= 0) {
            val[u] = (val[u]+1)%12;
        }
        for(int v: adjacencyList.get(u)) {
            if(v != p) {
                dfs(v, u);
            }
        }
        if(p >= 0) {
            val[p] = (val[p]-val[u]+13)%12;
            val[u] = 0;
        }
    }
    public static void main(String[] args) throws IOException {
        //BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader f = new BufferedReader(new FileReader("clocktree.in"));
        //PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("clocktree.out")));
        int N = Integer.parseInt(f.readLine());
        StringTokenizer st = new StringTokenizer(f.readLine());
        int[] cur = new int[N];
        for(int i = 0; i < N; i++) {
            cur[i] = Integer.parseInt(st.nextToken())%12;
        }
        adjacencyList = new ArrayList<>(N);
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
        int ans = 0;
        for(int i = 0; i < N; i++) {
            val = cur.clone();
            dfs(i, -1);
            if(val[i] == 0 || val[i] == 1) {
                ans++;
            }
        }
        out.println(ans);
        f.close();
        out.close();
    }
}