import java.io.*;
import java.util.*;

public class Main {
    private static final int MOD = 1000000007;
    private static int add(long a, long b) { return (int) (((a+MOD)%MOD+(b+MOD)%MOD)%MOD); }
    private static char[] arr;
    private static long[][] dp;
    private static int validate(int state) {
        return -1;
    }
    private static int update(int state, int change) {
        return -1;
    }
    private static long dfs(int i, int j, boolean flag) {
        if(i < 0) {
            return validate(j);
        }
        if(!flag && dp[i][j] != -1) {
            return dp[i][j];
        }
        char l = flag ? arr[i] : '9';
        long ans = 0;
        for(char k = '0'; k <= l; k++) {
            ans = add(ans, dfs(i-1, update(j, k-'0'), flag && k == l));
        }
        if(!flag) {
            dp[i][j] = ans;
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
        return dfs(arr.length-1, 0, true);
    }
    private static void init(int n, int m) {
        dp = new long[n][m];
        for(long[] i: dp) {
            Arrays.fill(i, -1);
        }
    }
    public static void main(String[] args) throws IOException {
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        //PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("milkvisits.out")));
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        f.close();
        out.close();
    }
}