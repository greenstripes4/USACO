import java.io.*;
import java.math.BigInteger;
import java.util.*;

public class Main {
    private static char[] arr;
    private static long[][][][] dp;
    private static long validate(int state, int b) {
        for(int i = 0; i < b; i++) {
            if((state&(1 << i)) > 0) {
                return 0;
            }
        }
        return 1;
    }
    private static int update(int state, int change) {
        return state^(1 << change);
    }
    private static long dfs(int i, int j, int b, boolean leading, boolean flag) {
        if(i < 0) {
            return validate(j, b);
        }
        if(!flag && dp[i][j][b][leading ? 0 : 1] != -1) {
            return dp[i][j][b][leading ? 0 : 1];
        }
        char l = flag ? arr[i] : (char) (b+'0'-1);
        long ans = 0;
        for(char k = '0'; k <= l; k++) {
            ans += dfs(i-1, leading && k == '0' ? j : update(j, k-'0'), b, leading && k == '0', flag && k == l);
        }
        if(!flag) {
            dp[i][j][b][leading ? 0 : 1] = ans;
        }
        return ans;
    }
    private static String convert(String s, int b) {
        long val = Long.parseLong(s);
        StringBuilder res = new StringBuilder();
        while(val > 0) {
            res.append(val%b);
            val /= b;
        }
        return res.reverse().toString();
    }
    private static long query(String s, int b) {
        arr = convert(s, b).toCharArray();
        for(int i = 0; i < arr.length/2; i++) {
            char temp = arr[i];
            arr[i] = arr[arr.length-i-1];
            arr[arr.length-i-1] = temp;
        }
        return dfs(arr.length-1, 0, b, true, true);
    }
    private static void init(int n, int m, int l) {
        dp = new long[n][m][l][2];
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
        init(64, 1024, 11);
        int q = Integer.parseInt(f.readLine());
        while(q-- > 0) {
            StringTokenizer st = new StringTokenizer(f.readLine());
            int b = Integer.parseInt(st.nextToken());
            long l = Long.parseLong(st.nextToken());
            long r = Long.parseLong(st.nextToken());
            out.println(query(Long.toString(r), b)-query(Long.toString(l-1), b));
        }
        f.close();
        out.close();
    }
}