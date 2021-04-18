import java.io.*;
import java.util.*;

public class Main {
    private static int[] factorial;
    private static final int MOD = 1000000007;
    private static int add(int a, int b) {
        return (int) (((long) a+b)%MOD);
    }
    private static int subtract(int a, int b) {
        return add(a, -b);
    }
    private static int multiply(int a, int b) {
        return (int) (((long) a*b)%MOD);
    }
    private static int divide(int a, int b) {
        return multiply(a, modularInverse(b));
    }
    private static int modularInverse(int a) {
        return power(a, MOD-2);
    }
    private static int power(int a, int b) {
        int c = 1;
        while(b > 0) {
            if((b&1) > 0) {
                c = multiply(c, a);
            }
            a = multiply(a, a);
            b >>= 1;
        }
        return c;
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
    public static void main(String[] args) throws IOException{
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        factorial = new int[1000001];
        calculateFactorials();
        char[] str = f.readLine().toCharArray();
        int[] occ = new int[26];
        for(char i: str) {
            occ[i-'a']++;
        }
        int ans = factorial[str.length];
        for(int i: occ) {
            ans = divide(ans, factorial[i]);
        }
        out.println(ans);
        f.close();
        out.close();
    }
}