import java.io.*;
import java.util.*;

public class Main {
    private static long power(long a, long b) {
        long c = 1;
        while(b > 0) {
            if((b&1) > 0) {
                c *= a;
            }
            a *= a;
            b >>= 1;
        }
        return c;
    }
    private static int log(long n) {
        int count = 0;
        while(n > 1) {
            n /= 2;
            count++;
        }
        return count;
    }
    private static int solve(long i, long n, long m) {
        long mid = (m+1)/2;
        if(i == mid) {
            return (int) (n%2);
        }
        if(i < mid) {
            return solve(i, n/2, m/2);
        }
        return solve(i-mid, n/2, m/2);
    }
    public static void main(String[] args) throws IOException{
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        StringTokenizer st = new StringTokenizer(f.readLine());
        long n = Long.parseLong(st.nextToken());
        long l = Long.parseLong(st.nextToken());
        long r = Long.parseLong(st.nextToken());
        long m = power(2, log(n)+1)-1;
        int count = 0;
        for(long i = l; i <= r; i++) {
            count += solve(i, n, m);
        }
        out.println(count);
        f.close();
        out.close();
    }
}