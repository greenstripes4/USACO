import java.io.*;
import java.util.*;

public class Main {
    private static int N;
    private static int[] C;
    private static int[] parent;
    private static ArrayList<HashMap<Integer, Integer>> occ;
    private static int root(int u) {
        while(u != parent[u]) {
            parent[u] = parent[parent[u]];
            u = parent[u];
        }
        return u;
    }
    private static boolean union(int u, int v) {
        int rootU = root(u);
        int rootV = root(v);
        if(rootU == rootV) {
            return false;
        }
        if(occ.get(rootU).size() < occ.get(rootV).size()) {
            parent[rootU] = rootV;
            for(int i: occ.get(rootU).keySet()) {
                occ.get(rootV).put(i, occ.get(rootV).getOrDefault(i, 0)+occ.get(rootU).get(i));
            }
        } else {
            parent[rootV] = rootU;
            for(int i: occ.get(rootV).keySet()) {
                occ.get(rootU).put(i, occ.get(rootU).getOrDefault(i, 0)+occ.get(rootV).get(i));
            }
        }
        return true;
    }
    private static void init() {
        parent = new int[N];
        occ = new ArrayList<>();
        for(int i = 0; i < N; i++) {
            parent[i] = i;
            occ.add(new HashMap<>());
            occ.get(i).put(C[i], 1);
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        StringTokenizer st = new StringTokenizer(f.readLine());
        N = Integer.parseInt(st.nextToken());
        int Q = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(f.readLine());
        C = new int[N];
        for(int i = 0; i < N; i++) {
            C[i] = Integer.parseInt(st.nextToken());
        }
        init();
        while(Q-- > 0) {
            st = new StringTokenizer(f.readLine());
            int type = Integer.parseInt(st.nextToken());
            int a = Integer.parseInt(st.nextToken())-1;
            int b = Integer.parseInt(st.nextToken())-1;
            if(type == 1) {
                union(a, b);
            } else {
                out.println(occ.get(root(a)).getOrDefault(b+1, 0));
            }
        }
        f.close();
        out.close();
    }
}
