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
        int b = Integer.parseInt(st.nextToken());
        Integer[] idx = new Integer[n];
        int[] x = new int[n];
        int[] k = new int[n];
        int[][] arr = new int[n][];
        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(f.readLine());
            idx[i] = i;
            x[i] = Integer.parseInt(st.nextToken());
            k[i] = Integer.parseInt(st.nextToken());
            arr[i] = new int[Integer.parseInt(st.nextToken())];
            st = new StringTokenizer(f.readLine());
            for(int j = 0; j < arr[i].length; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken())-1;
            }
        }
        Arrays.sort(idx, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return k[o1]-k[o2];
            }
        });
        long[] dp = new long[1 << m];
        Arrays.fill(dp, Long.MAX_VALUE/2);
        dp[0] = 0;
        long min = Long.MAX_VALUE/2;
        for(int j = 0; j < n; j++) {
            for(int i = 1; i < 1 << m; i++) {
                int left = i;
                for(int l: arr[idx[j]]) {
                    if((left&(1 << l)) > 0) {
                        left ^= 1 << l;
                    }
                }
                dp[i] = Math.min(dp[i], dp[left]+x[idx[j]]);
            }
            min = Math.min(min, dp[(1 << m)-1]+(long) k[idx[j]]*b);
        }
        out.println(min == Long.MAX_VALUE/2 ? -1 : min);
        f.close();
        out.close();
    }
}