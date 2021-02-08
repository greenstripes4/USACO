import java.io.*;
import java.util.*;

public class Main {
    private static int root(int[] parent, int i) {
        while(i != parent[i]) {
            parent[i] = parent[parent[i]];
            i = parent[i];
        }
        return i;
    }
    private static void union(int[] parent, int[] size, int i, int j) {
        int rootI = root(parent, i);
        int rootJ = root(parent, j);
        if(size[rootI] < size[rootJ]) {
            parent[rootI] = rootJ;
            size[rootJ] += size[rootI];
        } else {
            parent[rootJ] = rootI;
            size[rootI] += size[rootJ];
        }
    }
    public static void main(String[] args) throws IOException{
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        StringTokenizer st = new StringTokenizer(f.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int[] pos = new int[N];
        HashSet<Integer>[] vis = new HashSet[N];
        int[] parent = new int[N];
        int[] size = new int[N];
        HashSet<Integer>[] total = new HashSet[N];
        for(int i = 0; i < N; i++) {
            pos[i] = i;
            vis[i] = new HashSet<>();
            vis[i].add(i);
            parent[i] = i;
            size[i] = 1;
            total[i] = new HashSet<>();
        }
        for(int i = 0; i < K; i++) {
            st = new StringTokenizer(f.readLine());
            int ai = Integer.parseInt(st.nextToken())-1;
            int bi = Integer.parseInt(st.nextToken())-1;
            vis[pos[ai]].add(bi);
            vis[pos[bi]].add(ai);
            int temp = pos[ai];
            pos[ai] = pos[bi];
            pos[bi] = temp;
        }
        for(int i = 0; i < N; i++) {
            union(parent, size, i, pos[i]);
        }
        for(int i = 0; i < N; i++) {
            total[root(parent, i)].addAll(vis[i]);
        }
        for(int i = 0; i < N; i++) {
            out.println(total[root(parent, i)].size());
        }
        f.close();
        out.close();
    }
}
