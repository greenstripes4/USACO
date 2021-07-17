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
        //Scanner f = new Scanner(new File("uva.in"));
        //Scanner f = new Scanner(System.in);
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        int t = Integer.parseInt(f.readLine());
        while(t-- > 0) {
            long n = Long.parseLong(f.readLine());
            long ans = 0;
            for(int i = 2; i < 100; i++) {
                long lcm = 1;
                for(int j = 2; j < i; j++) {
                    lcm = lcm*j/gcd(lcm, j);
                }
                if(lcm > n) {
                    break;
                }
                long lcm2 = lcm*i/gcd(lcm, i);
                ans += i*(n/lcm-n/lcm2);
                ans %= 1000000007;
            }
            out.println(ans);
        }
        f.close();
        out.close();
    }
}