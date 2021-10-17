import java.io.*;
import java.util.*;

public class Main {
    private static int[] a;
    private static ArrayList<ArrayList<Integer>> adjacencyList;
    private static long[] max;
    private static long[] sum;
    private static long dfs(int u, int p) {
        long first = Long.MIN_VALUE;
        long second = Long.MIN_VALUE;
        long ans = Long.MIN_VALUE;
        long total = a[u];
        for(int v: adjacencyList.get(u)) {
            if(v != p) {
                ans = Math.max(ans, dfs(v, u));
                total += sum[v];
                if(max[v] > first) {
                    second = first;
                    first = max[v];
                } else if(max[v] > second) {
                    second = max[v];
                }
            }
        }
        max[u] = Math.max(total, first);
        sum[u] = total;
        if(second > Long.MIN_VALUE) {
            ans = Math.max(ans, first+second);
        }
        return ans;
    }
    public static void main(String[] args) throws IOException{
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        int n = Integer.parseInt(f.readLine());
        StringTokenizer st = new StringTokenizer(f.readLine());
        a = new int[n];
        for(int i = 0; i < n; i++) {
            a[i] = Integer.parseInt(st.nextToken());
        }
        adjacencyList = new ArrayList<>();
        for(int i = 0; i < n; i++) {
            adjacencyList.add(new ArrayList<>());
        }
        for(int i = 0; i < n-1; i++) {
            st = new StringTokenizer(f.readLine());
            int u = Integer.parseInt(st.nextToken())-1;
            int v = Integer.parseInt(st.nextToken())-1;
            adjacencyList.get(u).add(v);
            adjacencyList.get(v).add(u);
        }
        max = new long[n];
        sum = new long[n];
        long ans = dfs(0, -1);
        out.println(ans == Long.MIN_VALUE ? "Impossible" : ans);
        f.close();
        out.close();
    }
}
