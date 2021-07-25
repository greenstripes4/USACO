import java.io.*;
import java.util.*;

public class Main {
    private static StringBuilder eulerianCycle;
    private static void dfs(int v, int k) {
        if(v == k) {
            eulerianCycle.append('a');
            return;
        }
        eulerianCycle.append((char) ('a'+v));
        for(int i = v+1; i < k; i++) {
            eulerianCycle.append((char) ('a'+v));
            eulerianCycle.append((char) ('a'+i));
        }
        dfs(v+1, k);
    }
    public static void main(String[] args) throws IOException{
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        StringTokenizer st = new StringTokenizer(f.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        eulerianCycle = new StringBuilder();
        dfs(0, k);
        StringBuilder res = new StringBuilder(eulerianCycle);
        if(eulerianCycle.length() > 1) {
            eulerianCycle.deleteCharAt(0);
        }
        while(res.length() < n) {
            res.append(eulerianCycle);
        }
        out.println(res.substring(0, n));
        f.close();
        out.close();
    }
}