import java.io.*;
import java.util.*;

public class Main{
    public static void main(String[] args) throws IOException{
        //Scanner f = new Scanner(new File("uva.in"));
        Scanner f = new Scanner(System.in);
        //BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        int n = f.nextInt();
        int[] a = new int[n];
        int sum = 0;
        for(int i = 0; i < n; i++) {
            a[i] = f.nextInt();
            sum += a[i];
        }
        if(sum%2 == 0) {
            boolean[][] dp = new boolean[n+1][sum/2+1];
            dp[0][0] = true;
            for(int i = 1; i <= n; i++) {
                for(int j = 0; j <= sum/2; j++) {
                    dp[i][j] = dp[i-1][j];
                    if(a[i-1] <= j) {
                        dp[i][j] |= dp[i-1][j-a[i-1]];
                    }
                }
            }
            boolean valid = false;
            for(int i = 0; i <= n; i++) {
                if(dp[i][sum/2]) {
                    valid = true;
                    break;
                }
            }
            if(valid) {
                out.println(1);
                int idx = -1;
                int left = 32;
                for(int i = 1; i < n; i++) {
                    int temp = 0;
                    while((a[i]&(1 << temp)) == 0) {
                        temp++;
                    }
                    if(temp < left) {
                        idx = i;
                        left = temp;
                    }
                }
                out.println(idx+1);
            } else {
                out.println(0);
            }
        } else {
            out.println(0);
        }
        f.close();
        out.close();
    }
}