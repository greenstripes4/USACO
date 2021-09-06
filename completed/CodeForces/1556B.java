import java.io.*;
import java.util.*;

public class Main {
    private static long solve(int n, int[] a, int[] t) {
        long ans = 0;
        int[] j = {0, 0};
        for(int i = 0; i < n; i++) {
            j[0] = Math.max(j[0], i);
            j[1] = Math.max(j[1], i);
            if(a[i] != t[i]) {
                int other = a[i]^1;
                while(a[j[other]] != other) {
                    j[other]++;
                }
                a[j[other]] = a[i];
                a[i] = other;
                ans += j[other]-i;
                j[other]++;
            }
        }
        return ans;
    }
    public static void main(String[] args) throws IOException {
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        int t = Integer.parseInt(f.readLine());
        while(t-- > 0) {
            int n = Integer.parseInt(f.readLine());
            StringTokenizer st = new StringTokenizer(f.readLine());
            int[] a = new int[n];
            for(int i = 0; i < n; i++) {
                a[i] = Integer.parseInt(st.nextToken())%2;
            }
            int temp = 0;
            for(int i: a) {
                if(i == 0) {
                    temp--;
                } else {
                    temp++;
                }
            }
            long ans = -1;
            if(temp == 0 || temp == -1) {
                int[] tar = new int[n];
                for(int i = 0; i < n; i++) {
                    tar[i] = i%2;
                }
                ans = solve(n, a, tar);
            }
            if(temp == 0 || temp == 1) {
                int[] tar = new int[n];
                for(int i = 0; i < n; i++) {
                    tar[i] = (i%2)^1;
                }
                long cur = solve(n, a, tar);
                if(ans == -1 || cur < ans) {
                    ans = cur;
                }
            }
            out.println(ans);
        }
        f.close();
        out.close();
    }
}