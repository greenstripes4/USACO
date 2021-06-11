import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        //BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        //Scanner f = new Scanner(new File("uva.in"));
        Scanner f = new Scanner(System.in);
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        int t = f.nextInt();
        while(t-- > 0) {
            int n = f.nextInt();
            int[] a = new int[n];
            for(int i = 0; i < n; i++) {
                a[i] = f.nextInt();
            }
            HashMap<Integer, Long> map = new HashMap<>();
            map.put(a[0], 1L);
            long[] dp = new long[n];
            long ans = 0;
            for(int i = 1; i < n; i++) {
                dp[i] = dp[i-1]+map.getOrDefault(a[i], 0L);
                map.put(a[i], map.getOrDefault(a[i], 0L)+i+1);
                ans += dp[i];
            }
            out.println(ans);
        }
        f.close();
        out.close();
    }
}
