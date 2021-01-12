import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        StringTokenizer st = new StringTokenizer(f.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int x = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());
        char[][] image = new char[n][];
        int[] blackPixels = new int[m+1];
        int[] whitePixels = new int[m+1];
        for(int i = 0; i < n; i++) {
            image[i] = f.readLine().toCharArray();
            for(int j = 0; j < m; j++) {
                if(image[i][j] == '#') {
                    blackPixels[j+1]++;
                } else {
                    whitePixels[j+1]++;
                }
            }
        }
        for(int i = 2; i <= m; i++) {
            blackPixels[i] += blackPixels[i-1];
        }
        for(int i = 2; i <= m; i++) {
            whitePixels[i] += whitePixels[i-1];
        }
        int[][] dp = new int[m+1][2];
        for(int i = 1; i <= m; i++) {
            dp[i][0] = n*m+1;
            dp[i][1] = n*m+1;
            for(int j = x; j <= y && i-j >= 0; j++) {
                dp[i][0] = Math.min(dp[i][0], dp[i-j][1]+blackPixels[i]-blackPixels[i-j]);
                dp[i][1] = Math.min(dp[i][1], dp[i-j][0]+whitePixels[i]-whitePixels[i-j]);
            }
        }
        out.println(Math.min(dp[m][0], dp[m][1]));
        f.close();
        out.close();
    }
}
