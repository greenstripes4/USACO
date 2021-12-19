import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        //PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("cowjump.out")));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        int t = Integer.parseInt(f.readLine());
        while(t-- > 0) {
            StringTokenizer st = new StringTokenizer(f.readLine());
            int n = Integer.parseInt(st.nextToken());
            long h = Long.parseLong(st.nextToken());
            st = new StringTokenizer(f.readLine());
            long[] a = new long[n];
            for(int i = 0; i < n; i++) {
                a[i] = Integer.parseInt(st.nextToken());
            }
            long low = 1;
            long high = 1000000000000000000L;
            long k = high;
            while(low <= high) {
                long mid = (low+high)/2;
                long sum = 0;
                long start = 0;
                long end = 0;
                for(int i = 0; i < n; i++) {
                    if(end < a[i]) {
                        sum += end-start;
                        start = a[i];
                    }
                    end = a[i]+mid;
                }
                sum += end-start;
                if(sum >= h) {
                    high = mid-1;
                    k = mid;
                } else {
                    low = mid+1;
                }
            }
            out.println(k);
        }
        f.close();
        out.close();
    }
}
