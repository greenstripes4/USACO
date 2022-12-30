import java.io.*;
import java.util.*;

public class Main {
    private static final int MOD = 998244353;
    private static long[] factorial;
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
        //PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("milkvisits.out")));
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        factorial = new long[100001];
        calculateFactorials();
        int t = Integer.parseInt(f.readLine());
        while(t-- > 0) {
            int n = Integer.parseInt(f.readLine());
            char[] arr = f.readLine().toCharArray();
            int zeros = 0;
            int ones = 0;
            boolean countPrev = true;
            for(int i = 0; i < n; i++) {
                if(arr[i] == '0') {
                    zeros++;
                    countPrev = true;
                } else if(!countPrev) {
                    ones++;
                    countPrev = true;
                } else {
                    countPrev = false;
                }
            }
            out.println(C(zeros+ones, ones));
        }
        f.close();
        out.close();
    }
}
