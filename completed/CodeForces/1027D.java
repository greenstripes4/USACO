import java.io.*;
import java.util.*;

public class Main {
    private static int cost;
    private static int min;
    private static void dfs(int[] a, int[] c, int[] v, int s, int t) {
        v[s] = t;
        if(v[a[s]] == 0) {
            dfs(a, c, v, a[s], t);
        } else if(v[a[s]] == t) {
            min = 10000;
            dfs2(a, c, new HashSet<>(), a[s]);
            cost += min;
        }
    }
    private static void dfs2(int[] a, int[] c, HashSet<Integer> v, int s) {
        min = Math.min(min, c[s]);
        v.add(s);
        if(!v.contains(a[s])) {
            dfs2(a, c, v, a[s]);
        }
    }
    public static void main(String[] args) throws IOException{
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        int n = Integer.parseInt(f.readLine());
        int[] c = new int[n];
        StringTokenizer st = new StringTokenizer(f.readLine());
        for(int i = 0; i < n; i++) {
            c[i] = Integer.parseInt(st.nextToken());
        }
        int[] a = new int[n];
        st = new StringTokenizer(f.readLine());
        for(int i = 0; i < n; i++) {
            a[i] = Integer.parseInt(st.nextToken())-1;
        }
        int[] v = new int[n];
        cost = 0;
        for(int i = 0; i < n; i++) {
            if(v[i] == 0) {
                dfs(a, c, v, i, i+1);
            }
        }
        out.println(cost);
        f.close();
        out.close();
    }
}
