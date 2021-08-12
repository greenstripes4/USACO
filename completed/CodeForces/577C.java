import java.io.*;
import java.util.*;

public class Main {
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
    public static void main(String[] args) throws IOException {
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        int n = Integer.parseInt(f.readLine());
        HashMap<Integer, Integer> primes = new HashMap<>();
        for(int i = 2; i <= n; i++) {
            HashMap<Integer, Integer> temp = getPrimeFactorization1(i);
            for(int j: temp.keySet()) {
                if(!primes.containsKey(j) || primes.get(j) < temp.get(j)) {
                    primes.put(j, temp.get(j));
                }
            }
        }
        int k = 0;
        for(int i: primes.values()) {
            k += i;
        }
        out.println(k);
        StringBuilder sb = new StringBuilder();
        for(int i: primes.keySet()) {
            int cur = 1;
            for(int j = 1; j <= primes.get(i); j++) {
                cur *= i;
                sb.append(cur);
                sb.append(" ");
            }
        }
        if(sb.length() > 0) {
            sb.deleteCharAt(sb.length()-1);
        }
        out.println(sb);
        f.close();
        out.close();
    }
}
