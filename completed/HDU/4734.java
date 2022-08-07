import java.io.*;
import java.util.*;

public class Main {
    private static ArrayList<Integer> digits;
    private static int[][] dp;
    private static int dfs(int i, int j, boolean lim) {
        if(i == -1) {
            return j >= 0 ? 1 : 0;
        }
        if(!lim && dp[i][j] >= 0) {
            return dp[i][j];
        }
        int max = lim ? digits.get(i) : 9;
        int ans = 0;
        for(int k = 0; k <= max; k++) {
            if(k*(1 << i) <= j) {
                ans += dfs(i-1, j-k*(1 << i), lim && k == max);
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
        dp = new int[10][20480];
        for(int[] i: dp) {
            Arrays.fill(i, -1);
        }
        int T = Integer.parseInt(f.readLine());
        for(int t = 1; t <= T; t++) {
            StringTokenizer st = new StringTokenizer(f.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            digits = new ArrayList<>();
            while(B > 0) {
                digits.add(B%10);
                B /= 10;
            }
            int W = 0;
            int pow = 1;
            while(A > 0) {
                W += (A%10)*pow;
                A /= 10;
                pow <<= 2;
            }
            out.println("Case #" + t + ": " + dfs(digits.size()-1, W, true));
        }
        f.close();
        out.close();
    }
}