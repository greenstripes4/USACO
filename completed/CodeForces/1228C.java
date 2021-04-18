import java.io.*;
import java.util.*;

public class Main {
    private static long[] factorial;
    private static final int MOD = 1000000007;
    private static int add(long a, long b) {
        return (int) ((a%MOD+b%MOD)%MOD);
    }
    private static int subtract(long a, long b) {
        return add(a, -b);
    }
    private static int multiply(long a, long b) {
        return (int) ((a%MOD*b%MOD)%MOD);
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
    private static int[] modifiedSieve;
    private static ArrayList<Integer> compressedPrimes;
    private static void calculateSieve() {
        modifiedSieve[0] = Integer.MAX_VALUE;
        for(int i = 1; i < modifiedSieve.length; i++) {
            for(int j = i; j < modifiedSieve.length; j += i) {
                modifiedSieve[j]++;
            }
        }
    }
    private static void calculateCompressedPrimes() {
        compressedPrimes = new ArrayList<>();
        for(int i = 2; i < modifiedSieve.length; i++) {
            if(modifiedSieve[i] == 2) {
                compressedPrimes.add(i);
            }
        }
    }
    private static HashMap<Integer, Integer> getPrimeFactorization1(int x) {
        HashMap<Integer, Integer> primeFactorization = new HashMap<>();
        for(int p = 2; p*p  <= x; p++) {
            int e = 0;
            while(x%p == 0) {
                e++;
                x /= p;
            }
            if(e > 0) {
                primeFactorization.put(p, e);
            }
        }
        if(x > 1) {
            primeFactorization.put(x, 1);
        }
        return primeFactorization;
    }
    private static HashMap<Integer, Integer> getPrimeFactorization2(int x) {
        HashMap<Integer, Integer> primeFactorization = new HashMap<>();
        for(int p: compressedPrimes) {
            if(p*p > x) {
                break;
            }
            int e = 0;
            while(x%p == 0) {
                e++;
                x /= p;
            }
            if(e > 0) {
                primeFactorization.put(p, e);
            }
        }
        if(x > 1) {
            primeFactorization.put(x, 1);
        }
        return primeFactorization;
    }
    private static int getDivisors1(int x) {
        HashMap<Integer, Integer> primeFactorization = getPrimeFactorization1(x);
        int count = 0;
        for(int i: primeFactorization.values()) {
            count *= i+1;
        }
        return count;
    }
    private static int getDivisors2(int x) {
        if(x < modifiedSieve.length) {
            return modifiedSieve[x];
        }
        HashMap<Integer, Integer> primeFactorization = getPrimeFactorization2(x);
        int count = 0;
        for(int i: primeFactorization.values()) {
            count *= i+1;
        }
        return count;
    }
    private static long k(long n, long p) {
        long ans = 0;
        n /= p;
        while(n > 0) {
            ans += n;
            n /= p;
        }
        return ans;
    }
    public static void main(String[] args) throws IOException {
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        StringTokenizer st = new StringTokenizer(f.readLine());
        int x = Integer.parseInt(st.nextToken());
        long n = Long.parseLong(st.nextToken());
        HashMap<Integer, Integer> primeFactorization = getPrimeFactorization1(x);
        int ans = 1;
        for(int p: primeFactorization.keySet()) {
            ans = multiply(ans, power(p, k(n, p)));
        }
        out.println(ans);
        f.close();
        out.close();
    }
}