import java.io.*;
import java.util.*;

public class Main {
    private static int binarySearch(int[] arr, int tar) {
        int low = 0;
        int high = arr.length-1;
        int ans = -1;
        while(low <= high) {
            int mid = (low+high)/2;
            if(arr[mid] < tar) {
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
        int n = Integer.parseInt(f.readLine());
        StringTokenizer st = new StringTokenizer(f.readLine());
        int[] dp = new int[n+1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        for(int i = 0; i < n; i++) {
            int x = Integer.parseInt(st.nextToken());
            int temp = binarySearch(dp, x);
            dp[temp+1] = Math.min(dp[temp+1], x);
        }
        for(int i = n; i >= 0; i--) {
            if(dp[i] < Integer.MAX_VALUE) {
                out.println(i);
                break;
            }
        }
        f.close();
        out.close();
    }
}