import java.io.*;
import java.util.*;

public class Main {
    private static boolean inRange(long x, long k) {
        return x >= 0 && x <= k;
    }
    private static boolean isValid(long d1, long d2, long n, long k) {
        if(n%3 != 0 || (k-d1+d2)%3 != 0) {
            return false;
        }
        long b = (k-d1+d2)/3;
        long a = b+d1;
        long c = b-d2;
        if(inRange(a, k) && inRange(b, k) && inRange(c, k)) {
            return a <= n/3 && b <= n/3 && c <= n/3;
        }
        return false;
    }
    public static void main(String[] args) throws IOException {
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        int t = Integer.parseInt(f.readLine());
        while(t-- > 0) {
            StringTokenizer st = new StringTokenizer(f.readLine());
            long n = Long.parseLong(st.nextToken());
            long k = Long.parseLong(st.nextToken());
            long d1 = Long.parseLong(st.nextToken());
            long d2 = Long.parseLong(st.nextToken());
            boolean temp1 = isValid(d1, d2, n, k);
            boolean temp2 = isValid(d1, -d2, n, k);
            boolean temp3 = isValid(-d1, d2, n, k);
            boolean temp4 = isValid(-d1, -d2, n, k);
            if(temp1 || temp2 || temp3 || temp4) {
                out.println("yes");
            } else {
                out.println("no");
            }
        }
        f.close();
        out.close();
    }
}
