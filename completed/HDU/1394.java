import java.io.*;
import java.util.*;

public class Main {
    private static int[] a;
    private static long countSplitInversions(int left, int right) {
        int[] arr = new int[right-left+1];
        int mid = (left+right)/2;
        int i = left;
        int j = mid+1;
        int k = 0;
        long count = 0;
        while(i <= mid || j <= right) {
            if(i > mid) {
                arr[k++] = a[j++];
            } else if(j > right) {
                arr[k++] = a[i++];
            } else {
                if(a[i] > a[j]) {
                    arr[k++] = a[j++];
                    count += mid-i+1;
                } else {
                    arr[k++] = a[i++];
                }
            }
        }
        k = 0;
        while(left <= right) {
            a[left++] = arr[k++];
        }
        return count;
    }
    private static long countInversions(int left, int right) {
        if(left >= right) {
            return 0;
        }
        return countInversions(left, (left+right)/2)+countInversions((left+right)/2+1, right)+countSplitInversions(left, right);
    }
    public static void main(String[] args) throws IOException{
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        //BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        Scanner f = new Scanner(System.in);
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        while(f.hasNext()) {
            int n = f.nextInt();
            int[] arr = new int[n];
            for(int i = 0; i < n; i++) {
                arr[i] = f.nextInt();
            }
            a = arr.clone();
            long min = countInversions(0, n-1);
            long cur = min;
            for(int i = 0; i < n-1; i++) {
                cur -= arr[i];
                cur += n-arr[i]-1;
                min = Math.min(min, cur);
            }
            out.println(min);
        }
        f.close();
        out.close();
    }
}