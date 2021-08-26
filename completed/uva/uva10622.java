import java.io.*;
import java.util.*;

public class Main {
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
        while(true) {
            long x = Long.parseLong(f.readLine());
            if(x == 0) {
                break;
            }
            boolean negative = x < 0;
            if(negative) {
                x = -x;
            }
            int gcd = 0;
            for(long p = 2; p*p <= x; p++) {
                int e = 0;
                while(x%p == 0) {
                    x /= p;
                    e++;
                }
                if(e > 0) {
                    if(negative) {
                        while(e%2 == 0) {
                            e /= 2;
                        }
                    }
                    gcd = gcd(gcd, e);
                }
            }
            if(x > 1) {
                gcd = gcd(gcd, 1);
            }
            out.println(gcd);
        }
        f.close();
        out.close();
    }
}
