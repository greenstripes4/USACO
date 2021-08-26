import java.io.*;
import java.util.*;

public class Main {
    private static ArrayList<ArrayList<Integer>> adjacencyList;
    private static int[] init;
    private static int[] goal;
    private static ArrayList<Integer> res;
    private static void dfs(int u, int p, int d, int[] f) {
        int temp = f[d];
        if(init[u] != (goal[u]^f[d])) {
            res.add(u);
            f[d] ^= 1;
        }
        for(int v: adjacencyList.get(u)) {
            if(v != p) {
                dfs(v, u, d^1, f);
            }
        }
        f[d] = temp;
    }
    public static void main(String[] args) throws IOException {
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        int n = Integer.parseInt(f.readLine());
        adjacencyList = new ArrayList<>(n);
        for(int i = 0; i < n; i++) {
            adjacencyList.add(new ArrayList<>());
        }
        for(int i = 0; i < n-1; i++) {
            StringTokenizer st = new StringTokenizer(f.readLine());
            int u = Integer.parseInt(st.nextToken())-1;
            int v = Integer.parseInt(st.nextToken())-1;
            adjacencyList.get(u).add(v);
            adjacencyList.get(v).add(u);
        }
        StringTokenizer st = new StringTokenizer(f.readLine());
        init = new int[n];
        for(int i = 0; i < n; i++) {
            init[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(f.readLine());
        goal = new int[n];
        for(int i = 0; i < n; i++) {
            goal[i] = Integer.parseInt(st.nextToken());
        }
        res = new ArrayList<>();
        dfs(0, -1, 0, new int[2]);
        out.println(res.size());
        for(int i: res) {
            out.println(i+1);
        }
        f.close();
        out.close();
    }
}