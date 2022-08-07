import java.io.*;
import java.math.BigInteger;
import java.util.*;

public class Main {
    private static final int MOD = 1000000007;
    private static int add(long a, long b) { return (int) (((a+MOD)%MOD+(b+MOD)%MOD)%MOD); }
    private static char[] arr;
    private static int d;
    private static long[][][][] dp;
    private static long validate(int state) {
        return state == 0 ? 1 : 0;
    }
    private static int update(int state, int change) {
        return (state*10+change)%dp[0].length;
    }
    private static long dfs(int i, int j, boolean pos, boolean leading, boolean flag) {
        if(i < 0) {
            return validate(j);
        }
        if(!flag && dp[i][j][pos ? 0 : 1][leading ? 0 : 1] != -1) {
            return dp[i][j][pos ? 0 : 1][leading ? 0 : 1];
        }
        char l = flag ? arr[i] : '9';
        long ans = 0;
        for(char k = '0'; k <= l; k++) {
            if((!leading || k > '0') && (pos && k-'0' != d || !pos && k-'0' == d)) {
                continue;
            }
            ans = add(ans, dfs(i-1, update(j, k-'0'), pos == (leading && k == '0'), leading && k == '0', flag && k == l));
        }
        if(!flag) {
            dp[i][j][pos ? 0 : 1][leading ? 0 : 1] = ans;
        }
        return ans;
    }
    private static long query(String s) {
        arr = s.toCharArray();
        for(int i = 0; i < arr.length/2; i++) {
            char temp = arr[i];
            arr[i] = arr[arr.length-i-1];
            arr[arr.length-i-1] = temp;
        }
        return dfs(arr.length-1, 0, false, true, true);
    }
    private static void init(int n, int m) {
        dp = new long[n][m][2][2];
        for(long[][][] i: dp) {
            for(long[][] j: i) {
                for(long[] k: j) {
                    Arrays.fill(k, -1);
                }
            }
        }
    }
    public static void main(String[] args) throws IOException {
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        //PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("milkvisits.out")));
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        StringTokenizer st = new StringTokenizer(f.readLine());
        int m = Integer.parseInt(st.nextToken());
        d = Integer.parseInt(st.nextToken());
        String a = new BigInteger(f.readLine()).subtract(BigInteger.ONE).toString();
        String b = f.readLine();
        init(Math.max(a.length(), b.length()), m);
        out.println(query(b)-query(a));
        f.close();
        out.close();
    }
}