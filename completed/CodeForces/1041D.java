import java.io.*;
import java.util.*;

public class Main {
    private static int binarySearch(int[][] arr, int tar) {
        int low = 0;
        int high = arr.length-1;
        int ans = -1;
        while(low <= high) {
            int mid = (low+high)/2;
            if(arr[mid][0] <= tar) {
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
        StringTokenizer st = new StringTokenizer(f.readLine());
        int n = Integer.parseInt(st.nextToken());
        int h = Integer.parseInt(st.nextToken());
        int[][] arr = new int[n][2];
        int[] prefixSum = new int[n+1];
        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(f.readLine());
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
            prefixSum[i+1] = prefixSum[i]+arr[i][1]-arr[i][0];
        }
        int max = 0;
        for(int i = 0; i < n; i++) {
            int low = arr[i][1];
            int high = 2000000000;
            int ans = -1;
            while(low <= high) {
                int mid = low+(high-low)/2;
                int temp = binarySearch(arr, mid);
                if(arr[i][0]+h+prefixSum[temp]-prefixSum[i]+Math.min(mid-arr[temp][0], arr[temp][1]-arr[temp][0]) > mid) {
                    ans = mid;
                    low = mid+1;
                } else {
                    high = mid-1;
                }
            }
            max = Math.max(max, ans-arr[i][0]);
        }
        out.println(max+1);
        f.close();
        out.close();
    }
}
