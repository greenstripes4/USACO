import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        String input;
        while((input = f.readLine()) != null) {
            StringTokenizer st = new StringTokenizer(input);
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            int[][] arr = new int[n][m];
            for(int i = 0; i < n; i++) {
                st = new StringTokenizer(f.readLine());
                for(int j = 0; j < m; j++) {
                    arr[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            int[][] dp = new int[m][n];
            String[][] sequence = new String[m][n];
            for(int i = 0; i < n; i++) {
                dp[0][i] = arr[i][0];
                sequence[0][i] = Integer.toString(i+1);
            }
            for(int i = 1; i < m; i++) {
                for(int j = 0; j < n; j++) {
                    dp[i][j] = Integer.MAX_VALUE;
                    for(int k = -1; k <= 1; k++) {
                        int prev = (j+k+n)%n;
                        if(dp[i-1][prev]+arr[j][i] < dp[i][j] || (dp[i-1][prev]+arr[j][i] == dp[i][j] &&
                                (sequence[i-1][prev]+" "+(j+1)).compareTo(sequence[i][j]) < 0)) {
                            dp[i][j] = dp[i-1][prev]+arr[j][i];
                            sequence[i][j] = sequence[i-1][prev]+" "+(j+1);
                        }
                    }
                }
            }
            int min = 0;
            for(int i = 1; i < n; i++) {
                if(dp[m-1][i] < dp[m-1][min] || (dp[m-1][i] == dp[m-1][min] &&
                        sequence[m-1][i].compareTo(sequence[m-1][min]) < 0)) {
                    min = i;
                }
            }
            out.println(sequence[m-1][min]);
            out.println(dp[m-1][min]);
        }
        f.close();
        out.close();
    }
}