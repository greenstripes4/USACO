import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        StringTokenizer st = new StringTokenizer(f.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        TreeSet<Integer> left = new TreeSet<>();
        int[] res = new int[n+1];
        for(int i = 1; i <= n; i++) {
            left.add(i);
        }
        for(int i = 0; i < m; i++) {
            st = new StringTokenizer(f.readLine());
            int l = Integer.parseInt(st.nextToken());
            int r = Integer.parseInt(st.nextToken());
            int x = Integer.parseInt(st.nextToken());
            Integer cur = left.ceiling(l);
            while(cur != null && cur <= r) {
                if(cur != x) {
                    res[cur] = x;
                    left.remove(cur);
                }
                cur = left.higher(cur);
            }
        }
        out.print(res[1]);
        for(int i = 2; i <= n; i++) {
            out.print(" " + res[i]);
        }
        out.println();
        f.close();
        out.close();
    }
}
