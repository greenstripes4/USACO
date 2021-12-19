import java.io.*;
import java.lang.reflect.Array;
import java.util.*;

public class Main {
    private static long sum(long a, long b) {
        if(a > b) {
            long c = a;
            a = b;
            b = c;
        }
        return (a+b)*(b-a+1)/2;
    }
    public static void main(String[] args) throws IOException{
        //BufferedReader f = new BufferedReader(new FileReader("cowjump.in"));
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        //PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("cowjump.out")));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        int t = Integer.parseInt(f.readLine());
        while(t-- > 0) {
            StringTokenizer st = new StringTokenizer(f.readLine());
            int n = Integer.parseInt(st.nextToken());
            long k = Long.parseLong(st.nextToken());
            int low = 0;
            int high = 2*n-2;
            int ans = 0;
            while(low <= high) {
                int mid = low+(high-low)/2;
                long cur = sum(1, Math.min(mid, n));
                if(mid > n) {
                    cur += sum(n-1, 2L*n-mid);
                }
                if(cur < k) {
                    low = mid+1;
                    ans = mid;
                } else {
                    high = mid-1;
                }
            }
            out.println(ans+1);
        }
        f.close();
        out.close();
    }
}
