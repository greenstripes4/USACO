import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        StringTokenizer st = new StringTokenizer(f.readLine());
        int n = Integer.parseInt(st.nextToken());
        int q = Integer.parseInt(st.nextToken());
        long[] prefixSums = new long[n+1];
        st = new StringTokenizer(f.readLine());
        for(int i = 1; i <= n; i++) {
            prefixSums[i] = Integer.parseInt(st.nextToken());
        }
        for(int i = 2; i <= n; i++) {
            prefixSums[i] += prefixSums[i-1];
        }
        for(int i = 0; i < q; i++) {
            st = new StringTokenizer(f.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            out.println(prefixSums[b]-prefixSums[a-1]);
        }
        f.close();
        out.close();
    }
}