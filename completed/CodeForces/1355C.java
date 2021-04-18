import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        StringTokenizer st = new StringTokenizer(f.readLine());
        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());
        int D = Integer.parseInt(st.nextToken());
        long[] prefixSums = new long[10000000];
        for(int i = A; i <= B; i++) {
            prefixSums[i+B]++;
            prefixSums[i+C+1]--;
        }
        for(int i = 1; i < 10000000; i++) {
            prefixSums[i] += prefixSums[i-1];
        }
        for(int i = 1; i < 10000000; i++) {
            prefixSums[i] += prefixSums[i-1];
        }
        long ans = 0;
        for(int i = C; i <= D; i++) {
            ans += prefixSums[9999999]-prefixSums[i];
        }
        out.println(ans);
        f.close();
        out.close();
    }
}