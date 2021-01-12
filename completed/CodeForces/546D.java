import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        int lim = 5000000;
        long[] factors = new long[lim+1];
        factors[1] = 1;
        factors[2] = 1;
        for(int i = 2; i <= lim; i++) {
            if(factors[i] <= 1) {
                factors[i] = 1;
                for(int j = 2; i*j <= lim; j++) {
                    factors[i*j] = factors[j]+1;
                }
            }
        }
        long[] prefixSum = new long[lim+1];
        prefixSum[0] = factors[0];
        for(int i = 1; i <= lim; i++) {
            prefixSum[i] = prefixSum[i-1]+factors[i];
        }
        int t = Integer.parseInt(f.readLine());
        for(int i = 0; i < t; i++) {
            StringTokenizer st = new StringTokenizer(f.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            out.println(prefixSum[a]-prefixSum[b]);
        }
        f.close();
        out.close();
    }
}
