import java.io.*;
import java.util.*;

public class Main {
    private static int power(long a, long b) {
        long c = 1;
        while(b > 0) {
            if((b&1) > 0) {
                c *= a;
            }
            a *= a;
            b >>= 1;
        }
        return (int) c;
    }
    private static TreeMap<Integer, Integer> getPrimeFactorization1(int x) {
        TreeMap<Integer, Integer> primeFactorization = new TreeMap<>(Comparator.reverseOrder());
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
        String input;
        while(!(input = f.readLine()).equals("0")) {
            StringTokenizer st = new StringTokenizer(input);
            int n = 1;
            while(st.hasMoreTokens()) {
                int p = Integer.parseInt(st.nextToken());
                int e = Integer.parseInt(st.nextToken());
                n *= power(p, e);
            }
            TreeMap<Integer, Integer> primeFactorization = getPrimeFactorization1(n-1);
            StringBuilder sb = new StringBuilder();
            for(int i: primeFactorization.keySet()) {
                sb.append(i);
                sb.append(" ");
                sb.append(primeFactorization.get(i));
                sb.append(" ");
            }
            sb.deleteCharAt(sb.length()-1);
            out.println(sb);
        }
        f.close();
        out.close();
    }
}
