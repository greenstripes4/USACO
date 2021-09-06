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
        while(true) {
            StringTokenizer st = new StringTokenizer(f.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            if(n == 0 && m == 0) {
                break;
            }
            HashMap<Integer, Integer> pf = new HashMap<>();
            for(int i = 2; i <= n; i++) {
                HashMap<Integer, Integer> temp = getPrimeFactorization1(i);
                for(int j: temp.keySet()) {
                    pf.put(j, pf.getOrDefault(j, 0)+temp.get(j));
                }
            }
            HashMap<Integer, Integer> min = getPrimeFactorization1(m);
            long ans = 1;
            for(int i: pf.keySet()) {
                if(min.containsKey(i)) {
                    ans *= Math.max(0, pf.get(i)-min.get(i)+1);
                } else {
                    ans *= pf.get(i)+1;
                }
            }
            for(int i: min.keySet()) {
                if(!pf.containsKey(i)) {
                    ans = 0;
                    break;
                }
            }
            out.println(ans);
        }
        f.close();
        out.close();
    }
}