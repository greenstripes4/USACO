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
    public static void main(String[] args) throws IOException{
        //Scanner f = new Scanner(new File("uva.in"));
        //Scanner f = new Scanner(System.in);
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        StringTokenizer st = new StringTokenizer(f.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int ta = Integer.parseInt(st.nextToken());
        int tb = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(f.readLine());
        int[] a = new int[n];
        for(int i = 0; i < n; i++) {
            a[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(f.readLine());
        int[] b = new int[m];
        for(int i = 0; i < m; i++) {
            b[i] = Integer.parseInt(st.nextToken());
        }
        if(k >= n || k >= m) {
            out.println(-1);
        } else {
            int ans = 0;
            for(int i = 0; i <= k; i++) {
                int temp = binarySearch(b, a[i]+ta)+k-i;
                if(temp >= m) {
                    ans = -1;
                    break;
                }
                ans = Math.max(ans, b[temp]+tb);
            }
            out.println(ans);
        }
        f.close();
        out.close();
    }
}