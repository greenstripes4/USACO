import java.io.*;
import java.util.*;

public class Main {
    private static char[] digits;
    private static long[][][] dp;
    private static long dfs(int i, int z, int o, boolean flag, boolean limit) {
        if(i == digits.length) {
            return z >= o ? 1 : 0;
        }
        if(!limit && dp[i][z][o] >= 0) {
            return dp[i][z][o];
        }
        long ans = 0;
        for(char j = '0'; j <= (limit ? digits[i] : '1'); j++) {
            if(!flag && j == '0') {
                ans += dfs(i+1, 0, 0, false, limit && j == digits[i]);
            } else {
                ans += dfs(i+1, z+(j == '0' ? 1 : 0), o+(j == '1' ? 1 : 0), true, limit && j == digits[i]);
            }
        }
        if(!limit) {
            dp[i][z][o] = ans;
        }
        return ans;
    }
    private static long query(long n) {
        digits = Long.toBinaryString(n).toCharArray();
        dp = new long[digits.length][digits.length][digits.length];
        for(long[][] i: dp) {
            for(long[] j: i) {
                Arrays.fill(j, -1);
            }
        }
        return dfs(0, 0, 0, false, true);
    }
    public static void main(String[] args) throws IOException {
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        //PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("milkvisits.out")));
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        StringTokenizer st = new StringTokenizer(f.readLine());
        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());
        out.println(query(end)-query(start-1));
        f.close();
        out.close();
    }
}