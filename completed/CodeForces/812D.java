import java.io.*;
import java.util.*;

public class Main {
    private static ArrayList<ArrayList<Integer>> adjacencyList;
    private static int[] subtreeSize;
    private static int[] in;
    private static int[] ot;
    private static int t;
    private static void dfs(int u) {
        subtreeSize[u] = 1;
        in[u] = t++;
        for(int v: adjacencyList.get(u)) {
            dfs(v);
            subtreeSize[u] += subtreeSize[v];
        }
        ot[u] = t++;
    }
    public static void main(String[] args) throws IOException {
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        //PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("milkvisits.out")));
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        StringTokenizer st = new StringTokenizer(f.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int q = Integer.parseInt(st.nextToken());
        adjacencyList = new ArrayList<>(n+1);
        for(int i = 0; i <= n; i++) {
            adjacencyList.add(new ArrayList<>());
        }
        int[] last = new int[m];
        boolean[] flag = new boolean[n+1];
        for(int i = 0; i < k; i++) {
            st = new StringTokenizer(f.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken())-1;
            if(last[b] > 0) {
                adjacencyList.get(last[b]).add(a);
                flag[a] = true;
            }
            last[b] = a;
        }
        subtreeSize = new int[n+1];
        in = new int[n+1];
        ot = new int[n+1];
        t = 0;
        for(int i = 1; i <= n; i++) {
            if(!flag[i]) {
                dfs(i);
            }
        }
        for(int i = 0; i < q; i++) {
            st = new StringTokenizer(f.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken())-1;
            if(last[y] == 0) {
                out.println(0);
                continue;
            }
            if(in[x] < in[last[y]] && ot[x] > ot[last[y]]) {
                out.println(subtreeSize[x]);
            } else {
                out.println(0);
            }
        }
        f.close();
        out.close();
    }
}