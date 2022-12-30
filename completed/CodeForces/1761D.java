import java.io.*;
import java.util.*;

public class Main {
    private static final int MOD = 1000000007;
    private static long[] factorial;
    private static int add(long a, long b) { return (int) (((a+MOD)%MOD+(b+MOD)%MOD)%MOD); }
    private static int subtract(long a, long b) {
        return add(a, -b);
    }
    private static int multiply(long a, long b) {
        return (int) (((a%MOD)*(b%MOD))%MOD);
    }
    private static int divide(long a, long b) {
        return multiply(a, modularInverse(b));
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
    private static void calculateFactorials() {
        factorial[0] = 1;
        for(int i = 1; i < factorial.length; i++) {
            factorial[i] = multiply(factorial[i-1], i);
        }
    }
    private static int C(int n, int r) {
        if(r > n) {
            return 0;
        }
        return divide(factorial[n], multiply(factorial[r], factorial[n-r]));
    }
    public static void main(String[] args) throws IOException {
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        //PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("threesum.out")));
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        factorial = new long[1000001];
        calculateFactorials();
        int[] pow = new int[1000001];
        pow[0] = 1;
        for(int i = 1; i <= 1000000; i++) {
            pow[i] = multiply(pow[i-1], 3);
        }
        StringTokenizer st = new StringTokenizer(f.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        if(k == 0) {
            out.println(pow[n]);
        } else {
            int ans = 0;
            int w = n-k+1;
            int M = Math.min(k, w);
            for(int m = 1; m <= M; m++) {
                int x = C(k-1, m-1);
                int a = multiply(C(w, m), x);
                int b = multiply(C(w-1, m-1), x);
                int c = subtract(a, b);
                if(c > 0) {
                    ans = add(ans, multiply(c, pow[n-2*m]));
                }
                ans = add(ans, multiply(b, pow[n-2*m+1]));
            }
            out.println(ans);
        }
        f.close();
        out.close();
    }
}