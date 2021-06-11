import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        //Scanner f = new Scanner(new File("uva.in"));
        //Scanner f = new Scanner(System.in);
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        int[] dp = new int[200001];
        for(int i = 0; i < 9; i++) {
            dp[i] = 2;
        }
        dp[9] = 3;
        for(int i = 10; i <= 200000; i++) {
            dp[i] = (dp[i-9]+dp[i-10])%1000000007;
        }
        int t = Integer.parseInt(f.readLine());
        while(t-- > 0) {
            StringTokenizer st = new StringTokenizer(f.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            int ans = 0;
            while(n > 0) {
                int temp = n%10;
                ans = (ans+(temp+m < 10 ? 1 : dp[temp+m-10]))%1000000007;
                n /= 10;
            }
            out.println(ans);
        }
        f.close();
        out.close();
    }
}