import java.io.*;
import java.util.*;

public class Main {
    private static int floor(int[] arr, int tar) {
        int low = 0;
        int high = arr.length-1;
        int ans = -1;
        while(low <= high) {
            int mid = (low+high)/2;
            if(arr[mid] <= tar) {
                low = mid+1;
                ans = mid;
            } else {
                high = mid-1;
            }
        }
        return ans;
    }
    private static int LIS(int[] arr) {
        int[] dp = new int[arr.length+1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        for(int i = 0; i < arr.length; i++) {
            int x = arr[i];
            int temp = floor(dp, x);
            dp[temp+1] = Math.min(dp[temp+1], x);
        }
        for(int i = arr.length; i >= 0; i--) {
            if(dp[i] < Integer.MAX_VALUE) {
                return i;
            }
        }
        return 0;
    }
    public static void main(String[] args) throws IOException {
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        StringTokenizer st = new StringTokenizer(f.readLine());
        int k1 = Integer.parseInt(st.nextToken());
        int k2 = Integer.parseInt(st.nextToken());
        int k3 = Integer.parseInt(st.nextToken());
        int[] arr = new int[k1+k2+k3];
        st = new StringTokenizer(f.readLine());
        for(int i = 0; i < k1; i++) {
            arr[Integer.parseInt(st.nextToken())-1] = 1;
        }
        st = new StringTokenizer(f.readLine());
        for(int i = 0; i < k2; i++) {
            arr[Integer.parseInt(st.nextToken())-1] = 2;
        }
        st = new StringTokenizer(f.readLine());
        for(int i = 0; i < k3; i++) {
            arr[Integer.parseInt(st.nextToken())-1] = 3;
        }
        out.println(k1+k2+k3-LIS(arr));
        f.close();
        out.close();
    }
}
