import java.io.*;
import java.util.*;

public class Main {
    private static int MOD;
    private static int[] linearSieve;
    private static ArrayList<Integer> compressedPrimes;
    private static int add(long a, long b) { return (int) (((a+MOD)%MOD+(b+MOD)%MOD)%MOD); }
    private static int multiply(long a, long b) {
        return (int) (((a%MOD)*(b%MOD))%MOD);
    }
    private static void calculateLinearSieve() {
        compressedPrimes = new ArrayList<>();
        linearSieve[0] = 1;
        linearSieve[1] = 1;
        for(int i = 2; i < linearSieve.length; i++) {
            if(linearSieve[i] == 0) {
                linearSieve[i] = i;
                compressedPrimes.add(i);
            }
            for(int j: compressedPrimes) {
                if(i*j >= linearSieve.length) {
                    break;
                }
                linearSieve[i*j] = j;
                if(i%j == 0) {
                    break;
                }
            }
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader f = new BufferedReader(new FileReader("exercise.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("exercise.out")));
        //BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        //PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        StringTokenizer st = new StringTokenizer(f.readLine());
        int N = Integer.parseInt(st.nextToken());
        MOD = Integer.parseInt(st.nextToken());
        linearSieve = new int[N+1];
        calculateLinearSieve();
        int[][] dp = new int[N+1][compressedPrimes.size()+1];
        for(int i = 0; i <= N; i++) {
            dp[i][0] = 1;
            for(int j = 1; j <= compressedPrimes.size(); j++) {
                dp[i][j] = dp[i][j-1];
                int p = compressedPrimes.get(j-1);
                while(p <= i) {
                    dp[i][j] = add(dp[i][j], multiply(p, dp[i-p][j-1]));
                    p = multiply(p, compressedPrimes.get(j-1));
                }
            }
        }
        out.println(dp[N][compressedPrimes.size()]);
        f.close();
        out.close();
    }
}