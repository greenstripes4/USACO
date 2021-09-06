import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        String input;
        while((input = f.readLine()) != null) {
            char[] s = input.toCharArray();
            int[][] dp = new int[s.length][s.length];
            String[][] res = new String[s.length][s.length];
            for(int i = s.length-1; i >= 0; i--) {
                dp[i][i] = 1;
                res[i][i] = ""+s[i];
                for(int j = i+1; j < s.length; j++) {
                    if(s[i] == s[j]) {
                        if(i+1 > j-1) {
                            dp[i][j] = 2;
                            res[i][j] = ""+s[i]+s[j];
                        } else {
                            dp[i][j] = dp[i+1][j-1]+2;
                            res[i][j] = s[i]+res[i+1][j-1]+s[j];
                        }
                    } else {
                        if(dp[i+1][j] > dp[i][j-1] || (dp[i+1][j] == dp[i][j-1] && res[i+1][j].compareTo(res[i][j-1]) < 0)) {
                            dp[i][j] = dp[i+1][j];
                            res[i][j] = res[i+1][j];
                        } else {
                            dp[i][j] = dp[i][j-1];
                            res[i][j] = res[i][j-1];
                        }
                    }
                }
            }
            out.println(res[0][s.length-1]);
        }
        f.close();
        out.close();
    }
}