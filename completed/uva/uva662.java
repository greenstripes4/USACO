import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        int t = 1;
        while(true) {
            StringTokenizer st = new StringTokenizer(f.readLine());
            int n = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());
            if(n == 0 && k == 0) {
                break;
            }
            int[] d = new int[n+1];
            for(int i = 1; i <= n; i++) {
                d[i] = Integer.parseInt(f.readLine());
            }
            int[] pref = new int[n+1];
            for(int i = 1; i <= n; i++) {
                pref[i] = pref[i-1]+d[i];
            }
            int[][][] dp = new int[n+1][k+1][2];
            for(int i = 1; i <= n; i++) {
                dp[i][0][0] = Integer.MAX_VALUE/2;
                for(int j = 1; j <= k; j++) {
                    dp[i][j][0] = Integer.MAX_VALUE/2;
                    for(int l = 1; l <= i; l++) {
                        int m = (l+i)/2;
                        int temp = pref[i]-pref[m-1]-(i-m+1)*d[m]+(m-l)*d[m]-(pref[m-1]-pref[l-1]);
                        if(temp+dp[l-1][j-1][0] < dp[i][j][0]) {
                            dp[i][j][0] = temp+dp[l-1][j-1][0];
                            dp[i][j][1] = l;
                        }
                    }
                }
            }
            out.println("Chain " + t++);
            Stack<String> res = new Stack<>();
            int cur = k;
            int last = n;
            while(cur > 0) {
                String temp = "Depot " + cur + " at restaurant " + (dp[last][cur][1]+last)/2;
                if(dp[last][cur][1] == last) {
                    temp += " serves restaurant " + last;
                    last--;
                } else {
                    temp += " serves restaurants " + dp[last][cur][1] + " to " + last;
                    last = dp[last][cur][1]-1;
                }
                res.push(temp);
                cur--;
            }
            while(!res.isEmpty()) {
                out.println(res.pop());
            }
            out.println("Total distance sum = " + dp[n][k][0]);
            out.println();
        }
        f.close();
        out.close();
    }
}