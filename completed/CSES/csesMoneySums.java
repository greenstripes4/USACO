import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        int n = Integer.parseInt(f.readLine());
        StringTokenizer st = new StringTokenizer(f.readLine());
        int[] x = new int[n+1];
        int sum = 0;
        for(int i = 1; i <= n; i++) {
            x[i] = Integer.parseInt(st.nextToken());
            sum += x[i];
        }
        boolean[][] dp = new boolean[n+1][sum+1];
        for(int i = 0; i <= n; i++) {
            dp[i][0] = true;
        }
        for(int i = 1; i <= n; i++) {
            for(int j = 1; j <= sum; j++) {
                dp[i][j] = dp[i-1][j] || (j-x[i] >= 0 && dp[i-1][j-x[i]]);
            }
        }
        ArrayList<Integer> ans = new ArrayList<>();
        for(int i = 1; i <= sum; i++) {
            for(int j = 1; j <= n; j++) {
                if(dp[j][i]) {
                    ans.add(i);
                    break;
                }
            }
        }
        out.println(ans.size());
        out.print(ans.get(0));
        for(int i = 1; i < ans.size(); i++) {
            out.print(" " + ans.get(i));
        }
        out.println();
        f.close();
        out.close();
    }
}