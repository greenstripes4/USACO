import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        int n = Integer.parseInt(f.readLine());
        StringTokenizer st = new StringTokenizer(f.readLine());
        int[] c = new int[n];
        for(int i = 0; i < n; i++) {
            c[i] = Integer.parseInt(st.nextToken());
        }
        String[][] arr = new String[n][2];
        for(int i = 0; i < n; i++) {
            arr[i][0] = f.readLine();
            char[] temp = arr[i][0].toCharArray();
            for(int j = 0; j < temp.length/2; j++) {
                char temp2 = temp[j];
                temp[j] = temp[temp.length-j-1];
                temp[temp.length-j-1] = temp2;
            }
            arr[i][1] = new String(temp);
        }
        long[][] dp = new long[n][2];
        dp[0][0] = 0;
        dp[0][1] = c[0];
        for(int i = 1; i < n; i++) {
            dp[i][0] = -1;
            dp[i][1] = -1;
            if(dp[i-1][0] >= 0) {
                if(arr[i-1][0].compareTo(arr[i][0]) <= 0) {
                    if(dp[i][0] < 0 || dp[i-1][0] < dp[i][0]) {
                        dp[i][0] = dp[i-1][0];
                    }
                }
                if(arr[i-1][0].compareTo(arr[i][1]) <= 0) {
                    if(dp[i][1] < 0 || dp[i-1][0]+c[i] < dp[i][1]) {
                        dp[i][1] = dp[i-1][0]+c[i];
                    }
                }
            }
            if(dp[i-1][1] >= 0) {
                if(arr[i-1][1].compareTo(arr[i][0]) <= 0) {
                    if(dp[i][0] < 0 || dp[i-1][1] < dp[i][0]) {
                        dp[i][0] = dp[i-1][1];
                    }
                }
                if(arr[i-1][1].compareTo(arr[i][1]) <= 0) {
                    if(dp[i][1] < 0 || dp[i-1][1]+c[i] < dp[i][1]) {
                        dp[i][1] = dp[i-1][1]+c[i];
                    }
                }
            }
        }
        if(dp[n-1][0] < 0) {
            out.println(dp[n-1][1]);
        } else if(dp[n-1][1] < 0) {
            out.println(dp[n-1][0]);
        } else {
            out.println(Math.min(dp[n-1][0], dp[n-1][1]));
        }
        f.close();
        out.close();
    }
}
