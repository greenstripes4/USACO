import java.io.*;
import java.util.*;

public class Main {
    private static int n;
    private static int[] segmentTree;
    private static void update(int k, int u) {
        k += n-1;
        segmentTree[k] += u;
        while(k > 1) {
            segmentTree[k >> 1] = Math.max(segmentTree[k], segmentTree[k^1]);
            k >>= 1;
        }
    }
    private static int query(int b) {
        int a = n;
        b += n-1;
        int max = Integer.MIN_VALUE;
        while(a <= b) {
            if(a%2 == 1) {
                max = Math.max(max, segmentTree[a++]);
            }
            if(b%2 == 0) {
                max = Math.max(max, segmentTree[b--]);
            }
            a >>= 1;
            b >>= 1;
        }
        return max;
    }
    private static int binarySearch(int tar) {
        int low = 1;
        int high = n;
        int ans = 0;
        while(low <= high) {
            int mid = (low+high)/2;
            if(query(mid) >= tar) {
                ans = mid;
                high = mid-1;
            } else {
                low = mid+1;
            }
        }
        return ans;
    }
    public static void main(String[] args) throws IOException{
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        StringTokenizer st = new StringTokenizer(f.readLine());
        n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(f.readLine());
        segmentTree = new int[2*n];
        for(int i = n; i < 2*n; i++) {
            segmentTree[i] = Integer.parseInt(st.nextToken());
        }
        for(int i = n-1; i > 0; i--) {
            segmentTree[i] = Math.max(segmentTree[i << 1], segmentTree[i << 1 | 1]);
        }
        st = new StringTokenizer(f.readLine());
        for(int i = 0; i < m; i++) {
            if(i > 0) {
                out.print(" ");
            }
            int r = Integer.parseInt(st.nextToken());
            int ans = binarySearch(r);
            out.print(ans);
            if(ans > 0) {
                update(ans, -r);
            }
        }
        out.println();
        f.close();
        out.close();
    }
}