import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader f = new BufferedReader(new FileReader("teamwork.in"));
        //BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("teamwork.out")));
        StringTokenizer st = new StringTokenizer(f.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int[] arr = new int[N+1];
        for(int i = 1; i <= N; i++) {
            arr[i] = Integer.parseInt(f.readLine());
        }
        int[] dp = new int[N+1];
        for(int i = 1; i <= N; i++) {
            int max = 0;
            for(int j = i; j >= Math.max(1, i-K+1); j--) {
                max = Math.max(max, arr[j]);
                dp[i] = Math.max(dp[i], dp[j-1]+max*(i-j+1));
            }
        }
        out.println(dp[N]);
        f.close();
        out.close();
    }
}
