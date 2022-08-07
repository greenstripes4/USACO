import java.io.*;
import java.util.*;

public class Main {
    private static char[] arr;
    private static long[][] dp;
    private static long dfs(int i, int j, boolean lim) {
        if(i == 0) {
            return j <= 3 ? 1 : 0;
        }
        if(!lim && dp[i][j] >= 0) {
            return dp[i][j];
        }
        int max = lim ? arr[i-1]-'0' : 9;
        long ans = dfs(i-1, j, lim && 0 == max);
        if(j < 3) {
            for(int k = 1; k <= max; k++) {
                ans += dfs(i-1, j+1, lim && k == max);
            }
        }
        if(!lim) {
            dp[i][j] = ans;
        }
        return ans;
    }
    public static void main(String[] args) throws IOException {
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        //PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("milkvisits.out")));
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        dp = new long[20][4];
        for(long[] i: dp) {
            Arrays.fill(i, -1);
        }
        int T = Integer.parseInt(f.readLine());
        while(T-- > 0) {
            StringTokenizer st = new StringTokenizer(f.readLine());
            String L = Long.toString(Long.parseLong(st.nextToken())-1);
            String R = st.nextToken();
            arr = L.toCharArray();
            for(int i = 0; i < arr.length/2; i++) {
                char temp = arr[i];
                arr[i] = arr[arr.length-i-1];
                arr[arr.length-i-1] = temp;
            }
            long a = dfs(arr.length, 0, true);
            arr = R.toCharArray();
            for(int i = 0; i < arr.length/2; i++) {
                char temp = arr[i];
                arr[i] = arr[arr.length-i-1];
                arr[arr.length-i-1] = temp;
            }
            long b = dfs(arr.length, 0, true);
            out.println(b-a);
        }
        f.close();
        out.close();
    }
}