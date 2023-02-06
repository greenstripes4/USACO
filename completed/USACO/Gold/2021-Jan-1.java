import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        char[] str = f.readLine().toCharArray();
        int[] map = new int[26];
        int idx = 0;
        for(int i = 'a'; i <= 'z'; i++) {
            for(char j: str) {
                if(i == j) {
                    map[i-'a'] = idx++;
                    break;
                }
            }
        }
        int[][] adjacent = new int[20][20];
        for(int i = 0; i < str.length-1; i++) {
            adjacent[map[str[i]-'a']][map[str[i+1]-'a']]++;
        }
        int[] dp = new int[1 << 20];
        dp[0] = 1;
        for(int i = 1; i < 1 << 20; i++) {
            dp[i] = Integer.MAX_VALUE;
            for(int j = 0; j < 20; j++) {
                if((i&(1 << j)) > 0) {
                    int sum = 0;
                    for(int k = 0; k < 20; k++) {
                        if((i&(1 << k)) > 0) {
                            sum += adjacent[j][k];
                        }
                    }
                    dp[i] = Math.min(dp[i], dp[i^(1 << j)]+sum);
                }
            }
        }
        out.println(dp[(1 << 20)-1]);
        f.close();
        out.close();
    }
}
