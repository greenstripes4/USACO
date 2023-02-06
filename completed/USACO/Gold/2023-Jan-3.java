import java.io.*;
import java.util.*;

public class Main {
    private static final int MOD = 1000000007;
    private static long[] factorial;
    private static int add(long a, long b) { return (int) (((a+MOD)%MOD+(b+MOD)%MOD)%MOD); }
    private static int subtract(long a, long b) { return add(a, -b); }
    private static int multiply(long a, long b) { return (int) (((a%MOD)*(b%MOD))%MOD); }
    private static int divide(long a, long b) { return multiply(a, modularInverse(b)); }
    private static int modularInverse(long a) { return power(a, MOD-2); }
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
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        factorial = new long[500005];
        calculateFactorials();
        int N = Integer.parseInt(f.readLine());
        StringTokenizer st = new StringTokenizer(f.readLine());
        int[] A = new int[N];
        for(int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }
        long[] dp = new long[N];
        dp[N-1] = 1;
        for(int i = N-2; i >= 0; i--) {
            int n = A[i+1]/2;
            int k = A[i]/2;
            if(n >= k) {
                dp[i] = multiply(dp[i+1], C(n-1, k-1));
            } else {
                dp[i] = multiply(dp[i+1], C(k, n));
            }
        }
        out.println(dp[0]);
        f.close();
        out.close();
    }
}
