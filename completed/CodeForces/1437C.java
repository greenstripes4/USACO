import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        //Scanner f = new Scanner(new File("uva.in"));
        //Scanner f = new Scanner(System.in);
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        int q = Integer.parseInt(f.readLine());
        while(q-- > 0) {
            int n = Integer.parseInt(f.readLine());
            StringTokenizer st = new StringTokenizer(f.readLine());
            int[] t = new int[n];
            for(int i = 0; i < n; i++) {
                t[i] = Integer.parseInt(st.nextToken());
            }
            Arrays.sort(t);
            int[][] dp = new int[n][400];
            for(int i = 1; i < 400; i++) {
                dp[0][i] = Math.abs(t[0]-i);
            }
            for(int i = 1; i < n; i++) {
                for(int j = 1; j < 400; j++) {
                    dp[i][j] = 20000;
                    for(int k = 1; k < j; k++) {
                        dp[i][j] = Math.min(dp[i][j], dp[i-1][k]+Math.abs(t[i]-j));
                    }
                }
            }
            int ans = 20000;
            for(int i = 1; i < 400; i++) {
                ans = Math.min(ans, dp[n-1][i]);
            }
            out.println(ans);
        }
        f.close();
        out.close();
    }
}