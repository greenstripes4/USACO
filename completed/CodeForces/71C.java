import java.io.*;
import java.util.*;

public class Main {
    private static int n;
    private static int[] a;
    private static boolean isValid(int sides) {
        int MOD = n/sides;
        boolean[] invalid = new boolean[MOD];
        for(int i = 0; i < n; i++) {
            if(a[i] == 0) {
                invalid[i%MOD] = true;
            }
        }
        for(boolean i: invalid) {
            if(!i) {
                return true;
            }
        }
        return false;
    }
    public static void main(String[] args) throws IOException {
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        n = Integer.parseInt(f.readLine());
        StringTokenizer st = new StringTokenizer(f.readLine());
        a = new int[n];
        for(int i = 0; i < n; i++) {
            a[i] = Integer.parseInt(st.nextToken());
        }
        boolean found = false;
        for(int d = 1; d*d <= n; d++) {
            if(n%d == 0) {
                if((d > 2 && isValid(d)) || (n/d > 2 && isValid(n/d))) {
                    found = true;
                    break;
                }
            }
        }
        out.println(found ? "YES" : "NO");
        f.close();
        out.close();
    }
}
