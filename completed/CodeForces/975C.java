import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        StringTokenizer st = new StringTokenizer(f.readLine());
        int n = Integer.parseInt(st.nextToken());
        int q = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(f.readLine());
        long[] a = new long[n];
        for(int i = 0; i < n; i++) {
            a[i] = Integer.parseInt(st.nextToken());
        }
        for(int i = 1; i < n; i++) {
            a[i] += a[i-1];
        }
        st = new StringTokenizer(f.readLine());
        long cur = 0;
        for(int i = 0; i < q; i++) {
            cur += Long.parseLong(st.nextToken());
            int low = 0;
            int high = n-1;
            int ans = n;
            while(low <= high) {
                int mid = (low+high)/2;
                if(a[mid] > cur) {
                    high = mid-1;
                    ans = mid;
                } else {
                    low = mid+1;
                }
            }
            if(ans == n) {
                out.println(n);
                cur = 0;
            } else {
                out.println(n-ans);
            }
        }
        f.close();
        out.close();
    }
}