import java.io.*;
import java.util.*;

public class Main {
    private static int m;
    private static int[] a;
    private static ArrayList<Integer>[] adjacencyList;
    private static int count;
    private static void dfs(int u, int p, int c) {
        if(a[u] == 1) {
            c++;
        } else {
            c = 0;
        }
        if(c > m) {
            return;
        }
        boolean leaf = true;
        for(int v: adjacencyList[u]) {
            if(v != p) {
                leaf = false;
                dfs(v, u, c);
            }
        }
        if(leaf) {
            count++;
        }
    }
    public static void main(String[] args) throws IOException {
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        StringTokenizer st = new StringTokenizer(f.readLine());
        int n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(f.readLine());
        a = new int[n];
        for(int i = 0; i < n; i++) {
            a[i] = Integer.parseInt(st.nextToken());
        }
        adjacencyList = new ArrayList[n];
        for(int i = 0; i < n; i++) {
            adjacencyList[i] = new ArrayList<>();
        }
        for(int i = 0; i < n-1; i++) {
            st = new StringTokenizer(f.readLine());
            int x = Integer.parseInt(st.nextToken())-1;
            int y = Integer.parseInt(st.nextToken())-1;
            adjacencyList[x].add(y);
            adjacencyList[y].add(x);
        }
        count = 0;
        dfs(0, -1, 0);
        out.println(count);
        f.close();
        out.close();
    }
}
