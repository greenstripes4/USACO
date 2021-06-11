import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        //BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        //Scanner f = new Scanner(new File("uva.in"));
        Scanner f = new Scanner(System.in);
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        int t = f.nextInt();
        while(t-- > 0) {
            int n = f.nextInt();
            int[] S = new int[n];
            for(int i = 0; i < n; i++) {
                S[i] = f.nextInt();
            }
            long[] C = new long[n];
            long ans = 0;
            for(int i = 0; i < n; i++) {
                long cur = C[i];
                if(cur < S[i]-1) {
                    ans += S[i]-cur-1;
                    cur += S[i]-cur-1;
                }
                if(i+1 < n) {
                    C[i+1] += cur-S[i]+1;
                }
                for(int j = i+2; j < Math.min(n, i+S[i]+1); j++) {
                    C[j]++;
                }
            }
            out.println(ans);
        }
        f.close();
        out.close();
    }
}
