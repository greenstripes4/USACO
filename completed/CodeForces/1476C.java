import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        //Scanner f = new Scanner(new File("uva.in"));
        //Scanner f = new Scanner(System.in);
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        int t = Integer.parseInt(f.readLine());
        while(t-- > 0) {
            int n = Integer.parseInt(f.readLine());
            StringTokenizer st = new StringTokenizer(f.readLine());
            int[] c = new int[n];
            for(int i = 0; i < n; i++) {
                c[i] = Integer.parseInt(st.nextToken());
            }
            st = new StringTokenizer(f.readLine());
            int[] a = new int[n];
            for(int i = 0; i < n; i++) {
                a[i] = Integer.parseInt(st.nextToken());
            }
            st = new StringTokenizer(f.readLine());
            int[] b = new int[n];
            for(int i = 0; i < n; i++) {
                b[i] = Integer.parseInt(st.nextToken());
            }
            long[] dp = new long[n];
            dp[0] = 0;
            dp[1] = c[1]+1+Math.abs(a[1]-b[1]);
            long max = Math.max(dp[0], dp[1]);
            for(int i = 2; i < n; i++) {
                if(a[i] == b[i]) {
                    dp[i] = c[i]+1;
                } else {
                    int d = Math.abs(a[i]-b[i]);
                    dp[i] = Math.max(d, dp[i-1]-d)+c[i]+1;
                }
                max = Math.max(max, dp[i]);
            }
            out.println(max);
        }
        f.close();
        out.close();
    }
}
