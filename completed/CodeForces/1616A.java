import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        //PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("cowjump.out")));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        int t = Integer.parseInt(f.readLine());
        while(t-- > 0) {
            int n = Integer.parseInt(f.readLine());
            StringTokenizer st = new StringTokenizer(f.readLine());
            int[] occ = new int[101];
            for(int i = 0; i < n; i++) {
                occ[Math.abs(Integer.parseInt(st.nextToken()))]++;
            }
            int ans = Math.min(occ[0], 1);
            for(int i = 1; i <= 100; i++) {
                ans += Math.min(occ[i], 2);
            }
            out.println(ans);
        }
        f.close();
        out.close();
    }
}
