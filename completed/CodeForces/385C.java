import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        int MAX = 10000000;
        int n = Integer.parseInt(f.readLine());
        int[] x = new int[n];
        int[] occ = new int[MAX+1];
        StringTokenizer st = new StringTokenizer(f.readLine());
        for(int i = 0; i < n; i++) {
            x[i] = Integer.parseInt(st.nextToken());
            occ[x[i]]++;
        }
        boolean[] sieve = new boolean[MAX+1];
        long[] prefixSum = new long[MAX+1];
        sieve[0] = true;
        sieve[1] = true;
        for(int i = 2; i <= MAX; i++) {
            if(!sieve[i]) {
                int sum = occ[i];
                for(int j = i+i; j <= MAX; j += i) {
                    sieve[j] = true;
                    sum += occ[j];
                }
                prefixSum[i] = sum;
            }
        }
        for(int i = 1; i <= MAX; i++) {
            prefixSum[i] += prefixSum[i-1];
        }
        int m = Integer.parseInt(f.readLine());
        for(int i = 0; i < m; i++) {
            st = new StringTokenizer(f.readLine());
            int l = Integer.parseInt(st.nextToken());
            int r = Integer.parseInt(st.nextToken());
            if(l > MAX) {
                out.println(0);
                continue;
            }
            if(r > MAX) {
                r = MAX;
            }
            out.println(prefixSum[r]-prefixSum[l-1]);
        }
        f.close();
        out.close();
    }
}
