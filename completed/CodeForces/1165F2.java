import java.io.*;
import java.util.*;

public class Main {
    private static int[] k;
    private static int[][] o;
    private static boolean isValid(long d) {
        int[][] discounts = new int[k.length][2];
        for(int i = 0; i < k.length; i++) {
            discounts[i][0] = Integer.MAX_VALUE;
            discounts[i][1] = i;
        }
        for(int i = 0; i < o.length && o[i][0] <= d; i++) {
            discounts[o[i][1]][0] = o[i][0];
        }
        Arrays.sort(discounts, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0]-o2[0];
            }
        });
        int[] left = k.clone();
        long cur = 0;
        int last = 0;
        for(int[] i: discounts) {
            if(i[0] == Integer.MAX_VALUE) {
                break;
            }
            cur += i[0]-last;
            int max = (int) Math.min(left[i[1]], cur);
            cur -= max;
            left[i[1]] -= max;
            last = i[0];
        }
        cur += d-last;
        for(int i: left) {
            cur -= i*2L;
        }
        return cur >= 0;
    }
    public static void main(String[] args) throws IOException {
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        StringTokenizer st = new StringTokenizer(f.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(f.readLine());
        long low = 0;
        k = new int[n];
        for(int i = 0; i < n; i++) {
            k[i] = Integer.parseInt(st.nextToken());
            low += k[i];
        }
        o = new int[m][2];
        for(int i = 0; i < m; i++) {
            st = new StringTokenizer(f.readLine());
            o[i][0] = Integer.parseInt(st.nextToken());
            o[i][1] = Integer.parseInt(st.nextToken())-1;
        }
        Arrays.sort(o, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0]-o2[0];
            }
        });
        long high = low*2;
        long ans = high;
        while(low <= high) {
            long mid = (low+high)/2;
            if(isValid(mid)) {
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