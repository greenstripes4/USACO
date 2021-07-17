import java.io.*;
import java.util.*;

public class Main {
    private static final int MOD = 998244353;
    private static int multiply(long a, long b) {
        return (int) ((a%MOD*b%MOD)%MOD);
    }
    private static int modularInverse(long a) {
        return power(a, MOD-2);
    }
    private static int power(long a, long b) {
        long c = 1;
        while(b > 0) {
            if((b&1) > 0) {
                c = multiply(c, a);
            }
            a = multiply(a, a);
            b >>= 1;
        }
        return (int) c;
    }
    public static void main(String[] args) throws IOException {
        //Scanner f = new Scanner(new File("uva.in"));
        //Scanner f = new Scanner(System.in);
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        int n = Integer.parseInt(f.readLine());
        int[][] a = new int[n][];
        int[] occ = new int[1000001];
        long total = 0;
        for(int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(f.readLine());
            int k = Integer.parseInt(st.nextToken());
            a[i] = new int[k];
            for(int j = 0; j < k; j++) {
                a[i][j] = Integer.parseInt(st.nextToken());
                occ[a[i][j]]++;
                total += n;
            }
        }
        long valid = 0;
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < a[i].length; j++) {
                valid += occ[a[i][j]];
            }
        }
        out.println(multiply(valid, modularInverse(total)));
        f.close();
        out.close();
    }
}