import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        StringTokenizer st = new StringTokenizer(f.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(f.readLine());
        int[] h = new int[n];
        int max = 0;
        int min = 200000;
        for(int i = 0; i < n; i++) {
            h[i] = Integer.parseInt(st.nextToken());
            max = Math.max(max, h[i]);
            min = Math.min(min, h[i]);
        }
        Arrays.sort(h);
        int idx = n-1;
        int ans = 0;
        int cur = 0;
        for(int i = max; i > min; i--) {
            while(idx >= 0 && h[idx] >= i) {
                idx--;
            }
            int cost = n-idx-1;
            if(cur+cost > k) {
                ans++;
                cur = 0;
            }
            cur += cost;
        }
        if(cur > 0) {
            ans++;
        }
        out.println(ans);
        f.close();
        out.close();
    }
}
