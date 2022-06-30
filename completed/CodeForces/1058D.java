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
        StringTokenizer st = new StringTokenizer(f.readLine());
        long n = Integer.parseInt(st.nextToken());
        long m = Integer.parseInt(st.nextToken());
        long k = Integer.parseInt(st.nextToken());
        long x = n*m;
        long gcd = gcd(x, k);
        x /= gcd;
        k /= gcd;
        if(k == 1) {
            x *= 2;
        }
        if(k > 2) {
            out.println("NO");
        } else {
            out.println("YES");
            out.println("0 0");
            if(n < m) {
                for(long i = (x+m-1)/m; i*i <= x; i++) {
                    if(x%i == 0) {
                        out.println(i + " 0");
                        out.println("0 " + x/i);
                        break;
                    }
                }
            } else {
                for(long i = (x+n-1)/n; i*i <= x; i++) {
                    if(x%i == 0) {
                        out.println(x/i + " 0");
                        out.println("0 " + i);
                        break;
                    }
                }
            }
        }
        f.close();
        out.close();
    }
}