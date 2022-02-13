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
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        //PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("cowjump.out")));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        linearSieve = new int[1000001];
        calculateLinearSieve();
        int t = Integer.parseInt(f.readLine());
        while(t-- > 0) {
            int n = Integer.parseInt(f.readLine());
            StringTokenizer st = new StringTokenizer(f.readLine());
            HashMap<Integer, Integer> occ = new HashMap<>();
            int[] a = new int[n];
            for(int i = 0; i < n; i++) {
                a[i] = Integer.parseInt(st.nextToken());
                HashMap<Integer, Integer> primeFactorization = getPrimeFactorization2(a[i]);
                int temp = 1;
                for(int j: primeFactorization.keySet()) {
                    if(primeFactorization.get(j)%2 == 1) {
                        temp *= j;
                    }
                }
                a[i] = temp;
                occ.put(a[i], occ.getOrDefault(a[i], 0)+1);
            }
            int max0 = 0;
            int max1 = occ.getOrDefault(1, 0);
            for(int i: occ.keySet()) {
                max0 = Math.max(max0, occ.get(i));
                if(i > 1 && occ.get(i)%2 == 0) {
                    max1 += occ.get(i);
                }
            }
            max1 = Math.max(max1, max0);
            int q = Integer.parseInt(f.readLine());
            while(q-- > 0) {
                long w = Long.parseLong(f.readLine());
                out.println(w == 0 ? max0 : max1);
            }
        }
        f.close();
        out.close();
    }
}
