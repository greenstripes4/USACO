import java.io.*;
import java.util.*;

public class Main {
    private static char[] A;
    private static long countSplitInversions(int l1, int r1, int l2, int r2) {
        int temp = l1;
        char[] sorted = new char[r2-l1+1];
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
        int q = Integer.parseInt(f.readLine());
        while(q-- > 0) {
            int n = Integer.parseInt(f.readLine());
            char[] s = f.readLine().toCharArray();
            char[] t = f.readLine().toCharArray();
            int[] occ1 = new int[26];
            for(char i: s) {
                occ1[i-'a']++;
            }
            int[] occ2 = new int[26];
            for(char i: t) {
                occ2[i-'a']++;
            }
            if(!Arrays.equals(occ1, occ2)) {
                out.println("NO");
            } else {
                boolean flag = false;
                for(int i: occ1) {
                    if(i > 1) {
                        flag = true;
                        break;
                    }
                }
                if(flag) {
                    out.println("YES");
                } else {
                    A = s;
                    long inv1 = countInversions(0, n-1);
                    A = t;
                    long inv2 = countInversions(0, n-1);
                    out.println(inv1%2 == inv2%2 ? "YES" : "NO");
                }
            }
        }
        f.close();
        out.close();
    }
}
