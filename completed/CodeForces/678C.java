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
        StringTokenizer st = new StringTokenizer(f.readLine());
        long n = Integer.parseInt(st.nextToken());
        long a = Integer.parseInt(st.nextToken());
        long b = Integer.parseInt(st.nextToken());
        long p = Integer.parseInt(st.nextToken());
        long q = Integer.parseInt(st.nextToken());
        long lcm = a*b/gcd(a, b);
        out.println((n/a-n/lcm)*p+(n/b-n/lcm)*q+n/lcm*Math.max(p, q));
        f.close();
        out.close();
    }
}