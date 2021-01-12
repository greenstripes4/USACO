import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        int n = Integer.parseInt(f.readLine());
        long[] occurances = new long[100001];
        StringTokenizer st = new StringTokenizer(f.readLine());
        for(int i = 0; i < n; i++) {
          occurances[Integer.parseInt(st.nextToken())]++;
        }
        long[] dp = new long[100001];
        dp[1] = occurances[1];
        for(int i = 2; i <= 100000; i++) {
            dp[i] = Math.max(dp[i-1], dp[i-2]+occurances[i]*i);
        }
        out.println(dp[100000]);
        f.close();
        out.close();
    }
}
