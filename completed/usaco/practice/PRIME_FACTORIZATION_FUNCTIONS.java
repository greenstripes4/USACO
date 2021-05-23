import java.io.*;
import java.util.*;

public class Main {
    private static int[] modifiedSieve;
    private static boolean[] linearSieve;
    private static ArrayList<Integer> compressedPrimes;
    private static void calculateSieve() {
        modifiedSieve[0] = Integer.MAX_VALUE;
        for (int i = 1; i < modifiedSieve.length; i++) {
            for (int j = i; j < modifiedSieve.length; j += i) {
                modifiedSieve[j]++;
            }
        }
    }
    private static void calculateLinearSieve() {
        compressedPrimes = new ArrayList<>();
        linearSieve[0] = true;
        linearSieve[1] = true;
        for(int i = 2; i < linearSieve.length; i++) {
            if(!linearSieve[i]) {
                compressedPrimes.add(i);
            }
            for(int j: compressedPrimes) {
                if(i*j >= linearSieve.length) {
                    break;
                }
                linearSieve[i*j] = true;
                if(i%j == 0) {
                    break;
                }
            }
        }
    }
    /*
    private static void calculateCompressedPrimes() {
        compressedPrimes = new ArrayList<>();
        for(int i = 2; i < modifiedSieve.length; i++) {
            if(modifiedSieve[i] == 2) {
                compressedPrimes.add(i);
            }
        }
    }
     */
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
    public static void main(String[] args) throws IOException{
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));

        f.close();
        out.close();
    }
}