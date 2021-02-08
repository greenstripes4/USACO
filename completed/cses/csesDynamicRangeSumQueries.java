import java.io.*;
import java.util.*;

public class Main {
    private static long[] BIT;
    private static void update(int index, long add) {
        while(index < BIT.length) {
            BIT[index] += add;
            index += index&-index;
        }
    }
    private static long query(int index) {
        long sum = 0;
        while(index > 0) {
            sum += BIT[index];
            index -= index&-index;
        }
        return sum;
    }
    public static void main(String[] args) throws IOException{
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        StringTokenizer st = new StringTokenizer(f.readLine());
        int n = Integer.parseInt(st.nextToken());
        int q = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(f.readLine());
        long[] x = new long[n+1];
        BIT = new long[n+1];
        for(int i = 1; i <= n; i++) {
            x[i] = Integer.parseInt(st.nextToken());
            update(i, x[i]);
        }
        for(int i = 0; i < q; i++) {
            st = new StringTokenizer(f.readLine());
            int type = Integer.parseInt(st.nextToken());
            if(type == 1) {
                int k = Integer.parseInt(st.nextToken());
                long u = Integer.parseInt(st.nextToken());
                update(k, u-x[k]);
                x[k] = u;
            } else {
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                out.println(query(b)-query(a-1));
            }
        }
        f.close();
        out.close();
    }
}