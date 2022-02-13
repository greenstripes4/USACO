import java.io.*;
import java.util.*;

public class Main {
    private static long solve(int[] remove, long x, int k, long y, int val) {
        if(remove.length == 0) {
            return 0;
        }
        if(remove.length < k) {
            for(int i: remove) {
                if(i > val) {
                    return -1;
                }
            }
            return y*remove.length;
        }
        if(y*k < x) {
            boolean flag = false;
            for(int i: remove) {
                if(i > val) {
                    flag = true;
                    break;
                }
            }
            if(!flag) {
                return y*remove.length;
            }
            return y*(remove.length-k)+x;
        }
        return y*(remove.length%k)+x*(remove.length/k);
    }
    public static void main(String[] args) throws IOException {
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        //PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("cowjump.out")));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        StringTokenizer st = new StringTokenizer(f.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(f.readLine());
        long x = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        long y = Integer.parseInt(st.nextToken());
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
        long min = 0;
        int idx = 0;
        int prev = 0;
        int left = 0;
        for(int i = 0; i < n && idx < m; i++) {
            if(a[i] == b[idx]) {
                int[] remove = new int[i-prev];
                for(int j = prev; j < i; j++) {
                    remove[j-prev] = a[j];
                }
                long temp = solve(remove, x, k, y, Math.max(left, a[i]));
                if(temp < 0) {
                    min = -1;
                    break;
                }
                min += temp;
                idx++;
                prev = i+1;
                left = a[i];
            }
        }
        if(idx < m) {
            out.println(-1);
        } else {
            int[] remove = new int[n-prev];
            for(int i = prev; i < n; i++) {
                remove[i-prev] = a[i];
            }
            long temp = solve(remove, x, k, y, left);
            if(temp < 0) {
                min = -1;
            } else {
                min += temp;
            }
            out.println(min);
        }
        out.close();
    }
}
