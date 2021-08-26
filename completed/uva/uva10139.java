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
        String input;
        while((input = f.readLine()) != null) {
            StringTokenizer st = new StringTokenizer(input);
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            HashMap<Integer, Integer> primeFactorization = getPrimeFactorization1(m);
            boolean flag = false;
            for(int i: primeFactorization.keySet()) {
                long count = 0;
                int temp = n;
                while(temp > 0) {
                    temp /= i;
                    count += temp;
                }
                if(count < primeFactorization.get(i)) {
                    flag = true;
                    break;
                }
            }
            if(flag) {
                out.println(m + " does not divide " + n + "!");
            } else {
                out.println(m + " divides " + n + "!");
            }
        }
        f.close();
        out.close();
    }
}
