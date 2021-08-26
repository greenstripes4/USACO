import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        int n = Integer.parseInt(f.readLine());
        StringTokenizer st = new StringTokenizer(f.readLine());
        int[] a = new int[n];
        for(int i = 0; i < n; i++) {
            a[i] = Integer.parseInt(st.nextToken());
        }
        boolean[] stable = new boolean[n];
        for(int i = 1; i < n-1; i++) {
            if(a[i] == a[i-1] || a[i] == a[i+1]) {
                stable[i] = true;
            }
        }
        stable[0] = true;
        stable[n-1] = true;
        int max = 0;
        int cur = 0;
        for(boolean i: stable) {
            if(i) {
                max = Math.max(max, cur);
                cur = 0;
            } else {
                cur++;
            }
        }
        out.println((max+1)/2);
        int[] left = new int[n];
        int[] right = new int[n];
        for(int i = 0; i < n; i++) {
            if(stable[i]) {
                left[i] = i;
            } else {
                left[i] = left[i-1];
            }
        }
        for(int i = n-1; i >= 0; i--) {
            if(stable[i]) {
                right[i] = i;
            } else {
                right[i] = right[i+1];
            }
        }
        int[] res = new int[n];
        for(int i = 0; i < n; i++) {
            int d1 = i-left[i];
            int d2 = right[i]-i;
            if(d1 < d2) {
                res[i] = a[left[i]];
            } else {
                res[i] = a[right[i]];
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