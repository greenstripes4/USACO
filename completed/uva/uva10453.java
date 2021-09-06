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
            int[][] backtrack = new int[s.length][s.length];
            for(int i = s.length-1; i >= 0; i--) {
                for(int j = i; j < s.length; j++) {
                    if(s[i] == s[j]) {
                        if(i+1 >= j-1) {
                            dp[i][j] = 0;
                        } else {
                            dp[i][j] = dp[i+1][j-1];
                        }
                        backtrack[i][j] = 2;
                    } else {
                        if(dp[i+1][j] <= dp[i][j-1]) {
                            dp[i][j] = dp[i+1][j]+1;
                        } else {
                            dp[i][j] = dp[i][j-1]+1;
                            backtrack[i][j] = 1;
                        }
                    }
                }
            }
            StringBuilder sb = new StringBuilder();
            int i = 0;
            int j = s.length-1;
            while(i < j) {
                if(backtrack[i][j] == 0) {
                    sb.append(s[i++]);
                } else if(backtrack[i][j] == 1) {
                    sb.append(s[j--]);
                } else {
                    sb.append(s[i++]);
                    j--;
                }
            }
            String temp = sb.toString();
            if(i == j) {
                temp += s[i];
            }
            sb.reverse();
            temp += sb;
            out.println(dp[0][s.length-1] + " " + temp);
        }
        f.close();
        out.close();
    }
}