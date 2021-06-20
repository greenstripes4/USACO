import java.io.*;
import java.util.*;

public class Main{
    private static int[] p;
    private static int x;
    private static int a;
    private static int y;
    private static int b;
    private static long k;
    private static boolean isValid(int t) {
        int idx = p.length-1;
        long ans = 0;
        for(int i = a; i <= t; i += a) {
            if(i%b == 0) {
                ans += p[idx--]/100*(x+y);
            }
        }
        if(x > y) {
            for(int i = a; i <= t; i += a) {
                if(i%b > 0) {
                    ans += p[idx--]/100*x;
                }
            }
            for(int i = b; i <= t; i += b) {
                if(i%a > 0) {
                    ans += p[idx--]/100*y;
                }
            }
        } else {
            for(int i = b; i <= t; i += b) {
                if(i%a > 0) {
                    ans += p[idx--]/100*y;
                }
            }
            for(int i = a; i <= t; i += a) {
                if(i%b > 0) {
                    ans += p[idx--]/100*x;
                }
            }
        }
        return ans >= k;
    }
    public static void main(String[] args) throws IOException{
        //Scanner f = new Scanner(new File("uva.in"));
        Scanner f = new Scanner(System.in);
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        //BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        int q = f.nextInt();
        while(q-- > 0) {
            int n = f.nextInt();
            p = new int[n];
            for(int i = 0; i < n; i++) {
                p[i] = f.nextInt();
            }
            x = f.nextInt();
            a = f.nextInt();
            y = f.nextInt();
            b = f.nextInt();
            k = f.nextLong();
            Arrays.sort(p);
            int low = 0;
            int high = n;
            int ans = -1;
            while(low <= high) {
                int mid = (low+high)/2;
                if(isValid(mid)) {
                    high = mid-1;
                    ans = mid;
                } else {
                    low = mid+1;
                }
            }
            out.println(ans);
        }
        f.close();
        out.close();
    }
}