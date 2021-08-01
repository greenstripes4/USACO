import java.io.*;
import java.util.*;

public class Main {
    private static long getPrimeFactorization1(long x) {
        long ans = 1;
        for(long p = 2; p*p  <= x; p++) {
            int e = 0;
            while(x%p == 0) {
                e++;
                x /= p;
            }
            if(e > 0) {
                ans *= p;
            }
        }
        if(x > 1) {
            ans *= x;
        }
        return ans;
    }
    public static void main(String[] args) throws IOException{
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        long n = Long.parseLong(f.readLine());
        out.println(getPrimeFactorization1(n));
        f.close();
        out.close();
    }
}