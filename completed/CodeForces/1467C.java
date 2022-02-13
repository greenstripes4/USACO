import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        //PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("cowjump.out")));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        StringTokenizer st = new StringTokenizer(f.readLine());
        int[] n = new int[3];
        n[0] = Integer.parseInt(st.nextToken());
        n[1] = Integer.parseInt(st.nextToken());
        n[2] = Integer.parseInt(st.nextToken());
        int[][] a = new int[3][];
        long[] sum = new long[3];
        int[] min = new int[3];
        Arrays.fill(min, Integer.MAX_VALUE);
        long total = 0;
        for(int i = 0; i < 3; i++) {
            st = new StringTokenizer(f.readLine());
            a[i] = new int[n[i]];
            for(int j = 0; j < n[i]; j++) {
                a[i][j] = Integer.parseInt(st.nextToken());
                sum[i] += a[i][j];
                min[i] = Math.min(min[i], a[i][j]);
                total += a[i][j];
            }
        }
        long max = Long.MIN_VALUE;
        for(int i = 0; i < 3; i++) {
            for(int j = 0; j < n[i]; j++) {
                long p = sum[i]-a[i][j];
                for(int k = 0; k < 3; k++) {
                    if(k != i) {
                        p = Math.min(p, min[k]);
                    }
                }
                max = Math.max(max, total-2*(a[i][j]+p));
            }
        }
        out.println(max);
        f.close();
        out.close();
    }
}
