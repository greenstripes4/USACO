import java.io.*;
import java.util.*;

public class Main {
    private static int[] linearSieve;
    private static ArrayList<Integer> compressedPrimes;
    private static void calculateLinearSieve() {
        compressedPrimes = new ArrayList<>();
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
    public static void main(String[] args) throws IOException {
        //BufferedReader f = new BufferedReader(new FileReader("milkvisits.in"));
        //PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("milkvisits.out")));
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        linearSieve = new int[100001];
        calculateLinearSieve();
        int n = Integer.parseInt(f.readLine());
        StringTokenizer st = new StringTokenizer(f.readLine());
        int[] dp = new int[100001];
        for(int i = 0; i < n; i++) {
            int a = Integer.parseInt(st.nextToken());
            HashMap<Integer, Integer> primeFactorization = getPrimeFactorization2(a);
            int max = 0;
            for(int j: primeFactorization.keySet()) {
                max = Math.max(max, dp[j]);
            }
            for(int j: primeFactorization.keySet()) {
                dp[j] = max+1;
            }
        }
        int max = 1;
        for(int i: dp) {
            max = Math.max(max, i);
        }
        out.println(max);
        f.close();
        out.close();
    }
}