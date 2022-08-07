import java.io.*;
import java.util.*;

public class Main {
    private static char[] n;
    private static int[][] dp2;
    private static int dfs(int i, int j, boolean lim) {
        if(j < 0) {
            return 0;
        }
        if(i == n.length) {
            return j == 0 ? 1 : 0;
        }
        if(!lim && dp2[i][j] >= 0) {
            return dp2[i][j];
        }
        char max = lim ? n[i] : '1';
        int ans = 0;
        for(char k = '0'; k <= max; k++) {
            ans = (ans+dfs(i+1, j-(k-'0'), lim && k == max))%1000000007;
        }
        if(!lim) {
            dp2[i][j] = ans;
        }
        return ans;
    }
    public static void main(String[] args) throws IOException {
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        //PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("milkvisits.out")));
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        n = f.readLine().toCharArray();
        int k = Integer.parseInt(f.readLine());
        if(k == 0) {
            out.println(1);
        } else {
            int[] dp1 = new int[1000];
            dp2 = new int[n.length][1000];
            for(int[] i: dp2) {
                Arrays.fill(i, -1);
            }
            int ans = 0;
            if(k == 1) {
                out.println((dfs(0, 1, true)+1000000006)%1000000007);
            } else {
                for(int i = 2; i < 1000; i++) {
                    dp1[i] = dp1[Integer.bitCount(i)]+1;
                    if(dp1[i] == k-1) {
                        ans = (ans+dfs(0, i, true))%1000000007;
                    }
                }
                out.println(ans);
            }
        }
        f.close();
        out.close();
    }
}