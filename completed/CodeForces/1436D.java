import java.io.*;
import java.util.*;

public class Main {
    private static ArrayList<ArrayList<Integer>> adjacencyList;
    private static int[] a;
    private static long max;
    private static long[] dfs(int u, int p) {
        long sum = a[u];
        long leaves = 0;
        for(int v: adjacencyList.get(u)) {
            if(v != p) {
                long[] temp = dfs(v, u);
                sum += temp[0];
                leaves += temp[1];
            }
        }
        leaves = Math.max(leaves, 1);
        max = Math.max(max, (sum+leaves-1)/leaves);
        return new long[]{sum, leaves};
    }
    public static void main(String[] args) throws IOException {
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        //PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("cowjump.out")));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        int n = Integer.parseInt(f.readLine());
        adjacencyList = new ArrayList<>(n);
        for(int i = 0; i < n; i++) {
            adjacencyList.add(new ArrayList<>());
        }
        StringTokenizer st = new StringTokenizer(f.readLine());
        for(int i = 1; i < n; i++) {
            adjacencyList.get(Integer.parseInt(st.nextToken())-1).add(i);
        }
        st = new StringTokenizer(f.readLine());
        a = new int[n];
        for(int i = 0; i < n; i++) {
            a[i] = Integer.parseInt(st.nextToken());
        }
        dfs(0, -1);
        out.println(max);
        f.close();
        out.close();
    }
}
