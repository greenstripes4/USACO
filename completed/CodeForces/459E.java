import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        StringTokenizer st = new StringTokenizer(f.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        ArrayList<int[]>[] edges = new ArrayList[100001];
        for(int i = 0; i < m; i++) {
            st = new StringTokenizer(f.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            if(edges[w] == null) {
                edges[w] = new ArrayList<>();
            }
            edges[w].add(new int[]{u, v});
        }
        int[] dp = new int[n+1];
        int[] temp = new int[n+1];
        for(ArrayList<int[]> i: edges) {
            if(i == null) {
                continue;
            }
            for(int[] j: i) {
                temp[j[1]] = 0;
            }
            for(int[] j: i) {
                temp[j[1]] = Math.max(temp[j[1]], dp[j[0]]+1);
            }
            for(int j = 1; j <= n; j++) {
                dp[j] = Math.max(dp[j], temp[j]);
            }
        }
        int max = 0;
        for(int i = 1; i <= n; i++) {
            max = Math.max(max, dp[i]);
        }
        out.println(max);
        f.close();
        out.close();
    }
}