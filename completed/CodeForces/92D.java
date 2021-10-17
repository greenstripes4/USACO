import java.io.*;
import java.util.*;

public class Main {
    private static int lower(int[] arr, int tar) {
        int low = 0;
        int high = arr.length-1;
        int ans = -1;
        while(low <= high) {
            int mid = (low+high)/2;
            if(arr[mid] < tar) {
                low = mid+1;
                ans = mid;
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
        int[] a = new int[n];
        for(int i = 0; i < n; i++) {
            a[i] = Integer.parseInt(st.nextToken());
        }
        int[] suff = new int[n];
        suff[n-1] = a[n-1];
        for(int i = n-2; i >= 0; i--) {
            suff[i] = Math.min(a[i], suff[i+1]);
        }
        int[] res = new int[n];
        for(int i = 0; i < n; i++) {
            int idx = lower(suff, a[i]);
            if(idx <= i) {
                res[i] = -1;
            } else {
                res[i] = idx-i-1;
            }
        }
        out.print(res[0]);
        for(int i = 1; i < n; i++) {
            out.print(" " + res[i]);
        }
        out.println();
        f.close();
        out.close();
    }
}
