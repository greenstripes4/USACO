import java.io.*;
import java.util.*;

public class Main {
    private static long binarySearch1(long[] arr, long tar) {
        int low = 0;
        int high = arr.length-1;
        long ans = -1;
        while(low <= high) {
            int mid = (low+high)/2;
            if(arr[mid] <= tar) {
                low = mid+1;
                ans = arr[mid];
            } else {
                high = mid-1;
            }
        }
        return ans;
    }
    private static long binarySearch2(long[] arr, long tar) {
        int low = 0;
        int high = arr.length-1;
        long ans = -1;
        while(low <= high) {
            int mid = (low+high)/2;
            if(arr[mid] >= tar) {
                high = mid-1;
                ans = arr[mid];
            } else {
                low = mid+1;
            }
        }
        return ans;
    }
    private static long solve(long[] a, long[] b, long[] c) {
        long min = Long.MAX_VALUE;
        for(long i: b) {
            long j = binarySearch1(a, i);
            long k = binarySearch2(c, i);
            if(j == -1 || k == -1) {
                continue;
            }
            min = Math.min(min, (i-j)*(i-j)+(k-i)*(k-i)+(k-j)*(k-j));
        }
        return min;
    }
    public static void main(String[] args) throws IOException{
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        int t = Integer.parseInt(f.readLine());
        for(int i = 0; i < t; i++) {
            StringTokenizer st = new StringTokenizer(f.readLine());
            int nr = Integer.parseInt(st.nextToken());
            int ng = Integer.parseInt(st.nextToken());
            int nb = Integer.parseInt(st.nextToken());
            long[] r = new long[nr];
            st = new StringTokenizer(f.readLine());
            for(int j = 0; j < nr; j++) {
                r[j] = Integer.parseInt(st.nextToken());
            }
            long[] g = new long[ng];
            st = new StringTokenizer(f.readLine());
            for(int j = 0; j < ng; j++) {
                g[j] = Integer.parseInt(st.nextToken());
            }
            long[] b = new long[nb];
            st = new StringTokenizer(f.readLine());
            for(int j = 0; j < nb; j++) {
                b[j] = Integer.parseInt(st.nextToken());
            }
            Arrays.sort(r);
            Arrays.sort(g);
            Arrays.sort(b);
            long[] solutions = {solve(r, g, b), solve(r, b, g), solve(g, r, b), solve(g, b, r), solve(b, r, g), solve(b, g, r)};
            long min = Long.MAX_VALUE;
            for(long j: solutions) {
                min = Math.min(min, j);
            }
            out.println(min);
        }
        f.close();
        out.close();
    }
}
