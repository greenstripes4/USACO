import java.io.*;
import java.math.BigInteger;
import java.util.*;

public class Main {
    private static char[] arr;
    private static long[][] dp;
    private static int validate(int state) {
        return state == 0 ? 1 : 0;
    }
    private static int update(int state, int change) {
        return state-change;
    }
    private static long dfs(int i, int j, boolean flag) {
        if(i < 0) {
            return validate(j);
        }
        if(!flag && dp[i][j] != -1) {
            return dp[i][j];
        }
        char l = flag ? arr[i] : '1';
        long ans = 0;
        for(char k = '0'; k <= l; k++) {
            if(j == 0 && k == '1') {
                continue;
            }
            ans += dfs(i-1, update(j, k-'0'), flag && k == l);
        }
        if(!flag) {
            dp[i][j] = ans;
        }
        return ans;
    }
    private static long query(long n, int k) {
        arr = Long.toBinaryString(n).toCharArray();
        for(int i = 0; i < arr.length/2; i++) {
            char temp = arr[i];
            arr[i] = arr[arr.length-i-1];
            arr[arr.length-i-1] = temp;
        }
        return dfs(arr.length-1, k, true);
    }
    private static void init(int n, int m) {
        dp = new long[n][m];
        for(long[] i: dp) {
            Arrays.fill(i, -1);
        }
    }
    private static long binarySearch(long m, int k) {
        long low = 1;
        long high = 1000000000000000000L;
        while(low <= high) {
            long mid = (low+high)/2;
            long temp = query(mid*2, k)-query(mid, k);
            if(temp == m) {
                return mid;
            }
            if(temp < m) {
                low = mid+1;
            } else {
                high = mid-1;
            }
        }
        return -1;
    }
    public static void main(String[] args) throws IOException {
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        //PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("milkvisits.out")));
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        StringTokenizer st = new StringTokenizer(f.readLine());
        long m = Long.parseLong(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        init(65, k+1);
        out.println(binarySearch(m, k));
        f.close();
        out.close();
    }
}