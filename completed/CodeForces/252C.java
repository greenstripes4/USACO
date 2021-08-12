import java.io.*;
import java.util.*;

public class Main {
    private static int binarySearch(int[] arr, int tar) {
        int low = 0;
        int high = arr.length-1;
        int ans = arr.length;
        while(low <= high) {
            int mid = (low+high)/2;
            if(arr[mid] >= tar) {
                high = mid-1;
                ans = mid;
            } else {
                low = mid+1;
            }
        }
        return ans;
    }
    public static void main(String[] args) throws IOException {
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        StringTokenizer st = new StringTokenizer(f.readLine());
        int n = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(f.readLine());
        int[] x = new int[n];
        for(int i = 0; i < n; i++) {
            x[i] = Integer.parseInt(st.nextToken());
        }
        long ans = 0;
        for(int i = 0; i < n; i++) {
            long min = binarySearch(x, x[i]-d);
            ans += (i-min)*(i-min-1)/2;
        }
        out.println(ans);
        f.close();
        out.close();
    }
}
