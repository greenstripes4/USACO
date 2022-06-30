import java.io.*;
import java.util.*;

public class Main {
    private static HashSet<Integer> primes;
    private static void getPrimeFactorization1(int x) {
        for(int p = 2; p*p <= x && x > 1; p++) {
            if(x%p == 0) {
                primes.add(p);
                while(x%p == 0) {
                    x /= p;
                }
            }
        }
        if(x > 1) {
            primes.add(x);
        }
    }
    public static void main(String[] args) throws IOException {
        //BufferedReader f = new BufferedReader(new FileReader("milkvisits.in"));
        //PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("milkvisits.out")));
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        StringTokenizer st = new StringTokenizer(f.readLine());
        int n = Integer.parseInt(st.nextToken());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(f.readLine());
        int[] arr = new int[n+1];
        for(int i = 1; i <= n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        primes = new HashSet<>();
        getPrimeFactorization1(arr[1]-1);
        getPrimeFactorization1(arr[1]);
        getPrimeFactorization1(arr[1]+1);
        getPrimeFactorization1(arr[n]-1);
        getPrimeFactorization1(arr[n]);
        getPrimeFactorization1(arr[n]+1);
        long min = Long.MAX_VALUE;
        for(int p: primes) {
            long[][] dp = new long[n+1][3];
            for(int i = 1; i <= n; i++) {
                Arrays.fill(dp[i], 2000000000000000L);
                if(arr[i]%p == 0) {
                    dp[i][0] = dp[i-1][0];
                    dp[i][2] = Math.min(dp[i-1][1], dp[i-1][2]);
                } else if(arr[i]%p == 1 || arr[i]%p == p-1) {
                    dp[i][0] = Math.min(dp[i][0], dp[i-1][0]+b);
                    dp[i][2] = Math.min(dp[i-1][1], dp[i-1][2])+b;
                }
                dp[i][1] = Math.min(dp[i-1][0], dp[i-1][1])+a;
            }
            min = Math.min(min, Math.min(dp[n][0], Math.min(dp[n][1], dp[n][2])));
        }
        out.println(min);
        f.close();
        out.close();
    }
}