import java.io.*;
import java.util.*;

public class Main {
    private static long[] factorial;
    private static int MOD;
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
            factorial[i] = factorial[i-1]*i;
        }
    }
    public static void main(String[] args) throws IOException {
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        //PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("milkvisits.out")));
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        StringTokenizer st = new StringTokenizer(f.readLine());
        long n = Long.parseLong(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        MOD = m;
        ArrayList<Integer> digits = new ArrayList<>();
        int[] occ = new int[10];
        while(n > 0) {
            digits.add((int) (n%10));
            occ[(int) (n%10)]++;
            n /= 10;
        }
        factorial = new long[18];
        calculateFactorials();
        long[][] dp = new long[1 << digits.size()][m];
        dp[0][0] = 1;
        for(int i = 0; i < 1 << digits.size(); i++) {
            int zeros = 0;
            int other = 0;
            for(int j = 0; j < digits.size(); j++) {
                if((i&(1 << j)) > 0) {
                    if(digits.get(j) == 0) {
                        zeros++;
                    } else {
                        other++;
                    }
                }
            }
            if(zeros > 0 && other == 0) {
                continue;
            }
            for(int j = 0; j < m; j++) {
                for(int k = 0; k < digits.size(); k++) {
                    if((i&(1 << k)) == 0) {
                        int l = i|(1 << k);
                        dp[l][add(multiply(j, 10), digits.get(k))] += dp[i][j];
                    }
                }
            }
        }
        for(int i: occ) {
            dp[(1 << digits.size())-1][0] /= factorial[i];
        }
        out.println(dp[(1 << digits.size())-1][0]);
        f.close();
        out.close();
    }
}