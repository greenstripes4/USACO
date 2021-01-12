import java.io.*;
import java.util.*;

public class Main {
    private static long pow(int a, int b) {
        if(b == 0) {
            return 1;
        }
        if(b%2 == 0) {
            long temp = pow(a, b/2);
            return temp*temp;
        }
        return a*pow(a, b-1);
    }
    public static void main(String[] args) throws IOException{
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        int n = Integer.parseInt(f.readLine());
        StringTokenizer st = new StringTokenizer(f.readLine());
        ArrayList<Integer>[] primes = new ArrayList[200001];
        for(int i = 0; i <= 200000; i++) {
            primes[i] = new ArrayList<>();
        }
        for(int i = 0; i < n; i++) {
            int ai = Integer.parseInt(st.nextToken());
            for(int j = 2; j*j <= ai; j++) {
                int k = 0;
                while(ai%j == 0) {
                    k++;
                    ai /= j;
                }
                if(k > 0) {
                    primes[j].add(k);
                }
            }
            if(ai > 1) {
                primes[ai].add(1);
            }
        }
        long GCD = 1;
        for(int i = 0; i < 200000; i++) {
            if(primes[i].size() == n-1) {
                Collections.sort(primes[i]);
                GCD *= pow(i, primes[i].get(0));
            } else if(primes[i].size() == n) {
                Collections.sort(primes[i]);
                GCD *= pow(i, primes[i].get(1));
            }
        }
        out.println(GCD);
        f.close();
        out.close();
    }
}