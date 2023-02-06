import java.io.*;
import java.util.*;

public class Main {

    private static int N;
    private static int[] modifiedSieve;
    private static int[] linearSieve;
    private static ArrayList<Integer> compressedPrimes;

    private static void calculateSieve() {
        modifiedSieve = new int[N+1];
        modifiedSieve[0] = Integer.MAX_VALUE;
        for (int i = 1; i <= N; i++) {
            for (int j = i; j <= N; j += i) {
                modifiedSieve[j]++;
            }
        }
    }

    private static void calculateLinearSieve() {
        linearSieve = new int[N+1];
        linearSieve[0] = 1;
        linearSieve[1] = 1;
        compressedPrimes = new ArrayList<>();
        for(int i = 2; i <= N; i++) {
            if(linearSieve[i] == 0) {
                linearSieve[i] = i;
                compressedPrimes.add(i);
            }
            for(int j: compressedPrimes) {
                if(i*j > N) {
                    break;
                }
                linearSieve[i*j] = j;
                if(i%j == 0) {
                    break;
                }
            }
        }
    }

    private static void calculateCompressedPrimes() {
        compressedPrimes = new ArrayList<>();
        for(int i = 2; i <= N; i++) {
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

    private static HashMap<Integer, Integer> getPrimeFactorization3(int x) {
        HashMap<Integer, Integer> primeFactorization = new HashMap<>();
        int p = -1;
        int e = 0;
        while(x > 1) {
            if(linearSieve[x] == p){
                e++;
            } else {
                if(e > 0) {
                    primeFactorization.put(p, e);
                }
                p = linearSieve[x];
                e = 1;
            }
            x /= linearSieve[x];
        }
        if(e > 0) {
            primeFactorization.put(p, e);
        }
        return primeFactorization;
    }

    private static int getDivisors1(int x) {
        HashMap<Integer, Integer> primeFactorization = getPrimeFactorization1(x);
        int count = 1;
        for(int i: primeFactorization.values()) {
            count *= i+1;
        }
        return count;
    }

    private static int getDivisors2(int x) {
        if(x <= N) {
            return modifiedSieve[x];
        }
        HashMap<Integer, Integer> primeFactorization = getPrimeFactorization2(x);
        int count = 1;
        for(int i: primeFactorization.values()) {
            count *= i+1;
        }
        return count;
    }

    private static int getDivisors3(int x) {
        HashMap<Integer, Integer> primeFactorization = getPrimeFactorization3(x);
        int count = 1;
        for(int i: primeFactorization.values()) {
            count *= i+1;
        }
        return count;
    }

    private static long gcd(long a, long b) {
        if(a == 0) {
            return b;
        }
        return gcd(b%a, a);
    }

    private static long lcm(long a, long b) {
        return a*b/gcd(a, b);
    }

    public static void main(String[] args) throws IOException{
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));

        f.close();
        out.close();
    }
}
