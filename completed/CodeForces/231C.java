import java.io.*;
import java.util.*;

public class Main {
    private static int n;
    private static int k;
    private static long[] a;
    private static long[] p;
    private static int isValid(int size) {
        for(int i = 0; i <= n-size; i++) {
            if(size*a[i+size-1]-(p[i+size]-p[i]) <= k) {
                return (int) a[i+size-1];
            }
        }
        return Integer.MAX_VALUE;
    }
    public static void main(String[] args) throws IOException {
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        StringTokenizer st = new StringTokenizer(f.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(f.readLine());
        a = new long[n];
        for(int i = 0; i < n; i++) {
            a[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(a);
        p = new long[n+1];
        for(int i = 1; i <= n; i++) {
            p[i] = p[i-1]+a[i-1];
        }
        int low = 1;
        int high = n;
        int size = 0;
        int ans = Integer.MAX_VALUE;
        while(low <= high) {
            int mid = (low+high)/2;
            int temp = isValid(mid);
            if(temp < Integer.MAX_VALUE) {
                low = mid+1;
                size = mid;
                ans = temp;
            } else {
                high = mid-1;
            }
        }
        out.println(size + " " + ans);
        f.close();
        out.close();
    }
}