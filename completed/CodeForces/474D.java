import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        StringTokenizer st = new StringTokenizer(f.readLine());
        int t = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        long[] dp = new long[100001];
        for(int i = 0; i < k; i++) {
            dp[i] = 1;
        }
        for(int i = k; i <= 100000; i++) {
            dp[i] = (dp[i-k]+dp[i-1])%1000000007;
        }
        for(int i = 1; i <= 100000; i++) {
            dp[i] = dp[i-1]+dp[i];
        }
        for(int i = 0; i < t; i++) {
            st = new StringTokenizer(f.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            out.println((dp[b]-dp[a-1])%1000000007);
        }
        f.close();
        out.close();
    }
}
