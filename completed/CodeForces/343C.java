import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        //PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("milkvisits.out")));
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        StringTokenizer st = new StringTokenizer(f.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(f.readLine());
        long[] h = new long[n];
        for(int i = 0; i < n; i++) {
            h[i] = Long.parseLong(st.nextToken());
        }
        st = new StringTokenizer(f.readLine());
        long[] p = new long[m];
        for(int i = 0; i < m; i++) {
            p[i] = Long.parseLong(st.nextToken());
        }
        long low = 0;
        long high = 1000000000000L;
        long ans = high;
        while(low <= high) {
            long mid = (low+high)/2;
            int i = 0;
            int j = 0;
            while(i < n && j < m) {
                if(p[j] >= h[i]) {
                    while(j < m && p[j] <= h[i]+mid) {
                        j++;
                    }
                } else {
                    if(p[j] < h[i]-mid) {
                        break;
                    }
                    long d = Math.max((mid-(h[i]-p[j]))/2, mid-2*(h[i]-p[j]));
                    while(j < m && p[j] <= h[i]+d) {
                        j++;
                    }
                }
                i++;
            }
            if(j == m) {
                high = mid-1;
                ans = mid;
            } else {
                low = mid+1;
            }
        }
        out.println(ans);
        f.close();
        out.close();
    }
}
