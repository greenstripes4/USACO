import java.io.*;
import java.util.*;

public class Main {
    private static int[][] dp;
    private static int[][] convert;
    private static int[] res;
    private static boolean dfs(int pos, int k) {
        if(pos == res.length) {
            return k == 0;
        }
        if(dp[pos][k] > 0) {
            return true;
        }
        if(dp[pos][k] < 0) {
            return false;
        }
        for(int i = 9; i >= 0; i--) {
            if(convert[pos][i] >= 0 && convert[pos][i] <= k && dfs(pos+1, k-convert[pos][i])) {
                dp[pos][k] = 1;
                res[pos] = i;
                return true;
            }
        }
        dp[pos][k] = -1;
        return false;
    }
    public static void main(String[] args) throws IOException {
        //Scanner f = new Scanner(new File("uva.in"));
        //Scanner f = new Scanner(System.in);
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        StringTokenizer st = new StringTokenizer(f.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int[] digits = {119, 18, 93, 91, 58, 107, 111, 82, 127, 123};
        convert = new int[n][10];
        for(int i = 0; i < n; i++) {
            Arrays.fill(convert[i], -1);
            int cur = Integer.parseInt(f.readLine(), 2);
            for(int j = 0; j < 10; j++) {
                if((cur | digits[j]) == digits[j]) {
                    convert[i][j] = Integer.bitCount(cur^digits[j]);
                }
            }
        }
        dp = new int[n][k+1];
        res = new int[n];
        if(dfs(0, k)) {
            for(int i: res) {
                out.print(i);
            }
            out.println();
        } else {
            out.println(-1);
        }
        f.close();
        out.close();
    }
}