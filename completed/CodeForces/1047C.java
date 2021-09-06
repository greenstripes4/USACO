import java.io.*;
import java.util.*;

public class Main {
    private static int[] linearSieve;
    private static void calculateLinearSieve() {
        ArrayList<Integer> compressedPrimes = new ArrayList<>();
        linearSieve[0] = 1;
        linearSieve[1] = 1;
        for(int i = 2; i < linearSieve.length; i++) {
            if(linearSieve[i] == 0) {
                linearSieve[i] = i;
                compressedPrimes.add(i);
            }
            for(int j: compressedPrimes) {
                if(i*j >= linearSieve.length) {
                    break;
                }
                linearSieve[i*j] = j;
                if(i%j == 0) {
                    break;
                }
            }
        }
    }
    private static int gcd(int a, int b) {
        if(a == 0) {
            return b;
        }
        return gcd(b%a, a);
    }
    public static void main(String[] args) throws IOException {
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        int n = Integer.parseInt(f.readLine());
        StringTokenizer st = new StringTokenizer(f.readLine());
        int[] a = new int[n];
        int gcd = 0;
        for(int i = 0; i < n; i++) {
            a[i] = Integer.parseInt(st.nextToken());
            gcd = gcd(gcd, a[i]);
        }
        int MAX = 0;
        for(int i = 0; i < n; i++) {
            a[i] /= gcd;
            MAX = Math.max(MAX, a[i]);
        }
        if(MAX == 1) {
            out.println(-1);
        } else {
            linearSieve = new int[MAX+1];
            calculateLinearSieve();
            HashMap<Integer, Integer> primes = new HashMap<>();
            for(int i: a) {
                HashSet<Integer> temp = new HashSet<>();
                while(i > 1) {
                    temp.add(linearSieve[i]);
                    i /= linearSieve[i];
                }
                for(int j: temp) {
                    primes.put(j, primes.getOrDefault(j, 0)+1);
                }
            }
            int min = n;
            for(int i: primes.values()) {
                min = Math.min(min, n-i);
            }
            out.println(min);
        }
        f.close();
        out.close();
    }
}