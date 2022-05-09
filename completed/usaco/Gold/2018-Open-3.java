import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader f = new BufferedReader(new FileReader("talent.in"));
        //BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("talent.out")));
        StringTokenizer st = new StringTokenizer(f.readLine());
        int N = Integer.parseInt(st.nextToken());
        int W = Integer.parseInt(st.nextToken());
        int[][] arr = new int[N][2];
        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(f.readLine());
            arr[i][0] = Integer.parseInt(st.nextToken())*1000;
            arr[i][1] = Integer.parseInt(st.nextToken())*1000;
        }
        int low = 0;
        int high = 1000000000;
        int ans = 0;
        while(low <= high) {
            int mid = (low+high)/2;
            long[][] dp = new long[N+1][W+1];
            for(long[] i: dp) {
                Arrays.fill(i, -1000000000000000000L);
            }
            dp[0][0] = 0;
            for(int i = 1; i <= N; i++) {
                for(int j = 0; j <= W; j++) {
                    dp[i][j] = Math.max(dp[i-1][j], dp[i-1][Math.max(0, j-arr[i-1][0]/1000)]+1000L*arr[i-1][1]-(long) mid*arr[i-1][0]);
                }
            }
            if(dp[N][W] >= 0) {
                low = mid+1;
                ans = mid;
            } else {
                high = mid-1;
            }
        }
        out.println(ans);
        f.close();
        out.close();
    }
}
