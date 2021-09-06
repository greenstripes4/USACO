import java.io.*;
import java.util.*;

public class Main {
    private static int[] A;
    private static long countSplitInversions(int l1, int r1, int l2, int r2) {
        int temp = l1;
        int[] sorted = new int[r2-l1+1];
        int k = 0;
        long ans = 0;
        while(l1 <= r1 || l2 <= r2) {
            if(l1 > r1) {
                sorted[k++] = A[l2++];
            } else if(l2 > r2) {
                sorted[k++] = A[l1++];
            } else if(A[l1] <= A[l2]) {
                sorted[k++] = A[l1++];
            } else {
                sorted[k++] = A[l2++];
                ans += r1-l1+1;
            }
        }
        for(int i = 0; i < sorted.length; i++) {
            A[i+temp] = sorted[i];
        }
        return ans;
    }
    private static long countInversions(int l, int r) {
        if(l == r) {
            return 0;
        }
        int m = (l+r)/2;
        long left = countInversions(l, m);
        long right = countInversions(m+1, r);
        long split = countSplitInversions(l, m, m+1, r);
        return left+right+split;
    }
    public static void main(String[] args) throws IOException {
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        while(true) {
            int n = Integer.parseInt(f.readLine());
            if(n == 0) {
                break;
            }
            A = new int[n];
            for(int i = 0; i < n; i++) {
                A[i] = Integer.parseInt(f.readLine());
            }
            out.println(countInversions(0, n-1));
        }
        f.close();
        out.close();
    }
}