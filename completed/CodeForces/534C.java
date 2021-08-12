import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        StringTokenizer st = new StringTokenizer(f.readLine());
        int n = Integer.parseInt(st.nextToken());
        long A = Long.parseLong(st.nextToken());
        st = new StringTokenizer(f.readLine());
        int[] d = new int[n];
        long sum = 0;
        for(int i = 0; i < n; i++) {
            d[i] = Integer.parseInt(st.nextToken());
            sum += d[i];
        }
        long[] res = new long[n];
        for(int i = 0; i < n; i++) {
            long min = Math.max(1, A-sum+d[i]);
            long max = Math.min(d[i], A-n+1);
            res[i] = d[i]-(max-min+1);
        }
        out.print(res[0]);
        for(int i = 1; i < n; i++) {
            out.print(" " + res[i]);
        }
        out.println();
        f.close();
        out.close();
    }
}
