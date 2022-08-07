import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        //PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("milkvisits.out")));
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        StringTokenizer st = new StringTokenizer(f.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        TreeMap<Integer, ArrayList<int[]>> edges = new TreeMap<>();
        for(int i = 0; i < m; i++) {
            st = new StringTokenizer(f.readLine());
            int u = Integer.parseInt(st.nextToken())-1;
            int v = Integer.parseInt(st.nextToken())-1;
            int w = Integer.parseInt(st.nextToken());
            edges.putIfAbsent(w, new ArrayList<>());
            edges.get(w).add(new int[]{u, v});
        }
        int[] dp = new int[n];
        for(ArrayList<int[]> i: edges.values()) {
            int[] temp = new int[i.size()];
            for(int j = 0; j < i.size(); j++) {
                temp[j] = Math.max(temp[j], dp[i.get(j)[0]]+1);
            }
            for(int j = 0; j < i.size(); j++) {
                dp[i.get(j)[1]] = Math.max(dp[i.get(j)[1]], temp[j]);
            }
        }
        int max = 0;
        for(int i: dp) {
            max = Math.max(max, i);
        }
        out.println(max);
        f.close();
        out.close();
    }
}