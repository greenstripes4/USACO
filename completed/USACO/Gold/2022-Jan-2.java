import java.io.*;
import java.util.*;

public class Main {
    private static ArrayList<ArrayList<Integer>> adjacencyList;
    private static int[] res;
    private static void dfs(int u, int val) {
        if(res[u] > 0) {
            return;
        }
        res[u] = val;
        for(int v: adjacencyList.get(u)) {
            dfs(v, val);
        }
    }
    public static void main(String[] args) throws IOException {
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        //PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("milkvisits.out")));
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        StringTokenizer st = new StringTokenizer(f.readLine());
        int N = Integer.parseInt(st.nextToken());
        int Q = Integer.parseInt(st.nextToken());
        boolean[] deactivated = new boolean[N+1];
        char[] type = new char[Q];
        int[] idx = new int[Q];
        ArrayList<int[]> edges = new ArrayList<>();
        HashSet<Integer> removed = new HashSet<>();
        for(int i = 0; i < Q; i++) {
            st = new StringTokenizer(f.readLine());
            type[i] = st.nextToken().charAt(0);
            if(type[i] == 'D') {
                idx[i] = Integer.parseInt(st.nextToken());
                deactivated[idx[i]] = true;
            } else if(type[i] == 'A') {
                int[] edge = {Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())};
                edges.add(edge);
            } else {
                idx[i] = Integer.parseInt(st.nextToken());
                removed.add(idx[i]);
            }
        }
        adjacencyList = new ArrayList<>(N+1);
        for(int i = 0; i <= N; i++) {
            adjacencyList.add(new ArrayList<>());
        }
        for(int i = 0; i < edges.size(); i++) {
            if(!removed.contains(i+1)) {
                adjacencyList.get(edges.get(i)[0]).add(edges.get(i)[1]);
                adjacencyList.get(edges.get(i)[1]).add(edges.get(i)[0]);
            }
        }
        res = new int[N+1];
        for(int i = 1; i <= N; i++) {
            if(!deactivated[i]) {
                dfs(i, Q);
            }
        }
        for(int i = Q-1; i > 0; i--) {
            if(type[i] == 'D') {
                dfs(idx[i], i);
            } else if(type[i] == 'R') {
                int u = edges.get(idx[i]-1)[0];
                int v = edges.get(idx[i]-1)[1];
                if(res[u] > 0 || res[v] > 0) {
                    dfs(u, i);
                    dfs(v, i);
                }
                adjacencyList.get(u).add(v);
                adjacencyList.get(v).add(u);
            }
        }
        for(int i = 1; i <= N; i++) {
            out.println(res[i]);
        }
        f.close();
        out.close();
    }
}
