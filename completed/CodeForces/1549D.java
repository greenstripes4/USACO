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
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        int t = Integer.parseInt(f.readLine());
        while(t-- > 0) {
            int n = Integer.parseInt(f.readLine());
            StringTokenizer st = new StringTokenizer(f.readLine());
            long[] a = new long[n];
            for(int i = 0; i < n; i++) {
                a[i] = Long.parseLong(st.nextToken());
            }
            if(n == 1) {
                out.println(1);
                continue;
            }
            int i = 0;
            int j = 1;
            int ans = 1;
            long gcd = Math.abs(a[0]-a[1]);
            while(j < n) {
                if(gcd > 1) {
                    ans = Math.max(ans, j-i+1);
                    if(j == n-1) {
                        break;
                    }
                    gcd = gcd(gcd, Math.abs(a[j]-a[++j]));
                } else {
                    int k = j-1;
                    long temp = Math.abs(a[j]-a[k]);
                    long temp2 = temp;
                    while(temp > 1) {
                        temp2 = temp;
                        temp = gcd(temp, Math.abs(a[k]-a[--k]));
                    }
                    i = k+1;
                    gcd = temp2;
                    while(j < n-1 && gcd == 1) {
                        i++;
                        j++;
                        gcd = Math.abs(a[i]-a[j]);
                    }
                    if(j == n-1 && gcd == 1) {
                        break;
                    }
                }
            }
            out.println(ans);
        }
        f.close();
        out.close();
    }
}