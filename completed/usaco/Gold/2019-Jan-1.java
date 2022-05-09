import java.io.*;
import java.util.*;

public class Main {
    private static final int MOD = 1000000007;
    private static int add(long a, long b) { return (int) (((a+MOD)%MOD+(b+MOD)%MOD)%MOD); }
    private static int multiply(long a, long b) {
        return (int) (((a%MOD)*(b%MOD))%MOD);
    }
    private static int power(long a, long b) {
        long c = 1;
        while(b > 0) {
            if((b&1) > 0) {
                c = multiply(c, a);
            }
            a = multiply(a, a);
            b >>= 1;
        }
        return (int) c;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader f = new BufferedReader(new FileReader("poetry.in"));
        //BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("poetry.out")));
        StringTokenizer st = new StringTokenizer(f.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        ArrayList<ArrayList<Integer>> classes = new ArrayList<>(N);
        for(int i = 0; i < N; i++) {
            classes.add(new ArrayList<>());
        }
        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(f.readLine());
            int s = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken())-1;
            classes.get(c).add(s);
        }
        long[] dp = new long[K];
        dp[0] = 1;
        for(int i = 1; i < K; i++) {
            for(ArrayList<Integer> j: classes) {
                for(int k: j) {
                    if(k <= i) {
                        dp[i] = add(dp[i], dp[i-k]);
                    }
                }
            }
        }
        long[] cnt = new long[N];
        for(int i = 0; i < N; i++) {
            for(int j: classes.get(i)) {
                if(j <= K) {
                    cnt[i] = add(cnt[i], dp[K-j]);
                }
            }
        }
        int[] occ = new int[26];
        for(int i = 0; i < M; i++) {
            occ[f.readLine().charAt(0)-'A']++;
        }
        long ans = 1;
        for(int i = 0; i < 26; i++) {
            if(occ[i] == 0) {
                continue;
            }
            long sum = 0;
            for(int j = 0; j < N; j++) {
                sum = add(sum, power(cnt[j], occ[i]));
            }
            ans = multiply(ans, sum);
        }
        out.println(ans);
        f.close();
        out.close();
    }
}