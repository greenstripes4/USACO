import java.io.*;
import java.util.*;

public class Main {
    private static int binarySearch(int[] a, int tar) {
        int low = 0;
        int high = a.length-1;
        int ans = -1;
        while(low <= high) {
            int mid = (low+high)/2;
            if(a[mid] <= tar) {
                ans = mid;
                low = mid+1;
            } else {
                high = mid-1;
            }
        }
        return ans;
    }
    public static void main(String[] args) throws IOException{
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        int[][] dp = new int[200000][100];
        for(int i = 0; i < 200000; i++) {
            dp[i][0] = 1;
        }
        for(int j = 1; j < 100; j++) {
            dp[0][j] = 0;
        }
        for(int i = 1; i < 200000; i++) {
            int limit = Math.min(i+1, 100);
            for(int j = 1; j < limit; j++) {
                dp[i][j] = (dp[i-1][j]+dp[i-1][j-1])%1000000007;
            }
        }
        int t = Integer.parseInt(f.readLine());
        for(int i = 0; i < t; i++) {
            StringTokenizer st = new StringTokenizer(f.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());
            st = new StringTokenizer(f.readLine());
            int[] a = new int[n];
            for(int j = 0; j < n; j++) {
                a[j] = Integer.parseInt(st.nextToken());
            }
            Arrays.sort(a);
            int ans = 0;
            for(int j = 0; j < n; j++) {
                int max = binarySearch(a, a[j]+k);
                ans = (ans+dp[max-j][m-1])%1000000007;
            }
            out.println(ans);
        }
        f.close();
        out.close();
    }
}