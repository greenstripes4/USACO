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
        HashMap<Integer, ArrayList<Integer>> map = new HashMap<>();
        TreeSet<Integer> unique = new TreeSet<>();
        for(int i = 0; i < m; i++) {
            st = new StringTokenizer(f.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            map.putIfAbsent(v, new ArrayList<>());
            map.get(v).add(u);
            unique.add(u);
            unique.add(v);
        }
        if(!unique.contains(0) || !unique.contains(n)) {
            out.println(0);
        } else {
            HashMap<Integer, Integer> compressed = new HashMap<>();
            int idx = 0;
            for(int i: unique) {
                compressed.put(i, idx++);
            }
            ArrayList<ArrayList<Integer>> adjacencyList = new ArrayList<>(idx);
            for(int i = 0; i < idx; i++) {
                adjacencyList.add(new ArrayList<>());
            }
            for(int i: map.keySet()) {
                for(int j: map.get(i)) {
                    adjacencyList.get(compressed.get(i)).add(compressed.get(j));
                }
            }
            long[] dp = new long[idx];
            long[] pref = new long[idx+1];
            dp[0] = 1;
            pref[1] = 1;
            for(int i = 1; i < idx; i++) {
                for(int j: adjacencyList.get(i)) {
                    dp[i] = (dp[i]+pref[i]-pref[j]+1000000007)%1000000007;
                }
                pref[i+1] = (pref[i]+dp[i])%1000000007;
            }
            out.println(dp[idx-1]);
        }
        f.close();
        out.close();
    }
}