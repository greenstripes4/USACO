import java.io.*;
import java.util.*;

public class Main {
    private static int[] modifiedSieve;
    private static void calculateSieve() {
        modifiedSieve[0] = Integer.MAX_VALUE;
        for (int i = 1; i < modifiedSieve.length; i++) {
            for (int j = i; j < modifiedSieve.length; j += i) {
                modifiedSieve[j]++;
            }
        }
    }
    public static void main(String[] args) throws IOException{
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        int n = Integer.parseInt(f.readLine());
        modifiedSieve = new int[n+1];
        calculateSieve();
        int[] dp = new int[n+1];
        dp[0] = 1;
        dp[1] = 1;
        int sum = 1;
        for(int i = 2; i <= n; i++) {
            dp[i] = (sum+modifiedSieve[i])%998244353;
            sum = (sum+dp[i])%998244353;
        }
        out.println(dp[n]);
        f.close();
        out.close();
    }
}