import java.io.*;
import java.math.BigInteger;
import java.util.*;

public class Main {
    private static char[] arr;
    private static long[][][] dp;
    private static int validate(int state, int set) {
        for(int i = 1; i < 10; i++) {
            if((set&(1 << i)) > 0 && state%i > 0) {
                return 0;
            }
        }
        return 1;
    }
    private static int update(int state, int change) {
        return (state*10+change)%2520;
    }
    private static long dfs(int i, int j, int m, boolean flag) {
        if(i < 0) {
            return validate(j, m);
        }
        if(!flag && dp[i][j][m] != -1) {
            return dp[i][j][m];
        }
        char l = flag ? arr[i] : '9';
        long ans = 0;
        for(char k = '0'; k <= l; k++) {
            ans += dfs(i-1, update(j, k-'0'), m|(1 << (k-'0')), flag && k == l);
        }
        if(!flag) {
            dp[i][j][m] = ans;
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
        return dfs(arr.length-1, 0, 0, true);
    }
    private static void init(int n, int m, int k) {
        dp = new long[n][m][k];
        for(long[][] i: dp) {
            for(long[] j: i) {
                Arrays.fill(j, -1);
            }
        }
    }
    public static void main(String[] args) throws IOException {
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        //PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("milkvisits.out")));
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        init(20, 2520, 1024);
        int t = Integer.parseInt(f.readLine());
        while(t-- > 0) {
            StringTokenizer st = new StringTokenizer(f.readLine());
            long l = Long.parseLong(st.nextToken());
            long r = Long.parseLong(st.nextToken());
            out.println(query(Long.toString(r))-query(Long.toString(l-1)));
        }
        f.close();
        out.close();
    }
}