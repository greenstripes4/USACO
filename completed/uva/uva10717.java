import java.io.*;
import java.util.*;

public class Main {
    private static long gcd(long a, long b) {
        if(a == 0) {
            return b;
        }
        return gcd(b%a, a);
    }
    public static void main(String[] args) throws IOException{
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        while(true) {
            StringTokenizer st = new StringTokenizer(f.readLine());
            int N = Integer.parseInt(st.nextToken());
            int T = Integer.parseInt(st.nextToken());
            if(N == 0 && T == 0) {
                break;
            }
            long[] coins = new long[N];
            for(int i = 0; i < N; i++) {
                coins[i] = Integer.parseInt(f.readLine());
            }
            while(T-- > 0) {
                int target = Integer.parseInt(f.readLine());
                long lower = 0;
                long higher = Integer.MAX_VALUE;
                for(int i = 0; i < N; i++) {
                    for(int j = i+1; j < N; j++) {
                        for(int k = j+1; k < N; k++) {
                            for(int l = k+1; l < N; l++) {
                                long lcm = coins[i];
                                lcm = lcm*coins[j]/gcd(lcm, coins[j]);
                                lcm = lcm*coins[k]/gcd(lcm, coins[k]);
                                lcm = lcm*coins[l]/gcd(lcm, coins[l]);
                                lower = Math.max(lower, target/lcm*lcm);
                                higher = Math.min(higher, (target+lcm-1)/lcm*lcm);
                            }
                        }
                    }
                }
                out.println(lower + " " + higher);
            }
        }
        f.close();
        out.close();
    }
}