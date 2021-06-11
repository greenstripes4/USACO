import java.io.*;
import java.util.*;

public class Main {
    private static HashSet<Long> sums;
    private static int[] arr;
    private static int binarySearch(int l, int r, int t) {
        int ans = -1;
        while(l <= r) {
            int m = (l+r)/2;
            if(arr[m] <= t) {
                l = m+1;
                ans = m;
            } else {
                r = m-1;
            }
        }
        return ans;
    }
    private static long sum(int l, int r) {
        long ans = 0;
        for(int i = l; i <= r; i++) {
            ans += arr[i];
        }
        return ans;
    }
    private static void build(int l, int r) {
        if(l > r) {
            return;
        }
        sums.add(sum(l, r));
        int m = binarySearch(l, r, (arr[l]+arr[r])/2);
        if(m == r) {
            return;
        }
        build(l, m);
        build(m+1, r);
    }
    public static void main(String[] args) throws IOException {
        //Scanner f = new Scanner(new File("uva.in"));
        //Scanner f = new Scanner(System.in);
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        int t = Integer.parseInt(f.readLine());
        while(t-- > 0) {
            StringTokenizer st = new StringTokenizer(f.readLine());
            int n = Integer.parseInt(st.nextToken());
            int q = Integer.parseInt(st.nextToken());
            st = new StringTokenizer(f.readLine());
            arr = new int[n];
            for(int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }
            Arrays.sort(arr);
            sums = new HashSet<>();
            build(0, n-1);
            for(int i = 0; i < q; i++) {
                long s = Integer.parseInt(f.readLine());
                out.println(sums.contains(s) ? "Yes" : "No");
            }
        }
        f.close();
        out.close();
    }
}