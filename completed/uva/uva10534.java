import java.io.*;
import java.util.*;

public class Main{
    private static int binarySearch(int[] arr, int target) {
        int low = 0;
        int high = arr.length-1;
        int ans = 0;
        while(low <= high) {
            int mid = (low+high)/2;
            if(arr[mid] < target) {
                low = mid+1;
                ans = mid;
            } else {
                high = mid-1;
            }
        }
        return ans;
    }
    private static int[] getLIS(int[] arr) {
        int[] dp = new int[arr.length+1];
        int[] translatedLIS = new int[arr.length];
        dp[0] = Integer.MIN_VALUE;
        for(int i = 1; i <= arr.length; i++) {
            dp[i] = Integer.MAX_VALUE;
        }
        for(int i = 0; i < arr.length; i++) {
            int length = binarySearch(dp, arr[i]);
            dp[length+1] = Math.min(dp[length+1], arr[i]);
            translatedLIS[i] = length+1;
        }
        return translatedLIS;
    }
    private static void reverse(int[] arr) {
        for(int i = 0; i < arr.length/2; i++) {
            int temp = arr[i];
            arr[i] = arr[arr.length-i-1];
            arr[arr.length-i-1] = temp;
        }
    }
    public static void main(String[] args) throws IOException{
        //Scanner f = new Scanner(new File("uva.in"));
        Scanner f = new Scanner(System.in);
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        //BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        while(f.hasNext()) {
            int N = f.nextInt();
            int[] arr = new int[N];
            for(int i = 0; i < N; i++) {
                arr[i] = f.nextInt();
            }
            int[] LIS = getLIS(arr);
            reverse(arr);
            int[] LDS = getLIS(arr);
            reverse(LDS);
            int max = 0;
            for(int i = 0; i < N; i++) {
                max = Math.max(max, 2*Math.min(LIS[i], LDS[i])-1);
            }
            out.println(max);
        }
        f.close();
        out.close();
    }
}
