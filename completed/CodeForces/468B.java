import java.io.*;
import java.util.*;

public class Main {
    private static int[] parent;
    private static int[] size;
    private static int root(int u) {
        while(u != parent[u]) {
            parent[u] = parent[parent[u]];
            u = parent[u];
        }
        return u;
    }
    private static void union(int u, int v) {
        int rootU = root(u);
        int rootV = root(v);
        if(rootU == rootV) {
            return;
        }
        if(size[rootU] < size[rootV]) {
            parent[rootU] = rootV;
            size[rootV] += size[rootU];
        } else {
            parent[rootV] = rootU;
            size[rootU] += size[rootV];
        }
    }
    private static void init(int n) {
        parent = new int[n];
        size = new int[n];
        for(int i = 0; i < n; i++) {
            parent[i] = i;
            size[i] = 1;
        }
    }
    public static void main(String[] args) throws IOException {
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        //PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("milkvisits.out")));
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        StringTokenizer st = new StringTokenizer(f.readLine());
        int n = Integer.parseInt(st.nextToken());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(f.readLine());
        int[] p = new int[n];
        HashMap<Integer, Integer> idx = new HashMap<>();
        for(int i = 0; i < n; i++) {
            p[i] = Integer.parseInt(st.nextToken());
            idx.put(p[i], i);
        }
        init(n);
        for(int i = 0; i < n; i++) {
            if(idx.containsKey(a-p[i])) {
                union(i, idx.get(a-p[i]));
            }
            if(idx.containsKey(b-p[i])) {
                union(i, idx.get(b-p[i]));
            }
        }
        HashMap<Integer, HashSet<Integer>> components = new HashMap<>();
        for(int i = 0; i < n; i++) {
            components.putIfAbsent(root(i), new HashSet<>());
            components.get(root(i)).add(i);
        }
        int[] matching = new int[n];
        boolean flag = false;
        for(HashSet<Integer> i: components.values()) {
            boolean flag1 = false;
            boolean flag2 = false;
            for(int j: i) {
                if(!i.contains(idx.getOrDefault(a-p[j], -1))) {
                    flag1 = true;
                }
                if(!i.contains(idx.getOrDefault(b-p[j], -1))) {
                    flag2 = true;
                }
            }
            if(flag1 && flag2) {
                flag = true;
                break;
            }
            if(!flag2) {
                for(int j: i) {
                    matching[j] = 1;
                }
            }
        }
        if(flag) {
            out.println("NO");
        } else {
            out.println("YES");
            out.print(matching[0]);
            for(int i = 1; i < n; i++) {
                out.print(" " + matching[i]);
            }
            out.println();
        }
        f.close();
        out.close();
    }
}
