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
        int[] pref = new int[n+1];
        for(int i = 0; i < n; i++) {
            a[i] = Integer.parseInt(st.nextToken());
            pref[i+1] = pref[i]+a[i];
        }
        char[] s = f.readLine().toCharArray();
        int ans = 0;
        int cur = 0;
        for(int i = n-1; i >= 0; i--) {
            if(s[i] == '0') {
                continue;
            }
            ans = Math.max(ans, cur+pref[i]);
            cur += a[i];
            ans = Math.max(ans, cur);
        }
        out.println(ans);
        f.close();
        out.close();
    }
}
