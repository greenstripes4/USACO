import java.io.*;
import java.util.*;

public class Main {
    private static long gcd(long a, long b) {
        if(a == 0) {
            return b;
        }
        return gcd(b%a, a);
    }
    public static void main(String[] args) throws IOException {
        //BufferedReader f = new BufferedReader(new FileReader("milkvisits.in"));
        //PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("milkvisits.out")));
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        long n = Integer.parseInt(f.readLine());
        if(n == 1) {
            out.println(1);
        } else if(n == 2) {
            out.println(2);
        } else if(n%2 == 0) {
            long max = (n-1)*(n-2)*(n-3);
            for(long i = n-3; i >= 0; i--) {
                if(gcd(n, i) == 1 && gcd(n-1, i) == 1) {
                    max = Math.max(max, n*(n-1)*i);
                    break;
                }
            }
            out.println(max);
        } else {
            out.println(n*(n-1)*(n-2));
        }
        f.close();
        out.close();
    }
}